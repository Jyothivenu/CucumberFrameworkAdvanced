package org.common.Runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.common.Helper.Base_Class;
import org.common.Helper.Browser;
import org.common.Helper.Extent_Report;
import org.common.Helper.Property_File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src\\test\\resources\\features", glue = { "classpath:org.common.StepDefinition",
		"classpath:org.common.helper" }, plugin = { "html:cucumber-html-report/htmlreport.html",
				"com.cucumber.listener.ExtentCucumberFormatter:" }, monochrome = true)
public class runnerClass extends Base_Class {

	private TestNGCucumberRunner testNGCucumberRunner;
	public static String upDate;

	@BeforeSuite
	public void initBuild() {
		setUpEnv();
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("Setup for report");
		Date date= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
        upDate=sdf.format(date);
        Extent_Report.extentProperties = ExtentProperties.INSTANCE;
        Extent_Report.extentProperties.setReportPath(System.getProperty("user.dir")+"/cucumber-reports/"+ upDate+"_" +Property_File.getBrowser()+"_report.html");
        

	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		Extent_Report.writeExtentReport();
		testNGCucumberRunner.finish();
		TearDown();

	}
	
    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
            	WebDriver ldriver = Browser.driver;
    			TakesScreenshot ts = (TakesScreenshot) ldriver;
    			File source = ts.getScreenshotAs(OutputType.FILE);
    			Date date= new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
                String upDate=sdf.format(date);
                String dest = System.getProperty("user.dir")+"/Screenshots/ErrorScreenshots/"+ upDate+"_"+scenario.getName() +".png";
                File destinationPath = new File(dest);
    			FileUtils.copyFile(source, destinationPath);
    			Reporter.addScreenCaptureFromPath(destinationPath.toString());
    			
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//	@AfterSuite
//	public void onFinishExecution() {
//
//		System.out.println("this is After Suite block");
//	}

}


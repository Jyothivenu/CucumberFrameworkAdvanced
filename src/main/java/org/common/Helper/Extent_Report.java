package org.common.Helper;

import java.io.File;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

public class Extent_Report {
	
	public static ExtentProperties extentProperties;
	
	
	public static String getReportConfigPath(){		
        extentProperties.setProjectName("RRI Project");
        System.out.println(System.getProperty("user.dir"));
    	String reportConfigPath = System.getProperty("user.dir") + Property_File.getReportConfigPath();
    	return reportConfigPath;	
	
    }
	
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(getReportConfigPath()));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	System.getProperty("os.name"));
		Reporter.setTestRunnerOutput("Cucumber reporting using Extent Config");
		
	}

}

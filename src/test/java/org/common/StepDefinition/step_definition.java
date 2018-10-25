package org.common.StepDefinition;
import java.lang.reflect.Method;

import org.common.Helper.Browser;
import org.common.Helper.Property_File;
import org.common.PageObjects.basePage;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class step_definition {
	
	private WebDriver driver;
	String methodName;
	String className;
	Object objConstructor;
	Method objMethod;
	basePage objPage;

	public void invokeMethod(String methodName) throws Exception {

		driver = Browser.driver;
		String[] arrayOFParams = methodName.split("\\.");
		this.className = arrayOFParams[0];
		this.methodName = arrayOFParams[1];

		Method[] objMethods;
		Object objConstructor;

		Class aClass = Class.forName("org.common.PageObjects." + this.className);
		objConstructor = aClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		objMethods = aClass.getDeclaredMethods();
		for (Method m : objMethods) {

			if (m.getName().equals(this.methodName)) {
				Class[] parameterTypes = m.getParameterTypes();
				this.objMethod = aClass.getDeclaredMethod(this.methodName, parameterTypes);
			}
		}
		this.objConstructor = objConstructor;
	}

	@Given("^I Navigate browser to \"([^\"]*)\"$")
	public void i_Navigate_browser_to(String URL) throws Throwable {
		try {
			objPage = new basePage(Browser.driver);
			objPage.navigateTo(Browser.driver, Property_File.getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^I enter the \"([^\"]*)\"$")
	public void i_enter_the(String methodName) throws Throwable {
		try {
			invokeMethod(methodName);
			objMethod.invoke(objConstructor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^I click the \"([^\"]*)\"$")
	public void i_click_the(String methodName) throws Throwable {
		try {
			invokeMethod(methodName);
			objMethod.invoke(objConstructor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

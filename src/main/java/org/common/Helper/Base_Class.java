package org.common.Helper;

import org.openqa.selenium.WebDriver;

public class Base_Class  extends Browser {
	WebDriver ldriver = null;

	public void setUpEnv() {

		try {
			new Property_File();
			ldriver = setupTest(Property_File.getBrowser());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver setupTest(String browser) throws Exception {
		ldriver = getDriver(browser);
		return ldriver;
	}

	/**
	 * Function Tear down will execute after each test class.
	 */
	public void TearDown() {
		try {
			//driver.close();
			//Thread.sleep(4000);
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

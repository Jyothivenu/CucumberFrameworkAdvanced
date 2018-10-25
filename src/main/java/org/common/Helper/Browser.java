package org.common.Helper;


	import java.io.File;
	import java.util.HashMap;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Platform;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;

	public class Browser {

		private static final ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
		public static WebDriver driver;

		/**
		 * Function will return the driver instance depends upon the browser value
		 * passed.
		 *
		 * @param browser
		 *            the browser
		 * @return the driver
		 * @throws Exception
		 *             the exception
		 */


		public WebDriver getDriver(String browser) throws Exception {

			if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				capabilities.setCapability("acceptInsecureCerts", true);
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("dom.file.createInChild", true);
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				File file = new File("C:\\Downloads");
				String strPath = file.getAbsolutePath();
				profile.setPreference("browser.download.dir", strPath);
				profile.setPreference("browser.download.downloadDir", strPath);
				profile.setPreference("browser.download.defaultFolder", strPath);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext,text/plain,text,jpeg");
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				driver.manage().window().maximize();

			} else if (browser.equalsIgnoreCase("chrome")) {

				String downloadFilepath = "C:\\Downloads";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				DesiredCapabilities dwc = DesiredCapabilities.chrome();
				dwc.setPlatform(Platform.WINDOWS);
				dwc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				dwc.setCapability("unexpectedAlertBehaviour", "accept");
				dwc.setCapability(ChromeOptions.CAPABILITY, options);
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();

			}
			
			/*If using IE for testing then first do below steps:
			  1. Go to Tools -> Internet Options -> Security
			  2. Set all zones (Internet, Local intranet, Trusted sites, Restricted sites) to the same protected mode*/
			
			else if (browser.equalsIgnoreCase("IE")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/IEDriverServer.exe");
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				capabilities.setCapability("ie.ensureCleanSession", true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			}

			return driver;
		}


}

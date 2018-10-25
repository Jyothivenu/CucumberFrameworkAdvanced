package org.common.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_File {
	
	static Properties prop = new Properties();
	FileInputStream file;

	public Property_File() {

		try {
			prop = new Properties();
			file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ConfigFile/config.properties");
			prop.load(file);

		}

		catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getReportConfigPath() {
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
	

	public static String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public static String getURL() {
		return prop.getProperty("URL");
	}

	public static String getDriverPath() {
		return prop.getProperty("Driver_Path");
	}

	public static String getUserName() {
		return prop.getProperty("Username");
	}

	public static String getPassword() {
		return prop.getProperty("Password");
	}

	public static String getWebsite() {
		return prop.getProperty("URL");
	}

	public static String getSearchText() {
		return prop.getProperty("Search_Text");
	}

	public static int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public static int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public static int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	

	

}

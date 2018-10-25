package org.common.PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {

	
	public static WebDriver driver = null;
	public WebDriverWait wait = null;
	public FluentWait<WebDriver> flwait = null;
	
	public basePage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		this.flwait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		
		
	}

	public void waitUntilPageisReady(WebDriver driver) throws IOException {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		int time = 500 ;
		wait = new WebDriverWait(driver, time);
		wait.until(pageLoadCondition);
	}
	
	public void navigateTo(WebDriver driver, String url) throws IOException {
		waitUntilPageisReady(driver);
		driver.get(url);
	
		System.out.println("Page is loaded");
	}
}

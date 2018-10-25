package org.common.PageObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.common.Helper.Property_File;
import org.common.Helper.Wait_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import cucumber.api.java.it.Date;
	import java.util.Date;

	public class homePage {

		Wait_Helper wait;

		private WebDriver driver;

		@FindBy(xpath = "(//span[contains(.,'Amazon')])[1]")
		WebElement logo;

		//@FindBy(xpath = "(//span[@class='nav-line-1'])[3]")
		@FindBy(xpath ="//a[@class='nav-a nav-a-2'][@data-nav-role='signin']")
		WebElement signInLink;

		@FindBy(xpath = "//input[@id='ap_email']")
		WebElement email;

		@FindBy(xpath = "//input[@id='ap_password']")
		WebElement password;

		@FindBy(xpath = "//input[@id='continue']")
		WebElement continueButton;

		@FindBy(xpath = "//input[@id='signInSubmit']")
		WebElement signInButton;

		@FindBy(xpath = "//span[contains(.,'Hello, Jyothi')]")
		WebElement verifyLogin;

		@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
		WebElement searchTextBox;

		@FindBy(xpath = "//select[@id='searchDropdownBox']")
		WebElement searchDropDown;

		@FindBy(xpath = "(//input[@class='nav-input'])[1]")
		WebElement searchButton;

		@FindBy(xpath = "//div[@class='a-row a-spacing-small']//div[1][@class='a-row a-spacing-none']//span[@class='a-size-small a-color-secondary'][1]")
		WebElement publicationDate;

		@FindBy(xpath = "//select[@id='sort']")
		WebElement sortDropDown;

		String currentPublicationDate;

		ArrayList<Date> pb = new ArrayList<Date>();

		public homePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new Wait_Helper();
		}

		public void verifyLogo() {

			if (this.logo.isDisplayed()) {
				System.out.println("Amazon website opened");
			}
		}

		public void clickOnSignInLink() {

			this.signInLink.click();

		}

		public void enterEmail() {
			if (this.email.isDisplayed()) {
				System.out.println("Email field is present");
				this.email.sendKeys(Property_File.getUserName());
			} else {
				System.out.println("Email Id field is not displayed");
			}

		}

		public void clickOnContinue() {
			this.continueButton.click();
			wait.waitForElement(driver, password, Property_File.getExplicitWait());
		}

		public void enterPassword() {
			if (this.password.isDisplayed()) {
				System.out.println("Password field is present");
				this.password.sendKeys(Property_File.getPassword());
			} else {
				System.out.println("Password filed is not displayed");
			}

		}

		public void clickOnSignInButton() {

			this.signInButton.click();
		}

		public void verifyLoginSuccessful() {

			if (verifyLogin.isDisplayed()) {
				System.out.println("Login is successful");
			}

			else {
				System.out.println("Login failed");
			}
		}

		public void enterSearch() {
			this.searchTextBox.sendKeys(Property_File.getSearchText());
		}

		public void selectDropDownSearchType() {
			Select searchType = new Select(this.searchDropDown);
			searchType.selectByVisibleText("Kindle Store");
		}

		public void clickOnSearchButton() {
			this.searchButton.click();
			wait.waitForElement(driver, publicationDate, Property_File.getExplicitWait());
			System.out.println("Results generated");
		}

		public void selectSortDropDown() throws Exception {
			Select sortType = new Select(this.sortDropDown);
			sortType.selectByVisibleText("Publication Date");
			System.out.println("Sort drop down selected");
			wait.waitForElement(driver, publicationDate, Property_File.getExplicitWait());
			System.out.println("Results generated according to Publication date");
			Thread.sleep(3000);
		}

		public void printPublicatioDate() throws Exception {

			List<WebElement> date = driver.findElements(By.xpath(
					"//div[@class='a-row a-spacing-small']//div[1][@class='a-row a-spacing-none']//span[@class='a-size-small a-color-secondary'][1]"));

			for (int i = 0; i < date.size(); i++) {
				String currentPublicationDate = date.get(i).getText();
				System.out.println(currentPublicationDate);
				Date date1 = new SimpleDateFormat("dd MMMM yyyy").parse(currentPublicationDate);
				pb.add(date1);
			}

		}

		public void verifySortOrder() {
			Collections.sort(pb, Collections.reverseOrder());
			System.out.println("Sorted List");
			System.out.println(pb);
		}

}

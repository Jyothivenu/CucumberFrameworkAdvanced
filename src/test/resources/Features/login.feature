Feature: login to Amazon website 

Scenario: Login to Amazon website with correct credentials 
	Given I Navigate browser to "URL"
	Then I click the "homePage.clickOnSignInLink"
	Then I enter the "homePage.enterEmail"
	Then I click the "homePage.clickOnContinue"
	Then I enter the "homePage.enterPassword"
	Then I click the "homePage.clickOnSignInButton"
	Then I click the "homePage.verifyLoginSuccessful"
	Then I click the "homePage.selectDropDownSearchType" 
	Then I enter the "homePage.enterSearch"
	Then I click the "homePage.clickOnSearchButton" 
	Then I enter the "homePage.selectSortDropDown" 
	Then I enter the "homePage.printPublicatioDate" 
	Then I enter the "homePage.verifySortOrder"  
	
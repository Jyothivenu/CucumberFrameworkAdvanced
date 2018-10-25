$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "login to Amazon website",
  "description": "",
  "id": "login-to-amazon-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login to Amazon website with correct credentials",
  "description": "",
  "id": "login-to-amazon-website;login-to-amazon-website-with-correct-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I Navigate browser to \"URL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I click the \"homePage.clickOnSignInLink\"",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "I enter the \"homePage.enterEmail\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I click the \"homePage.clickOnContinue\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I enter the \"homePage.enterPassword\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I click the \"homePage.clickOnSignInButton\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click the \"homePage.verifyLoginSuccessful\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I click the \"homePage.selectDropDownSearchType\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I enter the \"homePage.enterSearch\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I click the \"homePage.clickOnSearchButton\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I enter the \"homePage.selectSortDropDown\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I enter the \"homePage.printPublicatioDate\"",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I enter the \"homePage.verifySortOrder\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "URL",
      "offset": 23
    }
  ],
  "location": "step_definition.i_Navigate_browser_to(String)"
});
formatter.result({
  "duration": 2837189450,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.clickOnSignInLink",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 1012479213,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.enterEmail",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 137234518,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.clickOnContinue",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 814756992,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.enterPassword",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 90885354,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.clickOnSignInButton",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 4796620914,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.verifyLoginSuccessful",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 43631816,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.selectDropDownSearchType",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 185546680,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.enterSearch",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 3113366713,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.clickOnSearchButton",
      "offset": 13
    }
  ],
  "location": "step_definition.i_click_the(String)"
});
formatter.result({
  "duration": 2223109289,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.selectSortDropDown",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 4190231554,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.printPublicatioDate",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 356533423,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "homePage.verifySortOrder",
      "offset": 13
    }
  ],
  "location": "step_definition.i_enter_the(String)"
});
formatter.result({
  "duration": 18801982,
  "status": "passed"
});
});
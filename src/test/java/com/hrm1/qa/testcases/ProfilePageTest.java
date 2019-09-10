package com.hrm1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm1.qa.base.TestBase;
import com.hrm1.qa.pages.HomePage;
import com.hrm1.qa.pages.LoginPage;
import com.hrm1.qa.pages.ProfilePage;
import com.hrm1.qa.util.TestUtil;

public class ProfilePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProfilePage profilePage;

	String sheetName ="profile";

	public ProfilePageTest() {
		super();
	}

	@Parameters("Browser")
	@BeforeMethod
	public void setup(String Browser) {

		initialization(Browser);
		testUtil = new TestUtil();
		profilePage = new ProfilePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = homePage.clickOnuserLink();
	}

	@Test(priority = 1)
	public void verifyuserLabel() {

		Assert.assertTrue(profilePage.verifyuserLabel(), "user label is missing on the page");

	}

	@Test(priority = 2)
	public void verifyvisualEditor() {
		boolean flag = profilePage.verifyvisualEditorcheckbox();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifysyntaxHiglightning() {
		boolean flag = profilePage.syntaxHighlightningcheckbox();
		Assert.assertTrue(flag);
	}

	@DataProvider
	public Object[][] getProfileTestData() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider="getProfileTestData")
	public void validateCreateNewProfile(String firstName, String lastName, String nickName, String email) {

		homePage.clickOnEditMyProfileLink();
		profilePage.createNewProfile(firstName, lastName, nickName, email);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.hrm1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm1.qa.base.TestBase;
import com.hrm1.qa.pages.HomePage;
import com.hrm1.qa.pages.LoginPage;
import com.hrm1.qa.pages.ProfilePage;
import com.hrm1.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProfilePage profilePage;

	public HomePageTest() {
		super();
	}

	@Parameters("Browser")
	@BeforeMethod
	
	public void setup(String Browser) {

		initialization(Browser);
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard ‹ opensourcecms — WordPress", "HomePageTitle not matched");

	}

	@Test(priority = 2)
	public void verifydashboardNameTest() {

		Assert.assertTrue(homePage.verifyCorrectdashboardName());

	}

	@Test(priority = 3)
	public void clickOnuserTest() {

		profilePage = homePage.clickOnuserLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}

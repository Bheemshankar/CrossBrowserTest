package com.hrm1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm1.qa.base.TestBase;
import com.hrm1.qa.pages.HomePage;
import com.hrm1.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser) {
		initialization(Browser);
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {

		String title = loginPage.validateLoginPageTitle();

		Assert.assertEquals(title, "Log In ‹ opensourcecms — WordPress");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {

		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
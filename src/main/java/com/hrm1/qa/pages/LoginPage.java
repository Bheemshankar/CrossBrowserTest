package com.hrm1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm1.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory OR
	@FindBy(id = "user_login")
	@CacheLookup
	WebElement username;

	@FindBy(id = "user_pass")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Powered by WordPress')]")
	@CacheLookup
	WebElement wordpressLogo;

	// Initializing the Page Objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return wordpressLogo.isDisplayed();

	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		System.out.println(username);
		password.sendKeys(pwd);
		System.out.println(password);

		WebDriverWait wait = new WebDriverWait(driver, 9);
		
		// WebElement
		// loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		loginBtn.click();

		return new HomePage();

	}

	}

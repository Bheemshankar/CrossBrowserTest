package com.hrm1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm1.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement DashboardLabel;

	@FindBy(xpath = "//a[contains(text(),'Howdy,')]")
	@CacheLookup
	WebElement userLink;

	@FindBy(xpath = "//a[contains(text(),'Edit My Profile')]")
	@CacheLookup
	WebElement EditMyProfileLink;

	@FindBy(xpath = "//div[contains(text(),'Users')]")
	@CacheLookup
	WebElement usersLink;

	@FindBy(xpath = "//div[contains(text(),'Pages')]")
	@CacheLookup
	WebElement pagesLink;

	@FindBy(xpath = "//div[contains(text(),'Settings')]")
	@CacheLookup
	WebElement settingsLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyCorrectdashboardName() {

		return DashboardLabel.isDisplayed();
	}

	public ProfilePage clickOnuserLink() {
		userLink.click();
		return new ProfilePage();
	}

	public void clickOnEditMyProfileLink() {
		Actions action = new Actions(driver);
		action.moveToElement(userLink).build().perform();
		EditMyProfileLink.click();
	}

}

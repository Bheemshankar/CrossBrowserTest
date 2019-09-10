package com.hrm1.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm1.qa.base.TestBase;

public class ProfilePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Howdy,')]")
	@CacheLookup
	WebElement userLabel;

	@FindBy(id = "rich_editing")
	@CacheLookup
	WebElement visualEditor;

	@FindBy(name = "syntax_highlighting")
	@CacheLookup
	WebElement syntaxHighlightning;

	@FindBy(xpath = "//tr[@class='show-admin-bar user-admin-bar-front-wrap']//label[1]")
	@CacheLookup
	WebElement toolBar;

	@FindBy(name = "first_name")
	@CacheLookup
	WebElement firstName;

	@FindBy(name = "last_name")
	@CacheLookup
	WebElement lastName;

	@FindBy(name = "nickname")
	@CacheLookup
	WebElement nickName;

	@FindBy(name = "email")
	@CacheLookup
	WebElement Email;

	@FindBy(name = "pass1-text")
	@CacheLookup
	WebElement newPassword;

	@FindBy(name = "submit")
	@CacheLookup
	WebElement updateProfile;

	public ProfilePage() {

		PageFactory.initElements(driver, this);
	}

	public boolean verifyuserLabel() {

		return userLabel.isDisplayed();
	}

	public boolean verifyvisualEditorcheckbox() {
		visualEditor.click();
		return visualEditor.isSelected();

	}

	public boolean syntaxHighlightningcheckbox() {
		syntaxHighlightning.click();
		return syntaxHighlightning.isSelected();
	}

	public void toolBarcheckbox() {
		toolBar.click();
	}

	public void createNewProfile(String ftName, String ltName, String nckName, String email) {
		// can create pagefactory valso for below display name

		// Select select=new Select(driver.findElement(By.name("display_name")));

		// select.selectByVisibleText("Display name publicly as");
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		nickName.sendKeys(nckName);
		Email.sendKeys(email);
		// newPassword.sendKeys(newPwd);
		updateProfile.click();

	}

}

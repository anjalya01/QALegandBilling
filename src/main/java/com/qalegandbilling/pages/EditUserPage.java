package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class EditUserPage extends TestHelperUtility{
	public WebDriver driver;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _emailedit= "//input[@id='email']";
	@FindBy(xpath = _emailedit)
	WebElement emailedit;
	
	private final String _updateButton= "//button[@id='submit_user_button']";
	@FindBy(xpath = _updateButton)
	WebElement updateButton;
	
	
	
	public void setEditedEmail(String email) {
		emailedit.clear();
		wait.waitForElementToBeVisible(driver, emailedit);
		
	page.enterText(emailedit, email);
	}
	
	public void click_Update() {
		page.clickOnElement(updateButton);
	}
	
}

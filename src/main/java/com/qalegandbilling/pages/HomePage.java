package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _userAccount = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _userAccount)
	WebElement userAccount;

	private final String _signoutField = "//a[text()='Sign Out']";
	@FindBy(xpath = _signoutField)
	WebElement signoutField;

	private final String _userManagemnt = "//a[@href='#']//span[text()='User Management']";
	@FindBy(xpath = _userManagemnt)
	WebElement userManagemnt;

	private final String _users = "//a[@href='https://qalegend.com/billing/public/users']";
	@FindBy(xpath = _users)
	WebElement users;
	
	private final String _roles = "//a[@href='https://qalegend.com/billing/public/roles']";
	@FindBy(xpath = _roles)
	WebElement roles;
	
	private final String _salesCommisionPage = "//a[@href='https://qalegend.com/billing/public/sales-commission-agents']";
	@FindBy(xpath = _salesCommisionPage)
	WebElement salesCommisionPage;
	
	

	public String getUserAccountName() {
		wait.waitForElementToBeVisible(driver, userAccount);
		String accountName = page.getElementText(userAccount);
		return accountName;
	}

	public LoginPage clickSighnoutButton() {
		page.clickOnElement(userAccount);
		page.clickOnElement(signoutField);
		return new LoginPage(driver);
	}

	public UserPage click_UserManagemntButton() {
		page.clickOnElement(userManagemnt);
		return new UserPage(driver);
	}
	
	public EditUserPage click_salesCommisionButton() {
		wait.waitForElementToBeVisible(driver, salesCommisionPage);
		page.clickOnElement(salesCommisionPage);
		return new EditUserPage(driver);
	}
	
	
	public boolean userMenu_is_Displayed() {
		boolean status=page.isDisplayed(users);
		return status;
		
	}
	public boolean rolesMenu_is_Displayed() {
		boolean status=page.isDisplayed(users);
		return status;
		
	}
	public boolean salesMenu_is_Displayed() {
		boolean status=page.isDisplayed(users);
		return status;
		
	}
	

}

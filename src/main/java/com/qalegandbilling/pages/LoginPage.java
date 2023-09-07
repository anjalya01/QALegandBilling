package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _username = "//input[@id='username']";
	@FindBy(xpath = _username)
	WebElement username;
	private final String _password = "//input[@id='password']";
	@FindBy(xpath = _password)
	WebElement password;
	private final String _submitbutton = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _submitbutton)
	WebElement submitbutton;
	private final String _endtourButton = "//button[@class='btn btn-default btn-sm']";
	@FindBy(xpath = _endtourButton)
	WebElement endtourButton;
	private final String _forgotpassword = "//a[@class='btn btn-link']";
	@FindBy(xpath = _forgotpassword)
	WebElement forgotpassword;
	private final String _prfile = "//span[text()='Anjaly A']";
	@FindBy(xpath = _prfile)
	WebElement prfile;
	private final String _errorMessage="//span[@class='help-block']//strong";
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	
	public void enterUserName(String uname) {
		page.enterText(username, uname);
	}

	public void enterPassword(String paswrd) {
		page.enterText(password, paswrd);
	}

	public HomePage clickSubmit() {
		page.clickOnElement(submitbutton);
		page.clickOnElement(endtourButton);
		return new HomePage(driver);

	}
	// this submit for testcase 11
	public HomePage Submit() {
		page.clickOnElement(submitbutton);
		return new HomePage(driver);

	}
	public void clickSubmitforinvalid() {
		page.clickOnElement(submitbutton);
		

	}
	

	public ResetPage clickforgot() {
		page.clickOnElement(forgotpassword);
		return new ResetPage(driver);
	}

	public String loginPageTitle() {
		String title = page.getPageTitle(driver);
		return title;

	}
	public String geterroMessage() {
		String errormsg=page.getElementText(errorMessage);
		return errormsg;
	}
}
package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qalegandbilling.utilities.TestHelperUtility;

public class AddUsersPage extends TestHelperUtility {
	public WebDriver driver;

	public AddUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _addButton = "//a[@href='https://qalegend.com/billing/public/users/create']";
	@FindBy(xpath = _addButton)
	WebElement addButton;

	private final String _prefix = "//input[@id='surname']";
	@FindBy(xpath = _prefix)
	WebElement prefix;

	private final String _fName = "//input[@id='first_name']";
	@FindBy(xpath = _fName)
	WebElement fName;

	private final String _lName = "//input[@id='last_name']";
	@FindBy(xpath = _lName)
	WebElement lName;

	private final String _email = "//input[@id='email']";
	@FindBy(xpath = _email)
	WebElement email;

	private final String _uName = "//input[@id='username']";
	@FindBy(xpath = _uName)
	WebElement uName;

	private final String _pswd = "//input[@id='password']";
	@FindBy(xpath = _pswd)
	WebElement pswd;

	private final String _cpswd = "//input[@id='confirm_password']";
	@FindBy(xpath = _cpswd)
	WebElement cpswd;

	private final String _salePerc = "//input[@id='cmmsn_percent']";
	@FindBy(xpath = _salePerc)
	WebElement salePerc;

	private final String _saveButton = "//button[@id='submit_user_button']";

	@FindBy(xpath = _saveButton)
	WebElement saveButton;

	public void addButton() {
		page.clickOnElement(addButton);
	}

	public void enterprefix(String pefix) {
		page.enterText(prefix, pefix);
	}

	public void enterfirstname(String fstName) {
		page.enterText(fName, fstName);

	}
	public void enteruserDdetails(String pefix,String fstName,String lastName,String mail,String username,String password,String confirmpaswrd,String salesprectentage) {
		
		page.enterText(prefix, pefix);
		page.enterText(fName, fstName);
		page.enterText(lName, lastName);
		page.enterText(email, mail);
		page.enterText(uName, username);
		page.enterText(pswd, password);
		page.enterText(cpswd, confirmpaswrd);
		page.enterText(salePerc, salesprectentage);
	
	
	}

	public void enterlastname(String lastName) {
		page.enterText(lName, lastName);

	}

	public void enterEmail(String mail) {
		page.enterText(email, mail);
	}
	
	
	

	public void enterUsername(String username) {
		page.enterText(uName, username);

	}

	public void enterpassword(String password) {
		page.enterText(pswd, password);

	}

	public void confirmpassword(String confrmpasswrd) {
		page.enterText(cpswd, confrmpasswrd);

	}

	public void enterSalesPercentage(String salesprectentage) {
		page.enterText(salePerc, salesprectentage);

	}

	public UserPage clickSaveButton() {
		page.clickOnElement(saveButton);
		return new UserPage(driver);
		
	}
	
}

package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _users = "//a[@href='https://qalegend.com/billing/public/users']";
	@FindBy(xpath = _users)
	WebElement users;

	private final String _serchFiled = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _serchFiled)
	WebElement serchFiled;

	private final String _userEmailField = "//table[@id='users_table']//tbody//td[4]";
	@FindBy(xpath = _userEmailField)
	WebElement userEmailField;

	private final String _deletButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deletButton)
	WebElement deletButton;

	private final String _deletConfirmButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _deletConfirmButton)
	WebElement deletConfirmButton;

	private final String _deletedmailcheckMsg = "//table[@id='users_table']//tbody//td";
	@FindBy(xpath = _deletedmailcheckMsg)
	WebElement deletedmailcheckMsg;

	private final String _editButton = "//i[@class='glyphicon glyphicon-edit']";

	@FindBy(xpath = _editButton)
	WebElement editButton;

	private final String _viewButton = "//a[@class='btn btn-xs btn-info']";
	@FindBy(xpath = _viewButton)
	WebElement viewButton;

	private final String _rolesButton = "//a[@href='https://qalegend.com/billing/public/roles']";
	@FindBy(xpath = _rolesButton)
	WebElement rolesButton;

	private final String _homeButton = "//a[@href='https://qalegend.com/billing/public/home']";
	@FindBy(xpath = _homeButton)
	WebElement homeButton;

	public AddUsersPage userButton() {
		page.clickOnElement(users);
		return new AddUsersPage(driver);

	}

	public AddUsersPage setValidMail(String serchemail) {
		wait.waitForElementToBeVisible(driver, serchFiled);
		page.enterText(serchFiled, serchemail);
		return new AddUsersPage(driver);
	}

	public String getvalidEmail() {
		wait.waitForElementToBeVisible(driver, userEmailField);
		String email = page.getElementText(userEmailField);
		return email;
	}

	public void clickDeleteButton() {
		wait.waitForElementToBeVisible(driver, deletButton);
		page.clickOnElement(deletButton);
		wait.waitForElementToBeVisible(driver, deletConfirmButton);
		page.clickOnElement(deletConfirmButton);

	}

	public String _get_DeletedmailcheckMsg() {
		wait.waitForElementToBeVisible(driver, deletedmailcheckMsg);
		String emailMsg = page.getElementText(deletedmailcheckMsg);
		return emailMsg;
	}

	public EditUserPage click_on_editButton() {
		wait.waitForElementToBeVisible(driver, editButton);
		page.clickOnElement(editButton);
		return new EditUserPage(driver);
	}

	public ViewUserPage click_on_viewButton() {
		wait.waitForElementToBeVisible(driver, viewButton);
		page.clickOnElement(viewButton);
		return new ViewUserPage(driver);
	}

	public RolesPage click_on_rolesButton() {
		wait.waitForElementToBeVisible(driver, rolesButton);
		page.clickOnElement(rolesButton);
		return new RolesPage(driver);
	}

	public HomePage click_HomeButton() {
		wait.waitForElementToBeVisible(driver, homeButton);
		page.clickOnElement(homeButton);
		
		return new HomePage(driver);

	}
}

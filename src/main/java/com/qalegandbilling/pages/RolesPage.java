package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class RolesPage extends TestHelperUtility {
	public WebDriver driver;

	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	private final String _serchFiled= "//input[@class='form-control input-sm']";
	@FindBy(xpath = _serchFiled)
	WebElement serchFiled;
	
	private final String _role= "//table[@id='roles_table']//tbody//td[1]";
	@FindBy(xpath = _role)
	WebElement role;
	
	public void enterRole(String role) {
		wait.waitForElementToBeVisible(driver, serchFiled);
		page.enterText(serchFiled, role);
	}
	
public String getrolename() {
	wait.waitForElementToBeVisible(driver, role);
	String rolename=page.getElementText(role);
	
	return rolename;
	
}
}

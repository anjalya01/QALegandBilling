package com.qalegandbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegandbilling.utilities.TestHelperUtility;

public class ViewUserPage extends TestHelperUtility {
	public WebDriver driver;

	public ViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	private final String _viewProfileName= "//h3[@class='profile-username']";
	@FindBy(xpath = _viewProfileName)
	WebElement viewProfileName;
	
	
	
	public String _get_profilename() {	
		//wait.waitForElementToBeVisible(driver, viewEmail);
		String prifilename=page.getElementText(viewProfileName);
		return prifilename;
	}
	
	

}

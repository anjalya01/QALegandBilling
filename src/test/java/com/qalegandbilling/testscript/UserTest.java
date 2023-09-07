package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.bag.TreeBag;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.pages.AddUsersPage;
import com.qalegandbilling.pages.HomePage;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.UserPage;
import com.qalegandbilling.utilities.ExcelUtility;

public class UserTest extends Base{
	LoginPage login;
	HomePage home;
	UserPage user;
	
	@Test(priority=4,description="TC_001 verify usermanagemnts tabs are displayed",groups= {"Sanity"})
	public void Tc_006_verify_UserManagemntTabs_are_Displayed() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(0).get(1);
		String pswd = data.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pswd);
		home = login.clickSubmit();
		home.click_UserManagemntButton();
		
	boolean userMenuStatus=	home.userMenu_is_Displayed();
	boolean roleMenuStatus=	home.rolesMenu_is_Displayed();
	boolean salesMenuStatus=home.salesMenu_is_Displayed();
		Assert.assertTrue(userMenuStatus, ErrorMessages.USERSUBMENU_NOT_FOUND);
		Assert.assertTrue(roleMenuStatus, ErrorMessages.ROLESSUBMENU_NOT_FOUND);
		Assert.assertTrue(salesMenuStatus, ErrorMessages.SALESSUBMENU_NOT_FOUND);
		
	}
	
	
}

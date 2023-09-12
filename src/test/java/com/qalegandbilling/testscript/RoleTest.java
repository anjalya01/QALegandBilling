package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.pages.AddUsersPage;
import com.qalegandbilling.pages.EditUserPage;
import com.qalegandbilling.pages.HomePage;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.RolesPage;
import com.qalegandbilling.pages.UserPage;
import com.qalegandbilling.utilities.ExcelUtility;

public class RoleTest extends Base {
	
	LoginPage login;
	HomePage home;
	UserPage user;
	RolesPage role;
	
	@Test(priority=1,description="TC_008 verify Role",groups= {"Regression"})
	public void TC_008_verify_VerifyUser() {
	List<ArrayList<String>>data=ExcelUtility.excelDataReader("LoginPage");
	String uname=data.get(0).get(1);
	String pwrd=data.get(1).get(1);
	List<ArrayList<String>>data1=ExcelUtility.excelDataReader("Roles");
	String rolename=data1.get(0).get(1);
	login = new LoginPage(driver);
	login.enterUserName(uname);
	login.enterPassword(pwrd);
	home=login.clickSubmit();
	user=home.click_UserManagemntButton();
	role=user.click_on_rolesButton();
	role.enterRole(rolename);
	String actRole=role.getrolename();
	System.out.println(actRole);
	Assert.assertEquals(rolename,actRole,ErrorMessages.INVALID_ROLE);
	
	
	}

}

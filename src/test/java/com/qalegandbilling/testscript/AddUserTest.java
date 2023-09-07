package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.pages.AddUsersPage;
import com.qalegandbilling.pages.HomePage;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.UserPage;
import com.qalegandbilling.utilities.ExcelUtility;
import com.qalegandbilling.utilities.RandomUtility;

public class AddUserTest extends Base {

	AddUsersPage adduser;
	LoginPage login;
	HomePage home;
	UserPage user;

	@Test(priority=2,description="TC_001 verify user can add users",groups= {"Regression"})
	public void TC_005_verifyUsercan_Add_users() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(0).get(1);
		String pswd = data.get(1).get(1);
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("AddUser");
		String prefix = data1.get(0).get(1);
		String fname = RandomUtility.getfName();	
		String lname =RandomUtility.getlName();
		String email = RandomUtility.getRandomEmail();
		String username = fname+lname;
		String pwd = fname+"@123";
		String cPwd = pwd;
		String salesCommision = data1.get(8).get(1);
		
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pswd);
		home = login.clickSubmit();
		user = home.click_UserManagemntButton();
		adduser = user.userButton();
		adduser.addButton();		
		adduser.enterprefix(prefix);
		adduser.enterfirstname(fname);
		adduser.enterlastname(lname);
		adduser.enterEmail(email);
		adduser.enterUsername(username);
		adduser.enterpassword(pwd);
		adduser.confirmpassword(cPwd);
		adduser.enterSalesPercentage(salesCommision);
		adduser.clickSaveButton();
		user.setValidMail(email);
		String actEmail=user.getvalidEmail();
		System.out.println(actEmail);
		Assert.assertEquals(email, actEmail,ErrorMessages.INVALID_EMAILID);

	}

}

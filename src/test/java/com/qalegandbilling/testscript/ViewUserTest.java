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
import com.qalegandbilling.pages.UserPage;
import com.qalegandbilling.pages.ViewUserPage;
import com.qalegandbilling.utilities.ExcelUtility;
import com.qalegandbilling.utilities.RandomUtility;

public class ViewUserTest extends Base{


	LoginPage login;
	HomePage home;
	UserPage user;
	AddUsersPage adduser;
	EditUserPage edituser;
	ViewUserPage viewuser;
	
	
	@Test
	public void TC_0010_validate_ViewUser() {
	List<ArrayList<String>>data=ExcelUtility.excelDataReader("LoginPage");
	String uname=data.get(0).get(1);
	String pwrd=data.get(1).get(1);
	List<ArrayList<String>> data2 = ExcelUtility.excelDataReader("AddUser");
	String prefix = data2.get(0).get(1);
	String fname = RandomUtility.getfName();	
	String lname =RandomUtility.getlName();
	String email = RandomUtility.getRandomEmail();
	String username = fname+lname;
	String pwd = fname+"@123";
	String cPwd = pwd;
	String salesCommision = data2.get(8).get(1);
	login = new LoginPage(driver);
	login.enterUserName(uname);
	login.enterPassword(pwrd);
	home=login.clickSubmit();
	user=home.click_UserManagemntButton();
	adduser=user.userButton();
	adduser.addButton();		
	adduser.enteruserDdetails(prefix, fname, lname, email, username, pwd, cPwd, salesCommision);
	adduser.clickSaveButton();
	user.setValidMail(email);
	viewuser=user.click_on_viewButton();
	String actprofilename=viewuser._get_profilename();
	String profilename=prefix+" "+fname+" "+lname;
	System.out.println(actprofilename);
	System.out.println(profilename);
	Assert.assertEquals(actprofilename,profilename,ErrorMessages.INVALID_PROFILENAME );
	
	
	}
}

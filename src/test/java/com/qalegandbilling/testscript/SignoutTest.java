package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.pages.HomePage;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.SignoutPage;
import com.qalegandbilling.utilities.ExcelUtility;

public class SignoutTest extends Base {
	SignoutPage signout;
	LoginPage login;
	HomePage home;

	@Test(priority=1,description="TC_001 verify user is navigate to loginpage by clicking sighnout",groups= {"Regression"})
	public void TC_004_verifyuser_isNavigate_to_LoginPage_by_clicking_signout() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String uname = data.get(0).get(1);
		login = new LoginPage(driver);
		String actTitile = login.loginPageTitle();
		System.out.println(actTitile);
		login.enterUserName(uname);
		String pwrd = data.get(1).get(1);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		login = home.clickSighnoutButton();
		String expTitle = login.loginPageTitle();
		Assert.assertEquals(actTitile, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);

	}
}

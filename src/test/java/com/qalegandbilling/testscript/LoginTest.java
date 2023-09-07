package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.dataprovider.DataProviders;
import com.qalegandbilling.pages.HomePage;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.ResetPage;
import com.qalegandbilling.utilities.ExcelUtility;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
		
	@Test(priority=1,description="TC_001 verify Valid login",groups= {"Regression"})
	public void TC_001_verifyValidLogin() {
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("LoginPage");
		String uname=data.get(0).get(1);
		String pwrd=data.get(1).get(1);
		String expUserName=data.get(3).get(1);
		login=new LoginPage(driver);
		login.enterUserName(uname);		
		login.enterPassword(pwrd);
		home=login.clickSubmit();     
		String actualUserName=home.getUserAccountName();
		Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);
		
	}
	@Test(dataProvider = "InvalidUserCredentials",dataProviderClass=DataProviders.class,priority=1,description="TC_001 verify Invalid login",groups= {"Regression"})
	public void  TC_002_verify_InvalidLogin(String userName,String password) {
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("LoginPage");
		String expErrorMessage=data.get(2).get(1);
		login=new LoginPage(driver);
		login.enterUserName(userName);		
		login.enterPassword(password);
		login.clickSubmitforinvalid();
		String actualErrorMsg=login.geterroMessage();
		Assert.assertEquals(expErrorMessage, actualErrorMsg,ErrorMessages.INVALID_LOGIN);
		
	}
}

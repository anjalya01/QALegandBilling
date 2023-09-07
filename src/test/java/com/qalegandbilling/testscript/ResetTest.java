package com.qalegandbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegandbilling.automationcore.Base;
import com.qalegandbilling.constants.ErrorMessages;
import com.qalegandbilling.pages.LoginPage;
import com.qalegandbilling.pages.ResetPage;
import com.qalegandbilling.utilities.ExcelUtility;

public class ResetTest extends Base {
	ResetPage reset;
	LoginPage login;

	@Test(priority=2,description="TC_001 verify error message displayed on resetpage with invalidmailid",groups= {"Smoke"})
	public void TC_003_errorMessage_Displayed_onthe_Reset_passwordPage_with_InavlidemailID() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
		String email = data.get(0).get(1);
		String act_ErrorMsg = data.get(1).get(1);
		login = new LoginPage(driver);
		reset = login.clickforgot();
		reset.getEmail(email);
		reset.clickResetLinkButton();
		String expEmailMsg = reset.EmailMessage();
		Assert.assertEquals(expEmailMsg, act_ErrorMsg, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);

	}

}

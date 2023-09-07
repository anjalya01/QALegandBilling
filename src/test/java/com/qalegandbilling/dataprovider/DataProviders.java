
package com.qalegandbilling.dataprovider;



import org.testng.annotations.DataProvider;

import com.qalegandbilling.utilities.ExcelUtility;

public class DataProviders {
ExcelUtility excel=new ExcelUtility();
@DataProvider(name="InvalidUserCredentials")
public Object[][] InvalidUserCredentialsToLogin(){
    Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
    return data;
}
}

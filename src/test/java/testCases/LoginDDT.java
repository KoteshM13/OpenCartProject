package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")//getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		
		logger.info("***Starting execution of LoginDDT");
		try {
		AccountPage a = new AccountPage(driver);
		a.account();
		a.login();
		
		LoginPage lp = new LoginPage(driver);
		lp.email(email);
		lp.password(pwd);
		lp.login();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.accountPage();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clkLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clkLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
		  Assert.fail();
		}
		logger.info("***Execution is completed successfully***");
	}

}

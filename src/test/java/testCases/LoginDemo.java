package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginDemo extends BaseClass{

	@Test(groups={"Sanity", "Master"})
	public void loginpage()
	{
		logger.info("***Starting execution of Login page***");
		try {
		AccountPage a = new AccountPage(driver);
		a.account();
		a.login();
		
		LoginPage lp = new LoginPage(driver);
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.login();
		
		MyAccountPage mya = new MyAccountPage(driver);
		boolean value = mya.accountPage();
		
		Assert.assertEquals(value, true);
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Execution completed for Login page***");
	}
	
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class RegisterationDemo extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_registeration()
	{
		try {
		logger.info("*** Starting test case execution ***");
		AccountPage ap = new AccountPage(driver);
		ap.account();
		logger.info("Clicking on account");
		ap.register();
		logger.info("Clicking on registeration");
		
		RegisterPage rp = new RegisterPage(driver);
		rp.firstName(randomeString().toUpperCase());
		
		rp.lastName(randomeString().toUpperCase());
		
		rp.email(randomeString()+"@gmail.com");
		
		rp.telephone(randomInteger());
		
		String password = randomAlphaNumeric();
		rp.password(password);
		rp.conPassword(password);
		rp.checkbox();
		rp.continuebutton();
		
		String message = rp.getConfirmationMsg();
		
		Assert.assertEquals(message, "Your Account Has Been Created!");
		logger.info("Registeration done successfully");
		} 
		catch(Exception e)
		{
			logger.info("Test failed....");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		
		logger.info("***Finished testcase execution***");
		
	}
	
}

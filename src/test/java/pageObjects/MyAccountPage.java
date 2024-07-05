package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Baseclass{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement acc;
	
	@FindBy(xpath ="//aside[@id='column-right']//a[normalize-space()='Logout']")
	WebElement logout;
	
	public boolean accountPage() 
	{
		try {
		return acc.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clkLogout()
	{
		logout.click();
	}
	

}

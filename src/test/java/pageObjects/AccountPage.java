package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Baseclass{
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btn_acc;
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement btn_reg;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btn_login;
	
	public void account()
	{
		btn_acc.click();
	}
	
	public void register()
	{
		btn_reg.click();
		
	}
	
	public void login() {
		
		btn_login.click();
	}

}

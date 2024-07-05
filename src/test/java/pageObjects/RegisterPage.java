package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Baseclass {
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confpassword;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement check;

	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_cont;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	
	
	public void firstName(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	
	public void email(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void telephone(String telephone)
	{
		txt_telephone.sendKeys(telephone);
	}
	
	public void password(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void conPassword(String conpassword)
	{
		txt_confpassword.sendKeys(conpassword);
	}
	
	public void checkbox()
	{
		check.click();
	}
	
	public void continuebutton()
	{
		btn_cont.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

}

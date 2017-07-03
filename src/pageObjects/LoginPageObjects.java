package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverDetails;

public class LoginPageObjects 
{
	@FindBy(xpath = ".//form[@id='form1']/div[3]//a")
	public static WebElement LoginBtn;
	
	@FindBy(id = "cphBody_tbUsername")
	public static WebElement Username;
	
	@FindBy(id = "cphBody_tbPassword")
	public static WebElement Password;
	
	@FindBy(id = "cphBody_submit")
	public static WebElement SubmitBtn;
	
	public LoginPageObjects()
	{
		InitializeLoginPageObjects();
	}
	
	public void InitializeLoginPageObjects()
	{
		PageFactory.initElements(DriverDetails.driver, this);
	}
}

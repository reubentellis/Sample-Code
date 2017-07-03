package pages;

import org.testng.Assert;

import pageObjects.GlobalOptionsObjects;

public class GlobalOptions extends GlobalOptionsObjects{

	public static void ClickSignOut()
	{
		GlobalOptionsObjects.MainDropDown.click();
		GlobalOptionsObjects.SignOut.click();
		Assert.assertTrue(LoginPage.VerifyUserLoggedIn());
	}
	
	public static void ClickRACVHealesville()
	{
		GlobalOptionsObjects.RACVHealesville.click();
	}

}

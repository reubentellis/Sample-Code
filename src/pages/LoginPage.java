package pages;
import pageObjects.GlobalOptionsObjects;
import pageObjects.LoginPageObjects;

public class LoginPage
{
	//private static LoginPageObjects LoginObjects;
	
	public static void LoginIntoGPSGolf(String username, String password)
	{
		LoginPageObjects LoginObjects = new LoginPageObjects();
		LoginPageObjects.LoginBtn.click();
		LoginPageObjects.Username.sendKeys(username);
		LoginPageObjects.Password.sendKeys(password);
		LoginPageObjects.SubmitBtn.click();
		//Initialize CommonPageObjects only if login is successful
		instantiateGlobalOptionsIfUserLoggedIn();
		
		
	}

	private static void instantiateGlobalOptionsIfUserLoggedIn() {
		try 
		{
			Thread.sleep(3000);
			if(VerifyUserLoggedIn())
			{
				GlobalOptionsObjects GlobalOptionsObjects = new GlobalOptionsObjects();
			}
		} catch (InterruptedException e) 
		{
				e.printStackTrace();
		}
	}
	
	public static boolean VerifyUserLoggedIn()
	{
		boolean LoggedIn;
		
		if(LoginPageObjects.LoginBtn.getText().equalsIgnoreCase("Login"))
		{
			LoggedIn = false;
		}
		else
		{
			LoggedIn = true;
		}
		
		return LoggedIn; 
	}
}

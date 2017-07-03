package tests;

import org.testng.annotations.Test;

import pageObjects.GlobalOptionsObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
//import java.util.Properties;
import utilities.*;
import pages.*;

public class LoginTests
{
	FileInputStream fileInput = null;
			
  @BeforeClass
  public void beforeClass() 
  {
	  PropertiesFile.InitializeProperties();
	  DriverDetails.InitializeFirefoxDriver();
	  DriverDetails.driver.get(PropertiesFile.DefaultURL);
  }

  @Test
  public void Login() 
  {
	  LoginPage.LoginIntoGPSGolf(PropertiesFile.DefaultUsername, PropertiesFile.DefaultPassword);
  }
  
  @Test(dependsOnMethods = "Login")
  public void Signout()
  {
	 GlobalOptions.ClickSignOut();
  }
  
  @AfterClass
  public void afterClass() 
  {
		DriverDetails.driver.quit();
		  
  }

}

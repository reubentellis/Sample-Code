/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverDetails;

/**
 * @author Reuben
 *
 */

public class GlobalOptionsObjects
{
	WebDriverWait driverWait = new WebDriverWait(DriverDetails.driver,10);
	
	@FindBy(xpath = "//form[@id='form1']//a[contains(text(),'Sign Out')]")
	public static WebElement SignOut;
	
	@FindBy(xpath = "//form[@id='form1']//a[contains(text(),'RACV Healesville')]")
	public static WebElement RACVHealesville;
	
	@FindBy(xpath = ".//form[@id='form1']//a[@class = 'btn btn-success dropdown-toggle' and @data-toggle = 'dropdown']")
	public static WebElement MainDropDown;
	
	public GlobalOptionsObjects()
	{
		InitializeCommonObjects();
	}
	
	public void InitializeCommonObjects()
	{
		PageFactory.initElements(DriverDetails.driver, this);
		MainDropDown = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				".//form[@id='form1']//a[@class = 'btn btn-success dropdown-toggle' and @data-toggle = 'dropdown']")));
		
	}

}

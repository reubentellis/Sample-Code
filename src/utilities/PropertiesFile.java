package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile 
{
	private static Properties property = null;
	private static FileInputStream FilePath = null;
	private static String PropertiesFileLocation = "G:/Eclipse Projects/TestGPS/Constant.properties";
	public static String DefaultUsername = null;
	public static String DefaultPassword = null;
	public static String DefaultURL = null;
	public static String ExcelFilePath = null;
	public static String ExcelFile = null;
	public static String ExcelSheet = null;
	
	public static void InitializeProperties()
	{
		property = new Properties();
		try 
		{
			FilePath = new FileInputStream(PropertiesFileLocation);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			property.load(FilePath);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		DefaultUsername = property.getProperty("username");
		DefaultPassword = property.getProperty("password");
		DefaultURL = property.getProperty("BaseURL");
		ExcelFilePath = property.getProperty("ExcelFilePath");
		ExcelFile = property.getProperty("ExcelFile");
		ExcelSheet = property.getProperty("ExcelSheet");
	}
}

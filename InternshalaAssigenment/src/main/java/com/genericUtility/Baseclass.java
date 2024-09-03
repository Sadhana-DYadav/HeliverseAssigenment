package com.genericUtility;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.beust.jcommander.Parameter;
//import com.comcast.FidusiaObjectRepsitory.loginPage;
public class Baseclass 
{
	public DatabaseUtility dbUl= new DatabaseUtility();
	public ExcelUtility eu=new ExcelUtility();
	public FileUtility fUl=new FileUtility();
	public JavaUtility jUl=new JavaUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException
	{
		dbUl.connectDB();
		Reporter.log("----Connect To DataBase----", true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	//public void launchbrowser1(String Browser) throws IOException
	public void launchbrowser() throws IOException
	{
	//	Browser= fUl.readDataFromPropertyFile("browser"); // this is for the crossbrowser execution
		String Browser= fUl.readDataFromPropertyFile("browser");
		//String Browser=System.getProperty("browser");  // this is for maven execution
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("----Launch The Browser----", true);
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			Reporter.log("--- Invalid Browser----", true);
		}
		
		sdriver=driver;
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		
	}	
		
		@BeforeMethod(alwaysRun = true)
		public void logintoApp() throws IOException
		{
			//String URL=System.getProperty("url");
			String URL=fUl.readDataFromPropertyFile("url");
			String USERNAME= fUl.readDataFromPropertyFile("username");
			String PASSWORD=fUl.readDataFromPropertyFile("password");
			
			driver.get(URL);
			
			//loginPage lpg=new loginPage(driver);
			//lpg.loginToApplication(USERNAME, PASSWORD);
			
			Reporter.log("----Log to Application---", true);
		}
		
		@AfterMethod(alwaysRun = true)
		public void logoutFromApp()
		{
			
			Reporter.log("----Logout from Application-----, true");
		}
		
		@AfterClass(alwaysRun = true)
		public void closeBrowser()
		{
			driver.quit();
			Reporter.log("----close the browser-----, true");
		}
	}
	


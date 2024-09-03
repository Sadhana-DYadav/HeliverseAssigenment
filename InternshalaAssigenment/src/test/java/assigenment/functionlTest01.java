package assigenment;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import webPages.homePage;
import webPages.loginpage;
public class functionlTest01 extends Baseclass
{
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	public static void main(String args[]) throws InterruptedException
	{
		
		//utility classes
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		//pom class reference variable
		homePage hp=new homePage(driver);
		// maximizing window using utility class
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		//launch the application
		driver.get("https://www.amazon.in");
		//fetching element in the script from POM class
		WebElement sign=hp.getSignMouseOver();
		//performing mouse overing action using Action class
		wdu.mouseHover(driver, sign);
		hp.getSignBtn().click();
		
		Thread.sleep(3000);
		//login page (Pom class)
		loginpage lp=new loginpage (driver);
		//enter the username, password and click on login button using business library
		lp.loginApp("7689811774", "123456789");
		// sending data in search bar
		hp.homePage("iphone");
		Thread.sleep(5000);
		
		//validating element is display or not
		 boolean prese = driver.findElement(By.xpath("//div[@class='a-row puis-atcb-remove-group']")).isDisplayed();
		 Thread.sleep(3000);
		 //
		 assertTrue(prese);
		 
		 //printing message in console to ensure element is added in cart
		 System.out.println("phone is added in cart");
		// declaring Action class
		 Actions ac=new Actions(driver);
		 //scrolling to the element
		 ac.moveToElement(sign).perform();
		 // performing mouse overing action using WebDriver utility method
		 wdu.mouseHover(driver,sign);
		 //logout the application
		 hp.getSignoutBtn().click();
		//fetching text after sign out for validation  
		 String signText=driver.findElement(By.xpath("//div//h1")).getText();
		 //print Text to console for verification
		 System.out.println(signText);
		 
		 driver.close();
	}
}
	


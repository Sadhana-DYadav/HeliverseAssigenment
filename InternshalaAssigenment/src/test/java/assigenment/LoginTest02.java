package assigenment;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.genericUtility.ExcelUtility;
import com.genericUtility.WebDriverUtility;

import webPages.orangePage;
public class LoginTest02 
{
	static WebDriver driver;
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException
	{
		//utility classes for reusability
		WebDriverUtility wdu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		driver = new ChromeDriver();
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		orangePage op=new orangePage(driver);
		//data driven testing using excel with valid credential
		//Using pom class(page object model)class's method initialize the element at run time
		op.orange(eu.readDataFromExcel("orangeSheet", 0, 0),eu.readDataFromExcel("orangeSheet", 0, 1));
		Thread.sleep(3000);
		
		WebElement footerEle = driver.findElement(By.xpath("//div//p[text()='OrangeHRM OS 5.7']"));
		Actions ac=new Actions(driver);
		//scrolling till footer
		ac.scrollToElement(footerEle).perform();
		
		//validating footer is visible
		boolean footerDisp = footerEle.isDisplayed();
		assertTrue(footerDisp);
		
		//printing message on console to verify user is on home page
		System.out.println("footer is visible after the login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		// sign out application
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
		Thread.sleep(3000);
		
		//login application using Invalid credentials using apache poi api (parameterization)
		op.orange(eu.readDataFromExcel("orangeSheet", 1, 0),eu.readDataFromExcel("orangeSheet", 1, 1));
		Thread.sleep(3000);
		String actule = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
		String expected="Invalid credentials";
		//validating the warning message
		assertEquals(actule, expected);
		//printing error message for error handling
		System.out.println(actule);
		
		driver.close();
	}

}

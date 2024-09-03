package assigenment;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class uiTest03 
{
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	public static void main(String[] args) throws InterruptedException 
	{
		//opening in incognito window
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//Navigating to frame

		driver.switchTo().frame("callout");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Stay signed out']"))).click();
		Thread.sleep(2000);
		
		//Navigating to to default web page
		driver.switchTo().defaultContent();
		
		//sending the data in search bar
		
		
		// validating search bar is display or enable or not
		boolean searchBox = driver.findElement(By.className("gLFyf")).isEnabled();
		assertTrue(searchBox);
		Thread.sleep(2000);
		driver.findElement(By.className("gLFyf")).sendKeys("sadhana");
		List<WebElement> listOfName = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li"));
		//List<WebElement> listOfName = driver.findelements(By.xpath("//span[contains(text(),'Sadhana')]"));
		
		//using collection frame work to performing sorting
		ArrayList<String>al=new ArrayList<String>();
		for(int i=0;i<listOfName.size();i++)
		{
			al.add(listOfName.get(i).getText());
		}
		//sort to collection
		Collections.sort(al,Collections.reverseOrder());
		
		for(String a:al)
		{
			System.out.println(a);
		}
		//closing to driver;
		driver.close();
	}
}

package assigenment;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.Baseclass;
import com.genericUtility.ExcelUtility;
import com.genericUtility.WebDriverUtility;
import webPages.facebookSignupPage;
public class formValidationTest04 extends Baseclass 
{
	
	@Test(retryAnalyzer = com.genericUtility.RetryImpClass.class)
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		ExcelUtility eu=new ExcelUtility();
		facebookSignupPage fp=new facebookSignupPage(driver);
		
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver, 20);
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).click();
		//driver.findElement(By.xpath("//div//a[text()='Create new account']")).click();
		Thread.sleep(3000);
		fp.enterData(driver, eu.readDataFromExcel("Facebooksignup", 0, 1),eu.readDataFromExcel("Facebooksignup", 1, 1),eu.readDataFromExcel("Facebooksignup", 2, 1), eu.readDataFromExcel("Facebooksignup", 3, 1));
		
//		HashMap<String, String> getdata = eu.readMultipleDatafromExcelFile("Facebooksignup", 4, 0, 0);
//		fp.enterData(driver,getdata.get("FName"),getdata.get("LName"), getdata.get("Email"), getdata.get("Password"));
		Thread.sleep(3000);
		wdu.SelectOptionFromDropDownVISIBLETEXT(fp.getBirthDayDropD(), "24");
		Thread.sleep(3000);
		
		wdu.SelectOptionFromDropDownVISIBLETEXT(fp.getBirthMonthDropD(),"Feb");
		Thread.sleep(3000);
		wdu.SelectOptionFromDropDownVISIBLETEXT(fp.getBirthYearDropD(), "2006");
		Thread.sleep(3000);
		fp.getFemaleRadio().click();
//		Thread.sleep(3000);
//		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);
		fp.getSignBtn().click();
		driver.close();
		
		
		
	}

}

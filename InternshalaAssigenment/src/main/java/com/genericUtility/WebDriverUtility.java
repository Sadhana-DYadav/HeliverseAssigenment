package com.genericUtility;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtility 
{
	public static WebDriver driver;
	public WebDriverWait webDriverWaitObj(WebDriver driver,int sec)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize(); 
	}
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	public WebDriverWait explicitWait(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	public void waitUntillElementToBeVisible(WebDriver driver,int sec, WebElement element)
	{
		webDriverWaitObj(driver,sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitUntillElementToBeClickable(WebDriver driver,int sec,WebElement element)
	{
		webDriverWaitObj(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void waitUntilTogetTitle(WebDriver driver,int sec, String title)
	{
		explicitWait(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	public void switchToWindow(WebDriver driver,String expWind)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			String CurrentTitle=driver.switchTo().window(win).getTitle();
			if(CurrentTitle.contains(expWind))
			{
				break;
			}
		}
	}
	
	public Robot robotObj() throws AWTException
	{
		Robot rb=new Robot();
		return rb;
	}
	
	public void enterKey(WebDriver driver) throws AWTException
	{
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease() throws Throwable
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		JavaUtility ju=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+screenShotName+""+ju.getSystemDateAndTime()+".png";
		File dst=new File(path);
		String scrpath=dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
		
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.ScrollBy(0,"+y+")", element);
	}
	
	public void scrollDownTillBottomOfPage(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollTillElementToBeVisible(WebDriver driver, WebDriver element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("argument[0].scrollIntoView()",element);
	}
	
	public void clickOnElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
		
	}
	
	public void jseUsingSendKeys(WebDriver driver,WebElement element, String expData)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1]", element, expData);
	}
	
	public void scrollUpTillElementToBeVisible(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		Point loc=element.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public Actions performActions(WebDriver driver)
	{
		Actions act=new Actions(driver);
				return act;
	}
	public void rightClick(WebDriver driver, WebElement element)
	{
		performActions(driver).contextClick(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		performActions(driver).doubleClick(element).perform();
	}
	
	public void enterKeyPress(WebDriver driver, WebElement element)
	{
		performActions(driver).sendKeys(Keys.ENTER).perform();
	}
	public void mouseHover(WebDriver driver, WebElement element)
	{
		performActions(driver).moveToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver, WebElement element, int x, int y)
	{
		
		performActions(driver).dragAndDropBy(element, x, y).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement dest)
	{
		performActions(driver).dragAndDrop(source, dest).perform();
	}
	public void waitUntilAlertToBEPresent(WebDriver driver, int sec)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	public void doubleClick(WebDriver driver)
	{
		performActions(driver).doubleClick().perform();
	}
	
	public void SelectOptionFromDropDownINDEX(WebElement element, int index) 
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void SelectOptionFromDropDownVISIBLETEXT(WebElement element, String visibleText) 
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	public void SelectOptionFromDropDownSelectByValue(WebElement element, String value) 
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	
	
	
}

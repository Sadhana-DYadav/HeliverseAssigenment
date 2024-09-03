package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
 @FindBy(xpath ="//input[@id='ap_email_login']") private WebElement userText;
 @FindBy(xpath ="//input[@type='submit']") private WebElement continuwBtn;
 @FindBy(xpath ="//input[@type='password']") private WebElement passwordTxt;
 @FindBy(id ="signInSubmit") private WebElement signInBtn;
 
 public loginpage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
}


public WebElement getUserText() {
	return userText;
}


public WebElement getContinuwBtn() {
	return continuwBtn;
	
}


public WebElement getPasswordTxt() {
	return passwordTxt;
}


public WebElement getSignInBtn() {
	return signInBtn;
}
 
 
 public void loginApp(String user, String password) throws InterruptedException 
 {
	userText.sendKeys(user);
	continuwBtn.click();
	Thread.sleep(3000);
	passwordTxt.sendKeys(password);
	signInBtn.click();
	Thread.sleep(3000);
	
	
	
	
}
 
}

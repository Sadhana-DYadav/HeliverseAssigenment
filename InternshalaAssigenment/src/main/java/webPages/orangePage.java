package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangePage
{
	@FindBy(name ="username") private WebElement userText;
	@FindBy(name ="password") private WebElement passwordTxt;
	@FindBy(xpath ="//button[@type='submit']") private WebElement loginBtn;
	
	public orangePage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}

	
	public WebElement getUserText() 
	{
		return userText;
	}

	public WebElement getPasswordTxt()
	{
		return passwordTxt;
	}

	
	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	public void orange(String user, String pass)
	{
		userText.sendKeys(user);
		passwordTxt.sendKeys(pass);
		loginBtn.submit();
	}

	
}

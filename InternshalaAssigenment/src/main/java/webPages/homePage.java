package webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage
{
	@FindBy(id ="twotabsearchtextbox") private WebElement searchText;
	 @FindBy(xpath ="//span[text()='Sponsored']/ancestor::div[@class='puisg-col-inner']//h2//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class='puisg-col-inner']//button") private WebElement cartBtn;
	 @FindBy(xpath ="//div//span[text()='Account & Lists']") private WebElement signMouseOver;
	 @FindBy(xpath ="//div//a//span[text()='Sign in']") private WebElement signBtn;
	 @FindBy(xpath ="//div//a//span[text()='Sign Out']") private WebElement signoutBtn;
	 
	 public homePage(WebDriver driver) 
	 {
		PageFactory.initElements(driver,this);
	}
	 public WebElement getSearchText()
	{
		return searchText;
	}
	 public WebElement getCartBtn() 
	{
		return cartBtn;
	}
	 public WebElement getSignMouseOver()
	{
		return signMouseOver;
	}
	 
	
	
	public WebElement getSignBtn() 
	{
		return signBtn;
	}
	
	
	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	public void homePage(String search) 
	 {
		 searchText.sendKeys(search, Keys.ENTER);
		 cartBtn.click();
	}
	
}

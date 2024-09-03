package webPages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class facebookSignupPage 
{
	@FindBy(name ="firstname") private WebElement firstNameText;
	 @FindBy(name="lastname") private WebElement lastNameText;
	 @FindBy(name ="reg_email__") private WebElement emailText;
	 @FindBy(name ="reg_passwd__") private WebElement passwordText;
	 @FindBy(name ="birthday_day") private WebElement birthDayDropD;
	 @FindBy(name ="birthday_month") private WebElement birthMonthDropD;
	 @FindBy(name ="birthday_year") private WebElement birthYearDropD;
	 @FindBy(xpath ="//input[@value='1']") private WebElement femaleRadio;
	 @FindBy(xpath ="//input[@value='2']") private WebElement maleRadio;
	 @FindBy(name="websubmit") private WebElement signBtn;
	 
	 public facebookSignupPage(WebDriver driver) 
	 {
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getFirstNameText()
	{
		return firstNameText;
	}

	
	public WebElement getLastNameText() 
	{
		return lastNameText;
	}

	
	public WebElement getEmailText()
	{
		return emailText;
	}

	
	public WebElement getPasswordText()
	{
		return passwordText;
	}

	
	public WebElement getBirthDayDropD() 
	{
		return birthDayDropD;
	}

	public WebElement getBirthMonthDropD()
	{
		return birthMonthDropD;
	}

	
	public WebElement getBirthYearDropD()
	{
		return birthYearDropD;
	}
	public WebElement getFemaleRadio()
	{
		return femaleRadio;
	}
	public WebElement getMaleRadio() 
	{
		return maleRadio;
	}
	public WebElement getSignBtn()
	{
		return signBtn;
	}
	
	public void enterData( WebDriver driver, String fname, String lname, String email, String pass)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		firstNameText.sendKeys(fname);;
		lastNameText.sendKeys(lname);;
		emailText.sendKeys(email);;
		 passwordText.sendKeys(pass);
	}
	 
	 
	 
	 
	 
	 
}

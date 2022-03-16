package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HeadersofAmazon {
	private WebDriver driver;
	@FindBy (xpath=("(//a[@class='nav-a  '])[3]"))
	private WebElement mobilePage;
	
	@FindBy (xpath=("//select[@name='url']"))
	private WebElement selectcategory;
	
	
	@FindBy (xpath=("//input[@type='text']"))
	private WebElement serachProductInput;
	
   @FindBy(xpath=("//input[@type='submit']"))
   private WebElement searchproductButton;
   
   @FindBy(xpath=("(//div[@id='nav-tools']//a)[3]"))
   private WebElement accLogin;
   
   @FindBy(xpath="(//span[@class='nav-text'])[19]")
   
   private WebElement signOut;
	
	public HeadersofAmazon(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	this.driver=driver;	
	
	}
	
	public void clickOnaccLogin()
	{
		accLogin.click();
	}
	
	public void clickOnMobileSection()
	{mobilePage.click();}
	
	public void clickOnSelectCatagory()
	{selectcategory.click();
	Select s =new Select(selectcategory);
	s.selectByVisibleText("Electronics");}
	
	public void clickOnserachProductInput()
	{serachProductInput.sendKeys("Vivo Mobils under 10000");
		
	}
	
	public boolean checkMobileSectionVisibility() {
	boolean result=	mobilePage.isDisplayed();
	return result;
	}
	


	public void clickOnSearchProductButton()
	{searchproductButton.click();}
	
	public void clickOnsignOut() {
		Actions ac= new Actions(driver);
		
		ac.moveToElement(accLogin).moveToElement(signOut).click().build().perform();
		
		
	}
	
	
}

package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	private WebDriver driver;
	private Actions act;
	
	@FindBy(xpath=("//input[@name='submit.add-to-cart']"))
	private WebElement addToCartButton;
	
	
	public AddToCart(WebDriver driver)
	{PageFactory.initElements(driver,this);
		this.driver=driver;
		JavascriptExecutor js =(JavascriptExecutor)driver;
		 act=new Actions(driver);
		
	}
	
	public void clickOnAddToCart()
	{addToCartButton.click();
		
	}
	
	public void mouseAction()
	{
		act.moveToElement(addToCartButton).click().build().perform();
	}
	public void scroll()
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",addToCartButton );}
}

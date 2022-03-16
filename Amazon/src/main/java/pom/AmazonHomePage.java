package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath=("(//div[@class='a-section'])[1]//div//div//h2"))
	private WebElement productName;
	
	
	@FindBy(xpath=("(//span[@class='a-price-whole'])[1]"))
	private WebElement productPrice;
	
 public AmazonHomePage(WebDriver driver)
 {PageFactory.initElements(driver, this);
	 this.driver=driver;
 }
	
	public void getProductName()
	{String pname =productName.getText();
	System.out.println(pname);
	
	}
	
	public void getProductPrice()
	{String price=productPrice.getText();
		System.out.println(price);
	}
	
	public void clickOnProduct()
	{productName.click();
		
	}
	
	public void changeSeleniumFocus() {
	ArrayList<String> urls= new ArrayList<String>(driver.getWindowHandles());
	int siz=urls.size();
	System.out.println(siz);
	//String popupPage=urls.get(1);
	driver.switchTo().window(urls.get(1));
	//System.out.println(popupPage);
	
	}
	
	
	
	
	
	
	

}

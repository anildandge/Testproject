package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class SignInAmazon {
	private WebDriver driver;
	
	@FindBy(xpath=("//input[@type='email']"))
	private WebElement SignInInputMobile;
	
	@FindBy (xpath=("//input[@id='continue']"))
	private WebElement continueWithMobleno;
	
	@FindBy(xpath=("//input[@type='password']"))
	private WebElement passwordEnter;

	@FindBy(xpath=("//input[@id='signInSubmit']"))
	private WebElement signInButton;
	
	
public	SignInAmazon(WebDriver driver)
{PageFactory.initElements(driver,this);
this.driver=driver;

	}


public void SignInMobile() throws EncryptedDocumentException, IOException
{String userName=Utility.getDataFromExelSheet("anil", 10, 1);
SignInInputMobile.sendKeys(userName);

	}

public void clickOnContinueWithMobile()
{continueWithMobleno.click();
	}

public void enterPass() throws EncryptedDocumentException, IOException
{
	String pass=Utility.getDataFromExelSheet("anil", 10, 2);
	passwordEnter.sendKeys(pass);
	}

public void clickSignInButton()
{signInButton.click();
	}

public boolean SignInInputMobileIsDisplayed() {
	return SignInInputMobile.isDisplayed();
}
	
	
}

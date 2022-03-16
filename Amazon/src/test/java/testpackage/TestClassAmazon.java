package testpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import junit.framework.Assert;
import pom.AddToCart;
import pom.AmazonHomePage;
import pom.HeadersofAmazon;
import pom.SignInAmazon;
import utils.Utility;

public class TestClassAmazon extends Browser{
WebDriver driver;
AmazonHomePage amazonHomePage;
	HeadersofAmazon headersOfAmazon;
	SignInAmazon signInAmazon;
	AddToCart addToCart;
	SoftAssert soft;
	
	@BeforeTest
	public void launchTheBrowser() {
		driver=launchChromeBrowser();
		
	}
	
	@BeforeClass
	
	public void objectsOfPomClasses() {
		amazonHomePage=new AmazonHomePage(driver);
		headersOfAmazon=new HeadersofAmazon(driver);
		signInAmazon=new SignInAmazon(driver);
		addToCart=new AddToCart(driver);
		soft= new SoftAssert();
		
	}
	
	
	@BeforeMethod
	
	public void loginToAmazon() throws EncryptedDocumentException, IOException {
		driver.get("https://www.amazon.in");
driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		headersOfAmazon.clickOnaccLogin();
signInAmazon.SignInMobile();
signInAmazon.clickOnContinueWithMobile();
signInAmazon.enterPass();
signInAmazon.clickSignInButton();


	
	}
	
	@Test
	public void veryfyMobileSection() {
		System.out.println("veryfy mobile section url");
		headersOfAmazon.clickOnMobileSection();
		String url=driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void logoutFromAmazon() throws IOException {
		Utility.takeScreenshot(driver);
		
	headersOfAmazon.clickOnsignOut();
		
		
	}
	
	@AfterClass
	public void clearAllObjects() {
		headersOfAmazon=null;
		amazonHomePage=null;
		signInAmazon=null;
		addToCart=null;
	}
	
	@AfterTest
	public void closeTheBrowser() {
		driver.quit();
		System.gc();
		
	}

}

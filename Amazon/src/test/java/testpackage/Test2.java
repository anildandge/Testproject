package testpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import pom.AddToCart;
import pom.AmazonHomePage;
import pom.HeadersofAmazon;
import pom.SignInAmazon;

public class Test2 extends Browser {
	WebDriver driver;
	AddToCart addToCart;
	AmazonHomePage amazonHomePage;
	HeadersofAmazon headersofAmazon;
	SignInAmazon signInAmazon;
	SoftAssert soft;
	@BeforeTest
	public void launchBrowser() {
		System.out.println("before test");
		driver=launchTheFirefox();
	}
	
	@BeforeClass
	public void objectsOfPomClass() {
		System.out.println("before class");
		addToCart= new AddToCart(driver);
		amazonHomePage= new AmazonHomePage(driver);
		headersofAmazon=new HeadersofAmazon(driver);
		signInAmazon=new SignInAmazon(driver);
		soft=new SoftAssert();
	}
	
	@BeforeMethod
	public void logInAmazon() throws EncryptedDocumentException, IOException {
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("before method");
		headersofAmazon.clickOnaccLogin();
		signInAmazon.SignInMobile();
		signInAmazon.clickOnContinueWithMobile();
		signInAmazon.enterPass();
		signInAmazon.clickSignInButton();
		
		
		
	}
	
	@Test
	public void veryfyMobilesectionvisibility() {
		System.out.println("veryfy mobile section visibility");
    boolean	rr=	headersofAmazon.checkMobileSectionVisibility();
     soft.assertEquals(rr, true);
     soft.assertAll();

		
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("after method");
		headersofAmazon.clickOnsignOut();
	}
	
	@AfterClass
	public void clearPomObjects() {
		System.out.println("after class");
		headersofAmazon=null;
		signInAmazon=null;
		headersofAmazon=null;
		addToCart=null;
	}
	
	@AfterTest
	public void closethebrowser() {
		System.out.println("after test");
		
		driver.close();
	}
	
	
		
	

}

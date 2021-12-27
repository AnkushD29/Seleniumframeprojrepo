package test;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;
 
public class LoginTest extends Base {
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider = "getLoginData")
	public void login(String email,String password,String expectedResult) throws  InterruptedException {
	//public void login() throws IOException, InterruptedException
	 System.out.println("Login Test");
	 log = LogManager.getLogger(LoginTest.class.getName());
		
	 LandingPage landpage=new LandingPage(driver);
	 landpage.myAccountDropdown().click();
	 log.debug("Clicked on My Account Dropdown");
	 landpage.loginoption().click();
	 log.debug("Clicked on My Login Option");
		
		Thread.sleep(3000);
		LoginPage loginpage=new LoginPage(driver);
		//loginpage.emailAddressField().sendKeys(prop.getProperty("email"));
		//loginpage.passwordField().sendKeys(prop.getProperty("password"));
		
		loginpage.emailAddressField().sendKeys(email);
		 log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys(password);
		 log.debug("Password got entered");
		loginpage.loginButton().click();
		 log.debug("Clicked on Login button");
		
	    AccountPage accountpage=new AccountPage(driver);
	    //Assert.assertTrue(accountpage.editAccountInformationLink().isDisplayed());
	    
	   // System.out.println(accountpage.editAccountInformationLink().isDisplayed());
	    
	    String actualresult=null;
	    
	    try {
	    	if(accountpage.editAccountInformationLink().isDisplayed()) {
	    	actualresult="successfully login";
	    	log.debug("User got logged in");
	    	accountpage.editAccountInformationLink().click();
		    accountpage.clickOnContinue().click();
		    String text=accountpage.SucessfullyUpdated().getText();
		    System.out.println(text);
	    	}
	    }catch (Exception e) {
	    	actualresult="Failed login";
	    	log.debug("User didn't logged in");
		}
	   Assert.assertEquals(actualresult, expectedResult);
	   log.info("Login Test Got Passed");
	    
	}
	@BeforeMethod
	public void openBrowserApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		 driver=initializeDriver();
		 log.debug("Browser got launched");
		 driver.get(prop.getProperty("url")); //String ur=prop.getProperty("url"); //driver.get(ur);
		 log.debug("Navigated to Application Url");
	}
    
	@AfterMethod
	public void teardown() throws InterruptedException   //closeBrowser
	{
		Thread.sleep(4000);
		System.out.println("Success: Your Application Browser has been successfully closed.");
		driver.close();
		log.debug("Brower got closed");
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][]data= {{"ankush.selenium@gmail.com","Ankush@29","successfully login"}};
		//Object[][]data= {{"ankush.selenium@gmail.com","Ankush@29","successfully login"},{"arun.selenium@gmail.com","Arun@123","Failed login"}};
	    return data;
	}
}

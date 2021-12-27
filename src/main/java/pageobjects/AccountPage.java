package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
       @FindBy(linkText = "Edit your account information")
       private WebElement editAccountInformationLink;
       @FindBy(css=" input[value=\"Continue\"] ")
       private WebElement clickOnContinue;
       @FindBy(css="div[class=\"alert alert-success alert-dismissible\"]")
       private WebElement SucessfullyUpdated;
       
       
       public WebElement editAccountInformationLink() {
    	   return editAccountInformationLink;
       }
       public WebElement clickOnContinue() {
    	   return clickOnContinue;
       }
       public WebElement SucessfullyUpdated() {
    	   return SucessfullyUpdated;
       }
}

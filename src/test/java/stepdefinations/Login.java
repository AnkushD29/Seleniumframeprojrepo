package stepdefinations;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resource.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landpage;
	LoginPage loginpage;
	AccountPage accountpage;
	
	@Given("^Open any Browser$")
    public void open_any_browser() throws IOException {
		driver=initializeDriver();
	}
	@And("^Navigate To Login Page$")
    public void navigate_to_login_page() throws InterruptedException {
		 driver.get(prop.getProperty("url"));
		 landpage=new LandingPage(driver);
		 landpage.myAccountDropdown().click();
		 landpage.loginoption().click();
		 Thread.sleep(2000);
	}

	@When("^User Enter Username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enter_username_as_something_and_password_as_something_into_the_fields(String email, String password) {
		 loginpage=new LoginPage(driver);
		 loginpage.emailAddressField().sendKeys(email);
		loginpage.passwordField().sendKeys(password);
	}
	 @And("^User click on login button$")
	    public void user_click_on_login_button() {
		loginpage.loginButton().click();
	}
	 @Then("^Verify User is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login() {
		accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.editAccountInformationLink().isDisplayed());
		accountpage.editAccountInformationLink().click();
	    accountpage.clickOnContinue().click();
	    String text=accountpage.SucessfullyUpdated().getText();
	    System.out.println(text);
		
	}
	@After
	public void closeBrowser() {
		driver.close();
	}
}

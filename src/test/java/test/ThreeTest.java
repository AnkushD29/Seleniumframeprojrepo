package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resource.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void testThree() throws Exception{
		System.out.println("Krish has updated this code");
		System.out.println("Test Three");
		driver=initializeDriver();
		driver.get("http://www.tutorialsninja.com/demo/");
		Thread.sleep(2000);
		Assert.assertTrue(false);
		
	}
	@AfterMethod
	public void closebroswer() {
		driver.close();	
	}

}

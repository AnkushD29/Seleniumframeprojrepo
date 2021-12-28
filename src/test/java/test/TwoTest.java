package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resource.Base;

public class TwoTest extends Base  {
	WebDriver driver;
@Test
public void testtwo() throws Exception {
	System.out.println("Karan has updated this code with this statement ");
	System.out.println("Test Two");
	driver=initializeDriver();
	driver.get("http://www.tutorialsninja.com/demo/");
	Thread.sleep(2000);
	driver.close();	
}	
	
	
}

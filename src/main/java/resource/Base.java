package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	//cross browser
	WebDriver driver;        //WebDriver driver=new ChromeDriver();
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
	 prop=new Properties();
	 String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties";
	 FileInputStream fis=new FileInputStream(propPath);
	 prop.load(fis);
		
	 String browserName=prop.getProperty("browser");
	 
	 if(browserName.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 
	 }else if(browserName.equalsIgnoreCase("firefox")){
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 
	 }else if (browserName.equalsIgnoreCase("IE")) {
		 WebDriverManager.iedriver();
		 driver=new InternetExplorerDriver();
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 return driver;
 }

public String takeScreenshot(String testName, WebDriver driver) throws IOException {
	
	File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationPath=System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
	FileUtils.copyFile(sourcefile,new File(destinationPath));
	 return destinationPath;
	
	
}
}
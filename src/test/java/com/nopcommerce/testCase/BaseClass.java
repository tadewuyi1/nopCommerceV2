package com.nopcommerce.testCase;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
//Defined Variables below were moved from TC_LoginTest_0001 
		public String baseURL="http://admin-demo.nopcommerce.com/";
		public String username="";
		public String password="";
		public static WebDriver driver;
		
		public static Logger logger;
		
		//set-up method should be @BeforeClass from TC_LoginTest_0001
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\taiwo\\Downloads\\Driverdownloads\\chromedriver.exe");

		Path of my Chrome driver: /nopCommerceV2/src/Drivers/chromedriver.exe
		Location of my project: F:\JavaSeleniumDemo\nopCommerceV2\src\Drivers\chromedriver.exe

		C:\Users\taiwo\Downloads\Driverdownloads

		Pavan's modified one
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe" );*/
		@BeforeClass
		@Parameters("browser")
		public void setup(String br)
		{
			logger=Logger.getLogger("nopEcommerce");
			PropertyConfigurator.configure("Log4j.properties");
			
			if(br.equals("chrome")) {
				//Opens Chrome Browser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\taiwo\\Downloads\\Driverdownloads\\chromedriver.exe");
			driver=new ChromeDriver();
			}
			
			else if(br.equals("firefox")) {
				//Opens Firefox Browser
				System.setProperty("webdriver.gecko.driver","C:\\Users\\taiwo\\Downloads\\Driverdownloads\\geckodriver.exe");
				driver = new FirefoxDriver();	
			}
			
			else if (br.equals("ie")) {
				// opens the browser
				System.setProperty("webdriver.ie.driver","C:\\Users\\taiwo\\Downloads\\Driverdownloads\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
		}
		
		//from TC_LoginTest_0001
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
		//capturing screenshot method
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}

}
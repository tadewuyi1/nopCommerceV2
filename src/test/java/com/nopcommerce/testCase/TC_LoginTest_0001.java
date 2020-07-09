package com.nopcommerce.testCase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_0001 extends BaseClass {
	
	//Main test where you call all action methods 1by1
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");//logger msg added after log4j prop files copied to pjt dir
		
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");//logger msg
		
		lp.setPassword(password);
		logger.info("password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login clicked");//logger msg
		
		

		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed");//logger msg	
		}
		else
		{
			captureScreen(driver,"loginTest");//to capture screenshot
			Assert.assertTrue(false);
			logger.info("Login failed");//logger msg
		}

	}
}


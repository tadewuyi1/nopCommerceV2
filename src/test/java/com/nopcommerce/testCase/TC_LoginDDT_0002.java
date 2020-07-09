package com.nopcommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils3;

public class TC_LoginDDT_0002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws IOException, InterruptedException
	{
		
		//Main test where you call all action methods 1by1
		
			driver.get(baseURL);
			logger.info("URL is opened");//logger msg added after log4j prop files copied to pjt dir
			
			driver.manage().window().maximize();
			
			
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(user);//passing this parameter from username to user is the only thing thats changed from testcase 0001
			logger.info("username provided");//logger msg
			
			lp.setPassword(pwd);//passing this parameter from password to pwd is the only thing thats changed from testcase 0001
			logger.info("password provided");//logger msg
			
			lp.clickLogin();
			logger.info("Login clicked");//logger msg
			
			Thread.sleep(2000);
			
			

			if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
			{
				Assert.assertTrue(true);
				lp.clickLogout();
				logger.info("Login passed");//logger msg	
			}
			else
			{
				//captureScreen(driver,"loginTest");//to capture screenshot (not required for DDT)
				Assert.assertTrue(false);
				logger.info("Login failed");//logger msg
			}

		}
		
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	
		//F:\JavaSeleniumDemo\nopCommerceV2\src\test\java\com\nopcommerce\testData\LoginData.xlsx
		//String path=System.getProperty("user.dir")+"src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		String path="F:\\JavaSeleniumDemo\\nopCommerceV2\\src\\test\\java\\com\\nopcommerce\\testData\\LoginData.xlsx";
		int rownum=XLUtils3.getRowCount(path, "sheet1");
		int colcount=XLUtils3.getRowCount(path, "sheet1",1);
	
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils3.getCellData(path, "sheet1", i,1);
			}
		}
		
		return logindata;
	}

}

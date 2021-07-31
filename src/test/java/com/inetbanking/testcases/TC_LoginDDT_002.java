package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilites.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException  {
	
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("username provided");
		lp.setPassword(pwd);
		log.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login Failed");
		} else {
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException {
		XLUtils excel = new XLUtils();
		Object[][] obj = excel.dataDrivenExcel();
		return obj;
	}

}

package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("entered username");
		lp.setPassword(password);
		log.info("entered password");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		log.info("adding customer's information");
		addcust.clickAddNewCustomer();
		driver.manage().window().maximize();
		addcust.custName("Pawan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Delhi");
		addcust.custstate("DL");
		addcust.custpinno(110006);
		addcust.custtelephoneno("12312312312");
		
		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("12345");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res == true) {
			log.info("successful");
			Assert.assertTrue(true);
		} else {
			log.info("Not successful");
			getScreenShot("addNewCustomer", driver);
			Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	
}

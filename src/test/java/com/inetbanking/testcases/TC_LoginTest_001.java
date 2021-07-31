package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
//	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@Test
	public void loginTest() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Entered username");
		lp.setPassword(password);
		log.info("Entered password");
		lp.clickSubmit();
		log.info("Submitted");
//		System.out.println("checking driver  " + driver);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Title matched");
		} else {
			getScreenShot("loginTest", driver);
			System.out.println("failed 1");
			Assert.assertTrue(false);
			log.error("Title not matched");
			System.out.println("failed 2");
		}
	}
}

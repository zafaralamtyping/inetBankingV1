package com.inetbanking.utilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.testcases.BaseClass;

public class Reporting extends BaseClass implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
//	public WebDriver driver = null;
	
	public void onTestStart(ITestResult result) {
	
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Zafar Alam");
	
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());

//		WebDriver driver = null;
//		String testMethodName = result.getMethod().getMethodName();
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			
//		}
//		try {
//			System.out.println("hello...." + testMethodName + "......." + driver);
//			getScreenShot(testMethodName, driver);
//		} catch (Exception e) {
//		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
			}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}

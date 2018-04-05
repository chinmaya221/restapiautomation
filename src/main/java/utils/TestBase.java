package utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.rest.services.Service;

public class TestBase {
	
	public static Service service;
	public static Properties prop;
	
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeTest
	 public void SetUp() throws Exception
	 {
		DOMConfigurator.configure("./application_logs/log4j.xml");
		System.out.println("start------ ExtentReportStart");
		report = new ExtentReports(System.getProperty("user.dir")
				+ "/test-output/ExtentReport/JiraApiAutomationExtentResult.html",
				true);
		report.addSystemInfo("Host Name", "localhost:8080")
				.addSystemInfo("Environment", "RestAPI Automation Testing")
				.addSystemInfo("User Name", "Chinmaya QA");
		report.loadConfig(new File(System.getProperty("user.dir")
				+ "\\test-output\\extent-config.xml"));
		System.out.println("started------ ExtentReportStart");
	 }
	
	@BeforeMethod
	public void nameBefore(Method method) {
		logger = report.startTest(method.getName());
	}
	
	@AfterMethod
	public void TestResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,
					"Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL,
					"Test Case Failed is " + result.getThrowable());
			logger.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP,
					"Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,
					"Test Case Success  is " + result.getName());
		}
		report.endTest(logger);
	}
	
	@AfterSuite
	public void tearDown()
	{
		report.flush();
		report.close();
	}
	
	 

}

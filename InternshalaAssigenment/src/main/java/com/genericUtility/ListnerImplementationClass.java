package com.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log("Execution start from here", true);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName + "-------> executed successfully");

	}

	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		try {
			String screenshot = WebDriverUtility.getScreenShot(Baseclass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName + "---->failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screenshot);
			Reporter.log(MethodName + "----Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + "---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName + "---> Skipped");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("Fiducia");
		htmlreport.config().setReportName("SDET-55");
		htmlreport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Plateform", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http:/localhost:8888");
		report.setSystemInfo("ReporterName", "Sadhana");

	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}

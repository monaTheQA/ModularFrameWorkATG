package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtil {
	ExtentSparkReporter htmlReport;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public ReportUtil(String htmlReportFilename)
	{
		htmlReportFilename = htmlReportFilename.trim();
		htmlReport = new ExtentSparkReporter(htmlReportFilename);
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReport);
	}
	
	public void createATestCase(String testcaseName)
	{
		extentTest = extentReports.createTest(testcaseName);
	}
	
	public void addTestLog(Status status, String comment)
	{
		extentTest.log(status, comment);
	}
	
	public void attachedScreenshotToReport(String fileName)
	{
		extentTest.addScreenCaptureFromPath(fileName);
	}
	public void flushReport()
	{
		extentReports.flush();
	}

}

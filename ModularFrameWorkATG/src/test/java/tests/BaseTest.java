package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import commonLibs.CommonDriver;
import pages.HomePage;
import utils.ConfigUtil;
import utils.ReportUtil;
import utils.ScreenshotUtil;

public class BaseTest {
	
	CommonDriver commonDriver;
	String url;
	WebDriver driver;
	HomePage homePage;
	String currentWorkingDirectory;
	String configFileName;
	Properties configProperty;
	String reportFileName;
	ReportUtil reportUtil;
	ScreenshotUtil screenshot;
	
	@BeforeSuite(alwaysRun=true)
	public void preSetUp() throws Exception 
	{
		System.out.println("preSEUPPPPP");
		currentWorkingDirectory = System.getProperty("user.dir");
		System.out.println(currentWorkingDirectory);
		configFileName = currentWorkingDirectory + "\\config\\config.properties";
		System.out.println(configFileName);
		configProperty = ConfigUtil.readProperties(configFileName);
		reportFileName = currentWorkingDirectory + "\\reports\\ATG_Report.html";
		reportUtil = new ReportUtil(reportFileName);
	}
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception
	{
		url = configProperty.getProperty("baseUrl");
		String browserType = configProperty.getProperty("browserType");
		commonDriver = new CommonDriver(browserType);
		driver = commonDriver.getDriver();
		homePage = new HomePage(driver);
		screenshot = new ScreenshotUtil(driver);
		commonDriver.navigateToUrl(url);
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception
	{
		String testcaseName = result.getName();
		long executionTime = System.currentTimeMillis();
		String screenshotFileName = currentWorkingDirectory + "\\screenshots\\"
				+ testcaseName + executionTime + ".png";
		System.out.println(screenshotFileName);
		if(result.getStatus() == ITestResult.FAILURE)
		{
			reportUtil.addTestLog(Status.FAIL, "One or more test fail");
			screenshot.captureAndSaveScreenShot(screenshotFileName);
			reportUtil.attachedScreenshotToReport(screenshotFileName);
		}
	}
	
	@AfterClass
	public void TearDown()
	{
		commonDriver.closeAllDriver();
	}

	@AfterSuite
	public void postTearDownReport()
	{
		reportUtil.flushReport();
	}

}

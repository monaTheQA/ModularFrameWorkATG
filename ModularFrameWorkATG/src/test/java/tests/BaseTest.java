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
	ScreenshotUtil screenShot;
	
	@BeforeSuite(alwaysRun=true)
	public void preSetUp() throws Exception 
	{
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "\\config\\config.properties";
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
		screenShot = new ScreenshotUtil(driver);
		commonDriver.navigateToUrl(url);
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception
	{
		String testCaseName = result.getName();
		long executionTime = System.currentTimeMillis();
		String screenShotFileName = currentWorkingDirectory + "\\screenshots\\"
				+ testCaseName + executionTime + ".png";
		reportUtil.addTestLog(Status.INFO, "ScreenShotFileName: "+screenShotFileName);
		if(result.getStatus() == ITestResult.FAILURE)
		{
			reportUtil.addTestLog(Status.FAIL, "One or more test failed");
			screenShot.captureAndSaveScreenShot(screenShotFileName);
			reportUtil.attachedScreenshotToReport(screenShotFileName);
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

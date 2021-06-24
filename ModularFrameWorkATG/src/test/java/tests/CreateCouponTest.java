package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;

public class CreateCouponTest extends BaseTest{
	
	@Test
	public void createCoupon() throws InterruptedException
	{
		reportUtil.createATestCase("createCoupon");
		HomePage homePage = new HomePage(driver);
		homePage.acceptAlertCookies();	
		String actualResult = commonDriver.getPageTilte();
		String expectedResult = "ATG - Spel på Sport, Häst och Casino";
		Assert.assertEquals(actualResult, expectedResult);
		homePage.clickOnSpelaLink();
		reportUtil.addTestLog(Status.INFO, "Click on Spela  link");
		homePage.scrolDown();		
		homePage.clickOnV4Link();
		homePage.clickOnV41Btn();
		reportUtil.addTestLog(Status.INFO, "Clicked on V41Btn");
		homePage.clickOnV42Btn();
		homePage.clickOnV43Btn();
		homePage.clickOnV4AllBtn();
		homePage.clickOnNewCouponBtn();
		homePage.clickOnBlankCouponBtn();
		String actualResult1 = commonDriver.getPageTilte();
		String expectedResult1 = "V4 Penrith";
		Assert.assertEquals(actualResult1, expectedResult1);
	}

}

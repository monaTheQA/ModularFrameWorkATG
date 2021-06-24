package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;

public class CreateCouponTest extends BaseTest{
	
	@Test(description = "User can open ATG and can create coupon for V4 Häst")
	public void createV4Coupon() throws InterruptedException
	{
		reportUtil.createATestCase("createCoupon");
		HomePage homePage = new HomePage(driver);
		homePage.acceptAlertCookies();	
		String actualHomePageTitle = commonDriver.getPageTilte();
		String expectedHomePageTitle = "ATG - Spel på Sport, Häst och Casino";
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
		
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
		String actualV4Title = commonDriver.getPageTilte();
		String expectedV4Title = "V4 Penrith";
		Assert.assertTrue(actualV4Title.contains(expectedV4Title));
	}
}

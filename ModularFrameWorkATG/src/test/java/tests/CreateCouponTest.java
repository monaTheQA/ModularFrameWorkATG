package tests;

import org.testng.annotations.Test;



import pages.HomePage;

public class CreateCouponTest extends BaseTest{
	
	@Test
	public void createCoupon() throws InterruptedException
	{
		
		HomePage homePage = new HomePage(driver);
		System.out.println("HomePage");
		homePage.acceptAlertCookies();	
		System.out.println("AlertCookies");
		homePage.clickOnSpelaLink();	
		System.out.println("SpelaLink");
		homePage.scrolDown();		
		System.out.println("Scrolldown");
		homePage.clickOnV4Link();
		homePage.clickOnV41Btn();
		homePage.clickOnV42Btn();
		homePage.clickOnV43Btn();
		homePage.clickOnV4AllBtn();
		homePage.clickOnNewCouponBtn();
		homePage.clickOnBlankCouponBtn();
	}

}

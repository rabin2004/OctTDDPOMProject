package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Main;
import pageFactory.FlightPage;
import pageFactory.HomePage;
import pageFactory.RegisterPage;
import pageFactory.SignOnPage;

public class HomePageTest extends Main{
	HomePage hp;
	FlightPage fp;
	RegisterPage rp;
	SignOnPage sop;
	
	@BeforeMethod
	public void loadBrowser() {
		intialization();
		hp = new HomePage();
		fp = new FlightPage();
		rp = new RegisterPage();
		sop = new SignOnPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@Test
	public void registerLinkTest() {
		hp.clickRegisterLink();
		Assert.assertEquals(rp.validateRegisterPage(), prop.getProperty("registerPageTitle"));
	}
	
	@Test
	public void flightLinkTest() {
		hp.clickFlightsLink();
		Assert.assertEquals(fp.validateFlightPage(), prop.getProperty("flightPageTitle"));
	}
	
	@Test
	public void SignOnLinkTest() {
		hp.clickSignOnLink();
		Assert.assertEquals(sop.validateSignOnPage(), prop.getProperty("signOnPageTitle"));
	}
	
	@Test
	public void usernameTxtFieldTesting() {
		Assert.assertTrue(hp.validateVisibilityUsernameTxtField());
		Assert.assertTrue(hp.validateFunctionalityUsernameTxtField());
	}
	
	@Test
	public void passwordTxtFieldTesting() {
		Assert.assertTrue(hp.validateVisibilityPasswordTxtField());
		Assert.assertTrue(hp.validateFunctionalityPasswordTxtField());
	}
	
	@Test
	public void submitBtnTesting() {
		Assert.assertTrue(hp.validateVisibilitySubmitBtn());
		Assert.assertTrue(hp.validateFunctionalitySubmitBtn());
	}
}

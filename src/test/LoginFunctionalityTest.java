package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Main;
import pageFactory.HomePage;
import pageFactory.LoginSuccessPage;

public class LoginFunctionalityTest extends Main{
	HomePage hp;
	LoginSuccessPage lsp;

	@BeforeMethod
	public void loadBrowser() {
		intialization();
		hp = new HomePage();
		lsp = new LoginSuccessPage();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test(dataProvider = "Positive login data")
	public void positiveLoginFunctionalityTest(String username, String password) {
		hp.enterUsernameTxtField(username);
		hp.enterPasswordTxtField(password);
		hp.clickSubmitBtn();
		Assert.assertEquals(lsp.captureLoginSuccessMsg(), prop.getProperty("loginSuccessMsg"));
	}
	
	@DataProvider(name = "Positive login data")
	public Object[][] getData() {
		Object[][] data = {{"test123","123"},{"test","123"},{"test123","123"},{"test","123"}};
		return data;
	}

}

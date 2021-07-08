package pageFactory;

import org.openqa.selenium.support.PageFactory;

import base.Main;

public class RegisterPage extends Main{

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateRegisterPage() {
		return driver.getTitle();
	}
}

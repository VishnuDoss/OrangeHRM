package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LogIn;
import wrapperclasses.BrowserInitiation;

public class LoginTest extends BrowserInitiation{
	
	
	@Test
	@Parameters({"user"})
	public void Login(String user) throws Exception {
		LogIn login =new LogIn(driver);
		HomePage homePage=new HomePage(driver);
		LogIn.login(user);
		HomePage.accountVerification(user);
		HomePage.logOut();
	}

}

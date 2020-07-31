package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wrapperclasses.ActionItems;
import wrapperclasses.BrowserInitiation;

public class LogIn extends ActionItems{
	
	
	public LogIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	@FindBy (xpath="//*[@class='btn btn-primary dropdown-toggle']")
	public static WebElement loginDiffRoll;
	
	public static void login(String user) throws Exception {
		
		clickElement(loginDiffRoll);
		BrowserInitiation.driver.findElement(By.xpath("//*[@data-username='"+user+"']")).click();	
	}
	
}

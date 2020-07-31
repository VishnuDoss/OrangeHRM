package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import wrapperclasses.ActionItems;
import wrapperclasses.BrowserInitiation;

public class HomePage extends ActionItems{
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="account-name")
	public static WebElement accountName;
	
	@FindBy (id="user-dropdown")
	public static WebElement user;
	
	@FindBy (xpath="//*[text()='Logout']")
	public static WebElement logOut;
	
	@FindBy (xpath="//*[text()='PIM']")
	public static WebElement pim;
	
	@FindBy (xpath="//*[text()='Employee List']")
	public static WebElement employeeList;
	
	public static void accountVerification(String user) throws Exception{
	
	System.out.println("Account Verification");
	System.out.println(accountName.getText());
	Thread.sleep(5000);
	switch (user)
	{
	case "admin": Assert.assertEquals(accountName.getText(), "Jacqueline White");
	System.out.println("Logged in as "+user);
	break;
	case "_ohrmSysAdmin_": Assert.assertEquals(accountName.getText(), "System Admin");
	System.out.println("Logged in as "+user);
	break;
	case "linda": Assert.assertEquals(accountName.getText(), "Linda Anderson");
	System.out.println("Logged in as "+user);
	break;
	case "kevin": Assert.assertEquals(accountName.getText(), "Kevin Mathews");
	System.out.println("Logged in as "+user);
	break;
	
	}
		
		
	}
	
	public static void logOut() throws Exception {
		
		clickElement(user);
		Thread.sleep(2000);
		clickElement(logOut);
	}
	
public static void pim() throws Exception {
		
		clickElement(pim);
		Thread.sleep(2000);
	}

public static void empList() throws Exception {
	
	clickElement(employeeList);
	Thread.sleep(2000);
}
	
public static void fetchEmpDetails() throws Exception {
	
   String empId=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/preceding-sibling::td[1]")).getText();
   String empName=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']")).getText();
   String empJob=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/following-sibling::td[1]")).getText();
   String empStatus=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/following-sibling::td[2]")).getText();
   String empUnit=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/following-sibling::td[3]")).getText();
   String empCenter=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/following-sibling::td[4]")).getText();
   String empLocation=BrowserInitiation.driver.findElement(By.xpath("//*[text()='Odis  Adalwin ']/following-sibling::td[5]")).getText();
   
   System.out.println(empId+" "+empName+" "+empJob+" "+empStatus+" "+empUnit+" "+empCenter+" "+empLocation);
	
}	

}

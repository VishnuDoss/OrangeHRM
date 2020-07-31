package wrapperclasses;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class BrowserInitiation{
	
	public static WebDriver driver;
	public static OperatingSystem WIN;
	public static OperatingSystem MAC;

	
	@BeforeTest
	@Parameters({"os", "browser", "url"})
	public static WebDriver browserinit(String os, String browser, String url) {
		
		
		if(os.equalsIgnoreCase("Windows") || browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().operatingSystem(WIN.WIN).setup();
			driver= new ChromeDriver();
		}
		else if(os.equalsIgnoreCase("Windows") || browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().operatingSystem(WIN.WIN).setup();
			driver= new FirefoxDriver();
		}
		else if(os.equalsIgnoreCase("Mac") || browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().operatingSystem(MAC.MAC).setup();
			driver= new ChromeDriver();
		}
		else if(os.equalsIgnoreCase("Mac") || browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().operatingSystem(MAC.MAC).setup();
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		return driver;
		
	}
	
	@AfterTest
	public static void browserClose(){
		
		driver.quit();
		
	}

	
}

package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC006_StaleElementExceptionPractice {
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}	
	@Test
	public void TDStaleTest() {
		
        driver.findElement(By.id("bmwcheck")).click();
		driver.get(driver.getCurrentUrl());
		driver.findElement(By.id("bmwcheck")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	}
	

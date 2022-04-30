package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Mouse Actions

public class TC004_TDBanking_MouseActions {

WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.td.com/");
		driver.manage().window().maximize();
	}	
	@Test
	public void MouseMovementOnProducts() throws InterruptedException {
		
		driver.findElement(By.id("ensCall")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement products = driver.findElement(By.id("td-desktop-nav-dropdown-link-2"));
		Actions action = new Actions(driver);
	    action.moveToElement(products).build().perform();
	    driver.findElement(By.linkText("Mortgages")).click();
	 	
	}	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}

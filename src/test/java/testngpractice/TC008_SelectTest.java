package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC008_SelectTest {
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseurl = "https://demo.opencart.com/";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void selectColor() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement desktopLink =driver.findElement(By.linkText("Desktops"));
		action.moveToElement(desktopLink).build().perform();
		driver.findElement(By.linkText("Show All Desktops")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("//a[contains(text(),'Apple Cinema 30')]")).click();
		js.executeScript("window.scrollBy(0,1000)");
        WebElement selColor=driver.findElement(By.id("input-option217"));
        Select sel= new Select(selColor);
        System.out.println(sel.getOptions());
        sel.selectByIndex(2);
        Thread.sleep(1000);
        sel.selectByValue("3");
        Thread.sleep(1000);
        sel.selectByVisibleText("Green (+$1.20)");
        Thread.sleep(2000);
        
        //sel.deselectByVisibleText("Green (+$1.20)");-->Can be used for only multiselect
       
}
	
	
	@AfterMethod
	public void teardown()
	{driver.quit();
	}
	}
	
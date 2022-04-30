package testngpractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_TvoPageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tvo.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	/*@Test
	public void tvoorgScrollTest() throws InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400)");
		Thread.sleep(2000);
		System.out.println("Window scroll back to top");
		js.executeScript("window.scrollBy(0,-1000)");
	}*/
	
	/*@Test
	public void tvoorgWindowHandleTest() throws InterruptedException {
		
		String handle= driver.getWindowHandle();
		System.out.println("Parent window address: "+ handle);
		
	}*/
	@Test
	public void tvoorgWindowHandlesTest() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Make a donation']")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/span[2]/span[1]")).click();
		Set<String> handle =driver.getWindowHandles();
		Iterator<String> it =handle.iterator();
		String parentWindow =it.next();
		String childWindowOne = it.next();
		String childWindowTwo = it.next();
		driver.switchTo().window(childWindowOne);
		System.out.println(childWindowOne);
		driver.switchTo().window(childWindowOne);

		System.out.println(childWindowTwo);

 	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}

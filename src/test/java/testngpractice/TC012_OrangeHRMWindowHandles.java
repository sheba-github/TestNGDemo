package testngpractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC012_OrangeHRMWindowHandles {
WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl ="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
	@Test
	public void windowHandleTest() {
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindowID =it.next();
		String childWindowIDOne=it.next();
		String childWindowIDTwo=it.next();
		String childWindowIDThree=it.next();
		//Trying to close just the child windows
		
		System.out.println("Parent ID: "+parentWindowID);
		driver.switchTo().window(childWindowIDOne);
		System.out.println("First Child ID : "+childWindowIDOne);
		driver.close();
		driver.switchTo().window(childWindowIDTwo);
		System.out.println("Second Child ID: "+childWindowIDTwo);
		driver.close();
		driver.switchTo().window(childWindowIDThree);
		System.out.println("Third Child ID: "+childWindowIDThree);
		driver.close();
		driver.switchTo().window("parentWindowID");
		
		
     		
	}
	/*@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}*/
	
	
}

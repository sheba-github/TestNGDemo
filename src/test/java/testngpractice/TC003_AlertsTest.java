package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003_AlertsTest {
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseurl = "http://demo.automationtesting.in/Alerts.html";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	 @Test
	 public void AlertAccept() {
		 driver.findElement(By.id("OKTab")).click();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
	 }
	 @Test
	 public void AlertDismiss() throws InterruptedException {
		 driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li[2]")).click();
		 driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
     	 Alert alert = driver.switchTo().alert();
     	 Thread.sleep(2000);
		 alert.dismiss();
		 
	 }
	 @Test
	 public void AlertWithTextBox() throws InterruptedException {
		 driver.findElement(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li[3]")).click();
		 driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		 Alert alert = driver.switchTo().alert();
		 System.out.println(alert.getText());
     	 Thread.sleep(2000);

		 
	 }
	
	  @AfterMethod
	   public void teardown() {
		   
		   driver.quit();
		   
	   }
}

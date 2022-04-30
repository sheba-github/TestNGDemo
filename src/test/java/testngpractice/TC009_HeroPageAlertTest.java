package testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Alert Text

public class TC009_HeroPageAlertTest {
WebDriver driver;
	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseurl = "http://the-internet.herokuapp.com/javascript_alerts";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void HeroPageAlert() throws InterruptedException {
		WebElement promptButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
     	promptButton.click();
     	Alert alert= driver.switchTo().alert();
     	alert.getText();
		alert.sendKeys("Hello all");
     	alert.accept();
     	System.out.println((driver.findElement(By.id("result")).getText()));
		}
	
	
}

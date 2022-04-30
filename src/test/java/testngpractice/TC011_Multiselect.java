package testngpractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC011_Multiselect {
	
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseurl = "https://courses.letskodeit.com/practice";
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	@Test
	public void multiselectTest() throws InterruptedException {
		
		
		WebElement multiselectOptions = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(multiselectOptions);
		sel.selectByValue("apple");
		sel.selectByIndex(1);
		//sel.deselectAll();	
		sel.deselectByVisibleText("Orange");
		Thread.sleep(2000);
	}
	 @AfterMethod
	   public void teardown() {
		   
		   driver.quit();
		   
	   }
}

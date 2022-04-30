package testngpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//not working
public class TC010_JSToOpenSite {
	WebDriver driver;
	private static String url ="https://devqa.io";

	@Test
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.open = \'"+url+"\'");
		driver.manage().window().maximize();
	}
	
	
	
	

}

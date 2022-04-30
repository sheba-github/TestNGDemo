package testngpractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC005_ScreenshotTest {
	
WebDriver driver;
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.td.com/");
		driver.manage().window().maximize();
	}	
	@Test
	public void TDBankScreenshot() throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\screenshot\\TDBankScreenprint.jpg"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000);");
		
		File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("C:\\screenshot\\TDBankFooterScreenprint.jpg"));
	
		
	}	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
	
	


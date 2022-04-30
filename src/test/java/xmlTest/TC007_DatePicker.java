package xmlTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC007_DatePicker {
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
	public void DatePickerTest() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement desktopLink =driver.findElement(By.linkText("Desktops"));
		action.moveToElement(desktopLink).build().perform();
		driver.findElement(By.linkText("Show All Desktops")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("//a[contains(text(),'Apple Cinema 30')]")).click();
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//div[@class='input-group date']/span")).click();
        String month ="May 2011";
        String day ="1";
        
       while(true)
       {
       String monthText= driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
       System.out.println(monthText);
       if(monthText.equals(month))
       {
    	   break;
       }       
       else {
    	   
    	   driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
       }}
       
       driver.findElement(By.xpath("//tbody/tr[1]/td[7]")).click();
       Thread.sleep(2000);
       	
	}
		
	@AfterMethod
	   public void teardown() {
		   
		   driver.quit();
		   
	   }


}

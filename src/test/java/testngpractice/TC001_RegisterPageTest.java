package testngpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//To test the Register Page using Testng
//Sendkeys
//Select class ,FileUpload

public class TC001_RegisterPageTest {

			WebDriver driver;

		@BeforeMethod
		public void SetUp() {

			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			String baseurl = "http://demo.automationtesting.in/Register.html";
			driver.get(baseurl);
			driver.manage().window().maximize();
		}
		
		@Test
		public void RegisterFormTextField() throws InterruptedException {
			
			driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Sheba");
	    	driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Saras");
			driver.findElement(By.cssSelector("textarea.form-control.ng-pristine.ng-untouched.ng-valid")).sendKeys("123 Drive,Toronto");
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("reachautotest2022@gmail.com");
	        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("16457867898");
	        Thread.sleep(1000);
				}
		
	   @Test
	   public void  RegisterFormRadioButtonAndCheckBox() throws InterruptedException
	   {
		   driver.findElement(By.xpath("//input[@value='FeMale']")).click();
		   driver.findElement(By.cssSelector("input#checkbox2")).click();
		   Thread.sleep(1000);
		   
	   }
	  
	   @Test
	   public void  RegisterFormDropdown() throws InterruptedException  
	   
	   {
		   WebElement skillsOptions= driver.findElement(By.id("Skills"));
		   Select options = new Select(skillsOptions);
		   options.selectByIndex(2);
		   options.selectByVisibleText("Android");
		   options.selectByValue("APIs");
		   System.out.println(options.getFirstSelectedOption().getText());
		   Thread.sleep(1000);
	   }
	   
	   @Test
	   public void RegisterFileUpload() throws InterruptedException
	   {  System.out.println("File Upload");
		   driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\Saravanan\\Desktop\\pic.jpg");
		   String fileName=driver.findElement(By.xpath("//input[@id='imagesrc']")).getText();
          System.out.println("File Uploaded: "+fileName );
		   
	   }   
	   
	   @Test
	   public void AutosuggestiveBox() throws InterruptedException {
		   System.out.println("AutoSuggestive");
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,1200)");
		   driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']")).click();
		   driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("IND");
		   
		   
		  List<WebElement> countryOptions =driver.findElements(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']"));
	      for(WebElement option:countryOptions )
	      {if(option.getText().equals("India"))
	      {
              option.click();
              break;
	      }
	    Thread.sleep(2000);
	      }
	      String selectCountryText =driver.findElement(By.id("select2-country-container")).getText();
          System.out.println("Text selected: "+selectCountryText);
	
	   }
	   
	   @AfterMethod
	   public void teardown() {
		   
		   driver.quit();
		   
	   }
	   
	}

	
	


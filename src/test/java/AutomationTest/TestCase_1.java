package AutomationTest;

import static org.testng.Assert.assertEquals;

import java.awt.JobAttributes.DefaultSelectionType;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TestCase_1 {
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	@Test(priority = 1)
	public void homepageTitleverification() {
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(title,"OrangeHRM","Incorrect Title");
		
	}
	
	@Test (priority = 1)
	public void signup() throws InterruptedException {
		Thread.sleep(5000);
	       WebElement UserName=driver.findElement(By.xpath("//input[@name='username']"));
	       UserName.sendKeys("Admin");
	       WebElement Pass=driver.findElement(By.xpath("//input[@name='password']"));
	       Pass.sendKeys("admin123");
	       WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
	       loginBtn.click();
	       String title2= driver.getCurrentUrl();
	       
	       //validation
	       if(title2.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
	    	   System.out.println("You are on home page");
	    	   
	       }
	       else {
	    	   System.out.println("Incorrect Action");
	    	   driver.close();
	       }
	       Thread.sleep(5000);
	       }
	      

	
	   	@Test(priority = 2,enabled = false)
		public void Admin() throws InterruptedException{
		
		WebElement AdminBtn=driver.findElement(By.cssSelector("[class=\"oxd-main-menu\"] li:nth-child(1)"));
		AdminBtn.click();    
		
		//validation
		
		if(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers")) {
			
			Thread.sleep(5000);
			WebElement UserName=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
			UserName.sendKeys("Shubhbm");
			
			WebElement UserRole=driver.findElement(By.cssSelector(".oxd-select-text--active[data-v-13cf171c]"));
			  System.out.println( UserRole.getTagName());
		
				  
			  }
		
		
	   	}
	   	
	   	@Test(priority = 3)
	   	public void timeSheet() throws InterruptedException {
	   		Thread.sleep(5000);
	   		WebElement Timesheet= driver.findElement(By.cssSelector("[class='oxd-main-menu'] li:nth-child(4)"));
	   		Timesheet.click();
	   		
	   		Thread.sleep(5000);
	   		WebElement Mytimesheet=driver.findElement(By.cssSelector("[class=\"oxd-topbar-body\"] nav ul:nth-child(1) li:nth-child(1) span"));
	   		
	        Select Iteam =new Select(Timesheet);
	        Iteam.selectByVisibleText("My Timesheets");
	   
	   	}
		
		}
		
	       
	       
	




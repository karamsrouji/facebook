import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class facebookTest1 {
	WebDriver driver =new EdgeDriver () ;
	SoftAssert myassert =new SoftAssert();
	
	// ------------------------------------- to open facebook page 
	
	@BeforeTest
	public void startTest () {
		//driver.get("https://web.facebook.com/login.php/?_rdc=1&_rdr");
		String fbUrl = "https://www.fb.com";
		String facebookUrl = "https://www.facebook.com";
driver.get(fbUrl);
		
		String urlFromBrowser = driver.getCurrentUrl();
		
		if(urlFromBrowser.equalsIgnoreCase(facebookUrl)) {
			System.out.println("fb has redirected to facebook");
		} else {
			System.out.println("No redirection happened");
		}
		
		
	}
	
	// ------------------------------------------------------ create email in facebook 
	
	
	@Test()
	public void signupTest () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://web.facebook.com/reg/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjgyMzA0Njk2LCJjYWxsc2l0ZV9pZCI6MzYzOTY5MDQ0ODc4OTI4fQ%3D%3D");
		Thread.sleep(3000) ; 
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/input")).sendKeys("Test");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div[1]/div[2]/div/div[1]/input")).sendKeys("User");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[2]/div/div[1]/input")).sendKeys("testuser@test.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[3]/div/div/div[1]/input")).sendKeys("testuser@test.com");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[4]/div/div[1]/input")).sendKeys("testPassword");
		
		Select selDate = new Select(driver.findElement(By.id("day")));
		Select selMonth = new Select(driver.findElement(By.id("month")));
		Select selYear = new Select(driver.findElement(By.id("year")));
		
		selDate.selectByVisibleText("21");
		selMonth.selectByVisibleText("Jun");
		selYear.selectByVisibleText("1989");
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
		
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}
	@AfterTest 
	public void endTest () {
		driver.quit();
	}
}


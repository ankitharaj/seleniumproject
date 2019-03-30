package testNGpackages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngclass1 {
	
	
	WebDriver driver = null;
	
	@BeforeTest 
	public void beforethetest() {
		System.out.println("im in before step");
		  if(driver==null) {
		     System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANKITHA\\Downloads\\chromedriver.exe");
		       driver = new ChromeDriver();
		}	
	}
 
	@BeforeMethod
	public void beforethemethod() {
		System.out.println("i am in beforemethod");
		driver.get("https://www.amazon.in");
	}
	
	@AfterTest
	public void afterthetest() {
	System.out.println("i am in aftertest");
	driver.quit();
	}
	
	@AfterMethod
	public void afterthemethod() {
		
	}
	
	@Test
     public void tastcase01() {
		
		Select s=new Select( driver.findElement(By.xpath("//*[@name=\"url\"]")));
		s.selectByValue("search-alias=electronics");
		
	}
	
	@Test
    public void tastcase02() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		
	
	}
	
	@Test
	public void tastcase03() {
		
		driver.findElement(By.linkText("Amazon Pay")).click();
	}
	
}

package org.sspart.seleniumproject1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switchbrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANKITHA\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		String currentwindowHandle =driver.getWindowHandle();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String>windowHandles=driver.getWindowHandles();
		for(String eachHandle:windowHandles) {
			driver.switchTo().window(eachHandle);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean bool= false;
			try {
				bool=driver.findElement(By.xpath("//*[@name=\"emailid\"]")).isDisplayed();
			}catch(Exception  ignore) {
				
			if(bool) 
				
				driver.close();
			}
		}
		driver.switchTo().window(currentwindowHandle);

		
		//driver.close();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}

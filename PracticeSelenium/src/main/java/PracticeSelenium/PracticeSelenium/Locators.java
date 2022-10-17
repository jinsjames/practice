package PracticeSelenium.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main (String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://partner-portal-app.azurewebsites.net/");
		
		//Tag and Id
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("ddmpsitdist1ita@oq-ddmp.recharge365.com");
		
		//Tag and Class
//		driver.findElement(By.cssSelector("input.form-control")).sendKeys("R365@12345");
		
		//Tag and Attribute
		driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("R365@12345");
		
		//Thread.sleep(5000);
		
		//Tag, class & Attribute
//		driver.findElement(By.cssSelector("div.controls[id=btnLogin]")).click();
		
		//Inner text
//		driver.findElement(By.cssSelector("font:contains("Login:")")).click();
		
	}

}

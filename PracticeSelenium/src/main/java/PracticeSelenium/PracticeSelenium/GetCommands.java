package PracticeSelenium.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://partner-portal-app.azurewebsites.net/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String text = driver.findElement(By.xpath("//h4[contains(text(),'DDMP Hierarchy Portal')]")).getText();
		System.out.println(text);
		
		driver.close();
	}

}

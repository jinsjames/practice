package PracticeSelenium.PracticeSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		System.out.println("First title: "+ driver.getTitle());
		driver.navigate().to("https://www.instagram.com/");
		System.out.println("Title after navigate to: "+driver.getTitle());
		driver.navigate().back();
		System.out.println("Title after navigate back: "+driver.getTitle());
		driver.navigate().forward();
		System.out.println("Title after navigate forward: "+driver.getTitle());
		driver.navigate().refresh();
		driver.close();

	}

}

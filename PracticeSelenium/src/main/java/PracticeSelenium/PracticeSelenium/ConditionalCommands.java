package PracticeSelenium.PracticeSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://partner-portal-app.azurewebsites.net/");
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		System.out.println(username.isDisplayed());
		System.out.println(password.isDisplayed());
		
		if (username.isDisplayed() && username.isEnabled()) {
			
			username.sendKeys("ddmpsitpita@oq-ddmp.recharge365.com");
		}
		
		if (password.isDisplayed() && password.isEnabled()) {
			
			password.sendKeys("R365@12345");
		}
		
		WebElement keepmesignedin = driver.findElement(By.xpath("//label[contains(text(),'Keep me signed in')]"));
		System.out.println(keepmesignedin.isSelected());
		//Thread.sleep(6000);
		if (keepmesignedin.isSelected() == false) {
			
			keepmesignedin.click();
		}
		System.out.println(keepmesignedin.isSelected());

	}

}

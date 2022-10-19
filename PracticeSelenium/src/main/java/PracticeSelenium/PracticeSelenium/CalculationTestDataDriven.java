package PracticeSelenium.PracticeSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTestDataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		// to locate excel
		FileInputStream file = new FileInputStream("C:\\Automation\\ExcelSheets\\caldata.xlsx");
		
		//to access workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//to access sheet in the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		// to get the row count
		int rowcount = sheet.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++) {
			
			XSSFRow currentrow = sheet.getRow(i);
			
//			XSSFCell principle = currentrow.getCell(0);
//			int princ = (int)principle.getNumericCellValue(); // this method is called type casting. to avoid decimal values
			//or
			int princ = (int)currentrow.getCell(0).getNumericCellValue();
			int roi = (int)currentrow.getCell(1).getNumericCellValue();
			int per = (int) currentrow.getCell(2).getNumericCellValue();
			int matval = (int) currentrow.getCell(4).getNumericCellValue();
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			
			Select tenureperiod = new Select(driver.findElement(By.id("tenurePeriod")));
			tenureperiod.selectByValue("1");
			
			Select frequency = new Select(driver.findElement(By.id("frequency")));
			frequency.selectByValue("0");
			
			driver.findElement(By.xpath("//body/div[@id='mc_mainWrapper']/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[1]/img[1]")).click();
			
			String actual_mvalue = driver.findElement(By.id("resp_matval")).getText();
			
			if(Double.parseDouble(actual_mvalue)==matval) {
				
				System.out.println("Test passed");
			}
			else {
				System.out.println("Test failed");
			
			}
			driver.findElement(By.xpath("//body/div[@id='mc_mainWrapper']/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[2]/img[1]")).click();
		}
		
		driver.close();
		driver.quit();

	}

}

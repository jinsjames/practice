package PracticeSelenium.PracticeSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromExcelAndWritingToWebApp {

	public static void main(String[] args) throws IOException {
		// Excel - Workbook - Sheet - Row - Cell
	    // FileInputStream, XSSFWorkbook, XSSFSheet, XSSFRow, XSSFCell
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://partner-portal-app.azurewebsites.net/");
		
		FileInputStream file = new FileInputStream("C:\\Automation\\ExcelSheets\\Book1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowcount;i++) {
			
			XSSFRow currentrow = sheet.getRow(i);
			
			for(int j=0;j<colcount;j++) {
				
				String value = currentrow.getCell(j).toString();
				System.out.print(" "+value);
			}
			System.out.println();
		}
		

			
			XSSFRow currrow = sheet.getRow(1);
			
			String email = currrow.getCell(4).getStringCellValue();
			String pass = currrow.getCell(5).getStringCellValue();
			
			driver.findElement(By.id("txtUsername")).sendKeys(email);
			driver.findElement(By.id("txtPassword")).sendKeys(pass);
	
}

}

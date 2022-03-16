package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExelSheet(String sheet, int row,int cell) throws EncryptedDocumentException, IOException {
		
		String path="D:\\mywork\\Exel1.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		String data= WorkbookFactory.create(file).getSheet("anil").getRow(row).getCell(cell).getStringCellValue();
		
		return data;
		
		
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException {
		
		
		TakesScreenshot s= (TakesScreenshot)driver;
		
		File source=s.getScreenshotAs(OutputType.FILE);
		File dest =new File("D:\\TakeScreenShot\\Test"+".jpg");
		FileHandler.copy(source, dest);
		
	}
	


}

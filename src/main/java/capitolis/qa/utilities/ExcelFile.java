package capitolis.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import capitolis.qa.reports.Java_Logger;
import capitolis.qa.reports.LoggerClass;

public class ExcelFile {

	Workbook workbook;
	Sheet sheet;
	double taxValue = 0;

	public void taxValueFromExcel(int sheetNum) {

		String os = System.getProperty("os.name");
		String user = System.getProperty("user.name");
		String path = null;
		String excelPath = null;
		if (os.toLowerCase().contains("mac")) {
			path = "/Users/" + user + "/Downloads/";
		} else if (os.toLowerCase().contains("win")) {
			path = "C:/Users/" + user + "/Downloads/";
		}
		File file = new File(path);
		boolean isDirectory = file.isDirectory();
		if (isDirectory) {
			File[] files = file.listFiles();
			for (File eachFile : files) {
				Java_Logger.getLog(eachFile.getName());
				if (eachFile.getName().equalsIgnoreCase("menu.xls")) {
					excelPath = eachFile.getAbsolutePath();
					try {
						if (excelPath.endsWith(".xls")) {
							workbook = new HSSFWorkbook(new FileInputStream(excelPath));
							sheet = (HSSFSheet) workbook.getSheetAt(sheetNum);
						} else if (excelPath.endsWith(".xlsx")) {
							workbook = new XSSFWorkbook(new FileInputStream(excelPath));
							sheet = (XSSFSheet) workbook.getSheetAt(sheetNum);
						} else {
							LoggerClass.log("File Not Supported");
						}
					} catch (IOException e) {
						e.printStackTrace();
						LoggerClass.log("File Not Found");
					}
					LoggerClass.log("File has been found");
					break;
				} else {
					LoggerClass.log("File not found");
				}
			}
		}
		int cells = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < cells; i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase("tax")) {
				taxValue = sheet.getRow(1).getCell(i).getNumericCellValue();
				LoggerClass.log("tax: " + taxValue);
			}
		}
	}

	public String validateExcel() {
		String excelSheetPath = null;
		String os = System.getProperty("os.name");
		String user = System.getProperty("user.name");
		String path = null;
		if (os.toLowerCase().contains("mac")) {
			path = "/Users/" + user + "/Downloads/";

		} else if (os.toLowerCase().contains("win")) {
			path = "C:/Users/" + user + "/Downloads/";
		}
		File file = new File(path);
		boolean isDirectory = file.isDirectory();
		if (isDirectory) {
			File[] files = file.listFiles();
			for (File eachFile : files) {
				LoggerClass.log(eachFile.getName());
				if (eachFile.getName().equalsIgnoreCase("menu.xls")) {
					LoggerClass.log(eachFile.getAbsolutePath());
					excelSheetPath = eachFile.getAbsolutePath();
					LoggerClass.log("File has been found");
					break;
				}
			}
		}
		return excelSheetPath;
	}

}

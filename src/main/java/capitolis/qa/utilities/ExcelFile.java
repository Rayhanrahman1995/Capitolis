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
							Java_Logger.getLog("File Not Supported");
							// System.out.println("File Not Supported");
						}
					} catch (IOException e) {
						e.printStackTrace();
						Java_Logger.getLog("File Not Found");
						// System.out.println("File Not Found");
					}
					Java_Logger.getLog("File has been found");
					break;
				} else {
					Java_Logger.getLog("File Not Found");
				}
			}
		}
		int cells = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < cells; i++) {
			if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase("tax")) {
				taxValue = sheet.getRow(1).getCell(i).getNumericCellValue();
				Java_Logger.getLog("tax: " + taxValue);
				System.out.println("tax: " + taxValue);
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
				Java_Logger.getLog(eachFile.getName());
				// System.out.println(eachFile.getName());
				if (eachFile.getName().equalsIgnoreCase("menu.xls")) {
					// Java_Logger.getLog(eachFile.getAbsolutePath());
					excelSheetPath = eachFile.getAbsolutePath();
					Java_Logger.getLog("File has been found");
					// System.out.println("File has been found");
					break;
				}
			}
		}
		return excelSheetPath;
	}

}

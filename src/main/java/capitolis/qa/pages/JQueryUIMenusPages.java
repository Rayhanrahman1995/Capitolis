package capitolis.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capitolis.qa.common.CommonActions;
import capitolis.qa.utilities.ExcelFile;

public class JQueryUIMenusPages {

	public JQueryUIMenusPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='JQuery UI Menus']")
	public WebElement JQueryUIMenus;
	@FindBy(xpath = "//a[@id='ui-id-2']")
	public WebElement Enabled;
	@FindBy(xpath = "//a[text()='Downloads']")
	public WebElement Downloads;
	@FindBy(id = "ui-id-8")
	public WebElement Excel;

	public void jQueryUIMenusButton(CommonActions ca) {
		ca.clickMethod(JQueryUIMenus);
	}

	public void chooseEnabled(CommonActions ca, WebDriver driver) {
		ca.hoverOver(driver, Enabled);
	}

	public void chooseDownloads(CommonActions ca) {
		ca.clickMethod(Downloads);
	}

	public void chooseExcel(CommonActions ca) {
		ca.clickMethod(Excel);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void excelFileValidation(ExcelFile eF) {
		eF.validateExcel();
	}

	public void taxValue(ExcelFile eF, int sheetNum) {
		eF.taxValueFromExcel(sheetNum);
	}

}

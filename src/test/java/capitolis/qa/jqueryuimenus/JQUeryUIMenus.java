package capitolis.qa.jqueryuimenus;

import org.testng.annotations.Test;
import capitolis.qa.base.BaseClass;

public class JQUeryUIMenus extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void jQueryUIMenusButtonTest() {
		jqum.jQueryUIMenusButton(cm);
	}

	@Test(priority = 2, enabled = true)
	public void chooseEnabledTest() {
		jqum.jQueryUIMenusButton(cm);
		jqum.chooseEnabled(cm, driver);
	}

	@Test(priority = 3, enabled = true)
	public void chooseDownloadsTest() {
		jqum.jQueryUIMenusButton(cm);
		jqum.chooseEnabled(cm, driver);
		jqum.chooseDownloads(cm);
	}

	@Test(priority = 4, enabled = true)
	public void chooseExcelTest() {
		jqum.jQueryUIMenusButton(cm);
		jqum.chooseEnabled(cm, driver);
		jqum.chooseDownloads(cm);
		jqum.chooseExcel(cm);
	}

	@Test(priority = 5, enabled = true)
	public void excelFileValidationTest() {
		jqum.jQueryUIMenusButton(cm);
		jqum.chooseEnabled(cm, driver);
		jqum.chooseDownloads(cm);
		jqum.chooseExcel(cm);
		jqum.excelFileValidation(eF);
	}

	@Test(priority = 6, enabled = true)
	public void taxValueTest() {
		jqum.jQueryUIMenusButton(cm);
		jqum.chooseEnabled(cm, driver);
		jqum.chooseDownloads(cm);
		jqum.chooseExcel(cm);
		jqum.excelFileValidation(eF);
		jqum.taxValue(eF,configProperty.getSheetNum());
	}
}

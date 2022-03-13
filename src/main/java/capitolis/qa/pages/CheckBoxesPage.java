package capitolis.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capitolis.qa.common.CommonActions;

public class CheckBoxesPage {

	public CheckBoxesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Checkboxes']")
	public WebElement CheckBoxes;
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement CheckBox1;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement CheckBox2;

	public void checkBoxes(CommonActions ca) {
		ca.getText(CheckBoxes, "Checkboxes");
		ca.clickMethod(CheckBoxes);
	}

	public void checkBox1WithoutSelect(CommonActions ca) {
		ca.isChecked(CheckBox1);
	}

	public void checkBox2WithSelect(CommonActions ca) {
		ca.isChecked(CheckBox2);
	}

	public void checkBox1WithSelect(CommonActions ca) {
		ca.isSelectedAfterClick(CheckBox1);
	}

	public void checkBox2WithoutSelect(CommonActions ca) {
		ca.isSelectedAfterClick(CheckBox2);
	}
}

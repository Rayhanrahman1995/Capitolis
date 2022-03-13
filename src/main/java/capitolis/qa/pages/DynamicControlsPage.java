package capitolis.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capitolis.qa.common.CommonActions;

public class DynamicControlsPage {

	public DynamicControlsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	public WebElement DynamicControls;
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement ACheckBox;
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement RemoveButton;
	@FindBy(xpath = "//p[@id='message']")
	public WebElement MessageAfterClickOnRemove;

	public void dynamicControlButton(CommonActions ca) {
		ca.clickMethod(DynamicControls);
	}

	public void aCheckBoxChecked(CommonActions ca) {
		ca.isSelectedAfterClick(ACheckBox);
	}

	public void removeButton(CommonActions ca) {
		ca.clickMethod(RemoveButton);
	}

	public void messageAfterClickOnRemove(CommonActions ca) {
		ca.getText(MessageAfterClickOnRemove, "It's gone!");
	}
}

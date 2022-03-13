package capitolis.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capitolis.qa.common.CommonActions;

public class FramesPage {

	public FramesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Frames']")
	public WebElement FramesButton;
	@FindBy(xpath = "//a[text()='iFrame']")
	public WebElement IFrames;
	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement ClearText;

	public void framesButton(CommonActions ca) {
		ca.clickMethod(FramesButton);
	}

	public void iFrames(CommonActions ca) {
		ca.clickMethod(IFrames);
	}

	public void clearText(CommonActions ca, WebDriver driver) {
		driver.switchTo().frame("mce_0_ifr");
		ca.clearContent(ClearText);
	}

	public void enterName(CommonActions ca) {
		ca.writeText(ClearText, "Rayhan Rahman");
	}

}

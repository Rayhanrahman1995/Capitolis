package capitolis.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capitolis.qa.common.CommonActions;

public class BasicAuthPage {

	public BasicAuthPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Basic Auth']")
	public WebElement BasicAuth;
	@FindBy(xpath = "//p")
	public WebElement BasicAuthMsz;

	public void basicAuthButton(CommonActions ca) {
		ca.clickMethod(BasicAuth);
	}

	public void authenticationPopUpHandle(WebDriver driver) {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

	public void validationAfterPopUpHandle(CommonActions ca) {
		ca.getText(BasicAuthMsz, "Congratulations! You must have the proper credentials.");
	}

}

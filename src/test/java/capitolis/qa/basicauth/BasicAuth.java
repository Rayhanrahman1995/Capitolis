package capitolis.qa.basicauth;

import org.testng.annotations.Test;
import capitolis.qa.base.BaseClass;

public class BasicAuth extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void basicAuthButtonTest() {
		bapage.basicAuthButton(cm);
	}

	@Test(priority = 2, enabled = true)
	public void authenticationPopUpHandleTest() {
		bapage.basicAuthButton(cm);
		bapage.authenticationPopUpHandle(driver);
	}

	@Test(priority = 3, enabled = true)
	public void validationAfterPopUpHandleTest() throws InterruptedException {
		bapage.basicAuthButton(cm);
		bapage.authenticationPopUpHandle(driver);
		bapage.validationAfterPopUpHandle(cm);
		Thread.sleep(5000);
	}
}

package capitolis.qa.frames;

import org.testng.annotations.Test;
import capitolis.qa.base.BaseClass;

public class Frames extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void framesButtonTest() {
		fpage.framesButton(cm);
	}

	@Test(priority = 2, enabled = true)
	public void iFramesButtonTest() {
		fpage.framesButton(cm);
		fpage.iFrames(cm);
	}

	@Test(priority = 3, enabled = true)
	public void clearTextBox() throws InterruptedException {
		fpage.framesButton(cm);
		fpage.iFrames(cm);
		fpage.clearText(cm, driver);
	}

	@Test(priority = 4, enabled = true)
	public void nameInTextBox() throws InterruptedException {
		fpage.framesButton(cm);
		fpage.iFrames(cm);
		fpage.clearText(cm, driver);
		fpage.enterName(cm);
	}
}

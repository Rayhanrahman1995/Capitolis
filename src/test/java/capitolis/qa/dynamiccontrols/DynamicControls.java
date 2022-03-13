package capitolis.qa.dynamiccontrols;

import org.testng.annotations.Test;
import capitolis.qa.base.BaseClass;

public class DynamicControls extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void dynamicControlsButtonTest() {
		dcp.dynamicControlButton(cm);
	}

	@Test(priority = 2, enabled = true)
	public void aCheckBoxCheckedTest() {
		dcp.dynamicControlButton(cm);
		dcp.aCheckBoxChecked(cm);
	}

	@Test(priority = 3, enabled = true)
	public void removeButtonTest() {
		dcp.dynamicControlButton(cm);
		dcp.aCheckBoxChecked(cm);
		dcp.removeButton(cm);
	}

	@Test(priority = 4, enabled = true)
	public void messageAfterClickOnRemoveTest() throws InterruptedException {
		dcp.dynamicControlButton(cm);
		dcp.aCheckBoxChecked(cm);
		dcp.removeButton(cm);
		dcp.messageAfterClickOnRemove(cm);
		Thread.sleep(5000);
	}
}

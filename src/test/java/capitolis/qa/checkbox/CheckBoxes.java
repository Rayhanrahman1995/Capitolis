package capitolis.qa.checkbox;

import org.testng.annotations.Test;
import capitolis.qa.base.BaseClass;

public class CheckBoxes extends BaseClass {

	@Test(priority = 1, enabled = true)
	public void checKBoxButtonTest() throws InterruptedException {
		cbpage.checkBoxes(cm);
	}

	@Test(priority = 2, enabled = true)
	public void checkBox1WithoutSelectTest() {
		cbpage.checkBoxes(cm);
		cbpage.checkBox1WithoutSelect(cm);

	}

	@Test(priority = 3, enabled = true)
	public void checkBox2WithSelectTest() {
		cbpage.checkBoxes(cm);
		cbpage.checkBox1WithoutSelect(cm);
		cbpage.checkBox2WithSelect(cm);

	}

	@Test(priority = 4, enabled = true)
	public void checkBox1WithSelectTest() {
		cbpage.checkBoxes(cm);
		cbpage.checkBox1WithoutSelect(cm);
		cbpage.checkBox2WithSelect(cm);
		cbpage.checkBox1WithSelect(cm);
	}

	@Test(priority = 5, enabled = true)
	public void checkBox2WithoutSelectTest() {
		cbpage.checkBoxes(cm);
		cbpage.checkBox1WithoutSelect(cm);
		cbpage.checkBox2WithSelect(cm);
		cbpage.checkBox1WithSelect(cm);
		cbpage.checkBox2WithoutSelect(cm);
	}
}

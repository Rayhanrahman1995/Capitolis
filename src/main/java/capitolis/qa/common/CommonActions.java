package capitolis.qa.common;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import capitolis.qa.base.BaseClass;
import capitolis.qa.reports.LoggerClass;

public class CommonActions {

	public void clickMethod(WebElement element) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.click();
			LoggerClass.log(element + " clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " Element Not Found");
			Assert.fail();
		}
	}

	public String getText(WebElement element, String expected) {
		try {
			BaseClass.waits.waitUntilVisible(element);
			LoggerClass.log("Actual value : " + element.getText() + " >>><<< Expected value : " + expected);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " Element Not Found");
			return element + " : Element Not Found";
		}
	}

	public void writeText(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.sendKeys(value);
			LoggerClass.log(element + " Text Value entered : " + value);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " Element Not Found");
			Assert.fail();
		}
	}

	public void selectDropDown(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilSelectable(element);
			Select select = new Select(element);
			select.selectByValue(value);
			LoggerClass.log(value + " : has been selected for element, " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " Element Not Found");
			Assert.fail();
		}
	}

	public boolean isChecked(WebElement element) {
		boolean flag = false;
		try {
			if (element.isSelected()) {
				flag = true;
				LoggerClass.log(element + " : Element is selected");
			} else {
				LoggerClass.log(element + " : Element is not selected");
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " : Element not selected");
			Assert.fail();
		}
		return flag;
	}

	public boolean isSelectedAfterClick(WebElement element) {
		boolean flag = false;
		try {
			element.click();
			LoggerClass.log(element + " clicked");
			if (element.isSelected()) {
				flag = true;
				LoggerClass.log(element + " : Element is selected");
			} else {
				LoggerClass.log(element + " : Element is not selected");
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " : Element is not selected");
			Assert.fail();
		}
		return flag;
	}

	public String getPageTitle(WebDriver driver, String expected) {
		String title = null;
		try {
			title = driver.getTitle();
			LoggerClass.log("Actual value : " + title + " >>><<< Expected value : " + expected);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return title;
	}

	public void clearContent(WebElement element) {
		try {
			BaseClass.waits.waitUntilSelectable(element);
			element.clear();
			LoggerClass.log(element + " : Element is present");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " : Element is not present");
			Assert.fail();
		}
	}

	public void hoverOver(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			LoggerClass.log(element + " : Element is present");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(element + " : Element is not present");
			Assert.fail();
		}
	}

	public boolean isPresent(By locator) {
		boolean flag = false;
		try {
			List<WebElement> list = BaseClass.driver.findElements(locator);
			if (list.size() > 0) {
				flag = true;
				LoggerClass.log(locator + " : Element is present");
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(locator + " : Element is not present");
		}
		return flag;
	}

	public boolean isPresent(List<WebElement> locator) {
		boolean flag = false;
		try {
			List<WebElement> list = locator;
			if (list.size() > 0) {
				flag = true;
				LoggerClass.log(locator + " : Element is present");
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(locator + " : Element is not present");
		}
		return flag;
	}

	public boolean chekAttribute(WebElement element, String attr) {
		try {
			if (element.getAttribute(attr) != null) {
				LoggerClass.log(attr + ",Arrtibute Present in " + element);
				return true;
			} else {
				LoggerClass.log(attr + ",Arrtibute Not Present in " + element);
				return false;
			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.log(attr + ",Arrtibute Not Present in " + element);
			return false;
		}
	}

	public void scrollDown() {
		try {
			BaseClass.jsExecutor.executeScript("scroll(0,250);");
			LoggerClass.log("Scrolling down to 0 to 250 pixels");
		} catch (JavascriptException e) {
			LoggerClass.log("Exception while scrolling down");
		}
	}

	public void scrollUp() {
		try {
			BaseClass.jsExecutor.executeScript("scroll(0, -250);");
			LoggerClass.log("Scrolling up to 250 to 0 pixels");
		} catch (JavascriptException e) {
			LoggerClass.log("Exception while scrolling up");
		}
	}

	public void scrollIntoViewTheElement(WebElement element) {
		try {
			BaseClass.jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			LoggerClass.log("Scrolling into element : " + element + ", Succeed");
		} catch (JavascriptException e) {
			e.printStackTrace();
			LoggerClass.log("Scrolling into element : " + element + ", Failed");
			Assert.fail();
		}
	}

	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
			LoggerClass.log("Thread is sleeping zZz...");
		} catch (InterruptedException e) {
			e.printStackTrace();
			LoggerClass.log("Sleeping interuppted...");
		}
	}

}

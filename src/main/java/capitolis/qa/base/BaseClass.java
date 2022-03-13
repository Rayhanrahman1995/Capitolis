package capitolis.qa.base;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import capitolis.qa.common.CommonActions;
import capitolis.qa.common.CommonWaits;
import capitolis.qa.pages.BasicAuthPage;
import capitolis.qa.pages.CheckBoxesPage;
import capitolis.qa.pages.DynamicControlsPage;
import capitolis.qa.pages.FramesPage;
import capitolis.qa.pages.JQueryUIMenusPages;
import capitolis.qa.reports.Java_Logger;
import capitolis.qa.reports.LoggerClass;
import capitolis.qa.utilities.ConfigProperty;
import capitolis.qa.utilities.ExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static CommonWaits waits;
	public static CommonActions cm;
	public static JavascriptExecutor jsExecutor;
	public static CheckBoxesPage cbpage;
	public static BasicAuthPage bapage;
	public static FramesPage fpage;
	public static DynamicControlsPage dcp;
	public static JQueryUIMenusPages jqum;
	public static ExcelFile eF;
	public ConfigProperty configProperty;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {
		String os = System.getProperty("os.name");
		Java_Logger.getLog("My OS version is " + os);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ei")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari") && os.contains("Mac")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		LoggerClass.log("Broswer is launching>>>>>>");
		driver.manage().window().maximize();
		initializaton();
		driver.get(configProperty.getUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configProperty.getPageLoadWait()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configProperty.getElementImplicitWait()));
		wait = new WebDriverWait(driver, Duration.ofSeconds(configProperty.getExplicitWait()));
	}

	@AfterMethod
	public void quttingBrowser() {
		driver.quit();
		LoggerClass.log("Broswer is openening>>>>>>");
	}

	private void initializaton() {
		waits = new CommonWaits();
		cm = new CommonActions();
		jsExecutor = (JavascriptExecutor) driver;
		cbpage = new CheckBoxesPage(driver);
		bapage = new BasicAuthPage(driver);
		fpage = new FramesPage(driver);
		dcp = new DynamicControlsPage(driver);
		jqum = new JQueryUIMenusPages(driver);
		eF = new ExcelFile();
		configProperty=ConfigProperty.getInstance();
	}
}
package capitolis.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import capitolis.qa.reports.LoggerClass;

public class ConfigProperty {

	static ConfigProperty configProperty;
	private String path = "./configProperty/config.properties";
	private Properties properties;
	private String url;
	private int elementImplicitWait;
	private int pageloadWait;
	private int explicitWait;
	private int sheetNum;

	private ConfigProperty() {
	}

	public static ConfigProperty getInstance() {
		if (configProperty == null) {
			configProperty = new ConfigProperty();
		}
		configProperty.loadProperties();
		return configProperty;
	}

	private void loadProperties() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(fileInputStream);
			url = properties.getProperty("url");
			try {
				explicitWait = Integer.parseInt(properties.getProperty("explicitWait"));
				pageloadWait = Integer.parseInt(properties.getProperty("pageloadWait"));
				elementImplicitWait = Integer.parseInt(properties.getProperty("elementImplicitWait"));
				sheetNum = Integer.parseInt(properties.getProperty("sheetNum"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				LoggerClass.log("Check your config file @ " + new File(path).getAbsolutePath());
				Assert.fail();
			}
		} catch (IOException e) {
			e.printStackTrace();
			LoggerClass.log("File Not Found");
		}
	}

	public String getUrl() {
		return url;
	}

	public int getExplicitWait() {
		return explicitWait;
	}

	public int getPageLoadWait() {
		return pageloadWait;
	}

	public int getElementImplicitWait() {
		return elementImplicitWait;
	}

	public int getSheetNum() {
		return sheetNum;
	}

}

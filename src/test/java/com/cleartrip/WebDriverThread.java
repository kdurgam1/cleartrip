package com.cleartrip;

import static com.cleartrip.config.DriverType.FIREFOX;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cleartrip.config.DriverType;

public class WebDriverThread {

	private WebDriver webdriver;

	private final String browser = System.getProperty("browser").toUpperCase();
	private final String browserBit = System.getProperty("browserbit").toUpperCase();
	private final String browserVersion = System.getProperty("browserversion").toUpperCase();

	private final String sysOS = System.getProperty("os.name").toUpperCase();
	private final String sysArch = System.getProperty("os.arch").toUpperCase();

	private final DriverType defaultDriveType = FIREFOX;
	private DriverType selectedDriverType;

	public void setDriverBinary() {
		selectedDriverType = determineSelectedDriverType();
		selectedDriverType.setDriverBinaryPath(browserBit, browserVersion);
	}

	public WebDriver getDriver() {
		if (webdriver == null) {
			selectedDriverType = determineSelectedDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);

		}

		return webdriver;
	}

	public void quitDriver() {
		if (webdriver != null) {
			webdriver.quit();
			webdriver = null;
		}
	}

	private DriverType determineSelectedDriverType() {
		DriverType driverType = defaultDriveType;
		try {
			driverType = DriverType.valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println(" Unknown driver specified, defaulting to '" + driverType + "'...");

		} catch (NullPointerException ignored) {
			System.err.println(" No driver specified,defaulting to '" + driverType + "'...");

		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		System.out.println(" ");
		System.out.println(" Current Operating System: " + sysOS);
		System.out.println(" Current Architecture: " + sysArch);
		System.out.println(" Current Browser Selection: " + selectedDriverType);
		System.out.println(" ");
		webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

}

package com.cleartrip.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum DriverType implements DriverSetup {

	FIREFOX {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
			return desiredCapabilities;

		}

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new FirefoxDriver(desiredCapabilities);

		}

		public void setDriverBinaryPath(String browserBit, String browserVersion) {
			System.out.println(browserBit);
			System.out.println(browserVersion);
			System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\gecko_"
					+ browserVersion + "_" + browserBit + "\\geckodriver.exe");
			try {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\gecko_" + browserVersion
								+ "_" + browserBit + "\\geckodriver.exe");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	},

	CHROME {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability(" chrome.switches", Arrays.asList("--no-default-browser-check"));
			HashMap<String, String> chromePreferences = new HashMap<String, String>();
			chromePreferences.put(" profile.password_manager_enabled", "false");
			desiredCapabilities.setCapability(" chrome.prefs", chromePreferences);
			return desiredCapabilities;

		}

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new ChromeDriver(desiredCapabilities);

		}

		public void setDriverBinaryPath(String browserBit, String browserVersion) {
			System.out.println(browserBit);
			System.out.println(browserVersion);
			System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chrome_"
					+ browserVersion + "_" + browserBit + "\\chromedriver.exe");
			try {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chrome_" + browserVersion
								+ "_" + browserBit + "\\chromedriver.exe");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	},

	IE {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			desiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			desiredCapabilities.setCapability(" requireWindowFocus", true);
			return desiredCapabilities;

		}

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new InternetExplorerDriver(desiredCapabilities);

		}

		public void setDriverBinaryPath(String browserBit, String browserVersion) {
			System.out.println(browserBit);
			System.out.println(browserVersion);
			System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\ie_" + browserVersion
					+ "_" + browserBit + "\\IEDriverServer.exe");
			try {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\ie_" + browserVersion + "_"
								+ browserBit + "\\IEDriverServer.exe");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	},
	PHANTOMJS {
		public DesiredCapabilities getDesiredCapabilities() {
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
			final List<String> cliArguments = new ArrayList<String>();
			cliArguments.add("--web-security = false");
			cliArguments.add("--ssl-protocol = any");
			cliArguments.add("--ignore-ssl-errors = true");
			desiredCapabilities.setCapability(" phantomjs.cli.args", cliArguments);
			desiredCapabilities.setCapability(" takesScreenshot", true);
			return desiredCapabilities;

		}

		public WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities) {
			return new PhantomJSDriver(desiredCapabilities);

		}

		public void setDriverBinaryPath(String browserBit, String browserVersion) {
			System.out.println(browserBit);
			System.out.println(browserVersion);
			System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\phantomjs_" + browserVersion
					+ "_" + browserBit + "\\phantomjs.exe");
			try {

				System.setProperty("phantomjs.binary.path",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\phantomjs_" + browserVersion + "_"
								+ browserBit + "\\phantomjs.exe");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	};

}

package com.cleartrip.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTestWD1 {

	private void googleExampleThatSearchesFor(final String searchString) throws Exception {

		WebDriver driver;

		System.setProperty("webdriver.ie.driver",
				"F:\\seleniumprojects\\cleartrip\\src\\test\\resources\\drivers\\ie_2.53.1_32"
						+ "\\IEDriverServer.exe");

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		desiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		desiredCapabilities.setCapability(" requireWindowFocus", true);

		

		

		driver = new InternetExplorerDriver(desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		Thread.sleep(100);
		WebElement searchFiled = driver.findElement(By.name("q"));
		searchFiled.clear();
		searchFiled.sendKeys(searchString);
		System.out.println("page tile is " + driver.getTitle());
		searchFiled.submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driverObject) {
				// TODO Auto-generated method stub
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});

		System.out.println("page tile is " + driver.getTitle());

		driver.quit();

	}

	@Test
	public void googleCheeseExample() throws Exception {
		googleExampleThatSearchesFor("Cheese");
	}

}

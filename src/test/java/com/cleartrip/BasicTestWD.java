package com.cleartrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory {

	private void googleExampleThatSearchesFor(final String searchString) throws Exception {

		WebDriver driver;

		driver = DriverFactory.getDriver();

		driver.get("http://www.google.com");
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

	}

	@Test
	public void googleCheeseExample() throws Exception {
		googleExampleThatSearchesFor("Cheese");
	}

	@Test
	public void googleMilkExample() throws Exception {
		googleExampleThatSearchesFor("Milk");
	}

	@Test
	public void googleCurdExample() throws Exception {
		googleExampleThatSearchesFor("Curd");
	}

	@Test
	public void googleDrinkExample() throws Exception {
		googleExampleThatSearchesFor("Drink");
	}

	@Test
	public void googleSandExample() throws Exception {
		googleExampleThatSearchesFor("Sand");
	}

	@Test
	public void googleCheeseExample1() throws Exception {
		googleExampleThatSearchesFor("Cheese1");
	}

	@Test
	public void googleMilkExample1() throws Exception {
		googleExampleThatSearchesFor("Milk1");
	}

	@Test
	public void googleCurdExample1() throws Exception {
		googleExampleThatSearchesFor("Curd1");
	}

	@Test
	public void googleDrinkExample1() throws Exception {
		googleExampleThatSearchesFor("Drink1");
	}

	@Test
	public void googleSandExample1() throws Exception {
		googleExampleThatSearchesFor("Sand1");
	}

}

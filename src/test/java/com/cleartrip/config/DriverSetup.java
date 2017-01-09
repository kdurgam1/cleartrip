package com.cleartrip.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {

	DesiredCapabilities getDesiredCapabilities();

	WebDriver getWebDriverObject(DesiredCapabilities desiredCapabilities);

	void setDriverBinaryPath(String browserBit, String browserVersion);

}

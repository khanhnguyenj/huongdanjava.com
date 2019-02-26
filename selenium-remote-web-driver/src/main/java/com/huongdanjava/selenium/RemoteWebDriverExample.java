package com.huongdanjava.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverExample {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities =  DesiredCapabilities.chrome();

		WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capabilities);

		webDriver.get("https://huongdanjava.com/");
	}

}

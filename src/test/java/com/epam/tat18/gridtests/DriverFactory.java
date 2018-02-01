package com.epam.tat18.gridtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactory {

	private WebDriver wd;
	private static final String HUB_URL = "http://epbyminw2700:4444/wd/hub";
//	public String browser;
//	public String platform;

//	public DriverFactory(String browser, String platform) {
//		super();
//		this.browser = browser;
//		this.platform = platform;
//	}

	public  WebDriver getRemoteWebdriver(String browser, String platform) {
		if (wd == null) {
			wd = selectRemoteDriver(browser, platform);
		}
		return wd;
	}

	public WebDriver selectRemoteDriver(String browser, String platform) {
		switch (browser) {
		case "firefox":
			try {
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.setCapability(platform, Platform.fromString(platform));
				wd = new RemoteWebDriver(new URL(HUB_URL), ffOptions);
			} catch (UnreachableBrowserException | MalformedURLException e) {
				System.out.println("Server/hub is unavaliable, please try later");
			}
			break;
		case "chrome":
			try {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(platform, Platform.fromString(platform));
				wd = new RemoteWebDriver(new URL(HUB_URL), chromeOptions);
			} catch (UnreachableBrowserException | MalformedURLException e) {
				System.out.println("Server/hub is unavaliable, please try later");
			}
			break;
		default:
			throw new IllegalArgumentException("Selected browser is unavaliable");
		}
		return wd;
	}

}

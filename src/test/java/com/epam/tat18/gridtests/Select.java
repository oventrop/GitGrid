package com.epam.tat18.gridtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Select {

	private static WebDriver wd;
	private static Platform p;

	DesiredCapabilities caps;
	LoggingPreferences logs;

	public WebDriver chooseLocalBrowser(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/_DATA/geckodriver.exe");
			wd = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/_DATA/chromedriver.exe");
			wd = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "C:/_DATA/chromedriver.exe");
			wd = new ChromeDriver();
			break;
		}
		return wd;
	}

	public WebDriver chooseRemoteBrowser(String browser, String platform) throws MalformedURLException {
		final URL HUB_URL = new URL("http://epbyminw2700:4444/wd/hub");
		switch (browser) {
		case "firefox":
			caps = new DesiredCapabilities();
			caps.setBrowserName("firefox");
			caps.setPlatform(choosePlatform(platform));
			wd = new RemoteWebDriver(HUB_URL, caps);
			break;
		case "chrome":
			caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(choosePlatform(platform));
			wd = new RemoteWebDriver(HUB_URL, caps);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "C:/_DATA/chromedriver.exe");
			wd = new ChromeDriver();
			break;
		}
		return wd;
	}

	private Platform choosePlatform(String platform) {
		switch (platform) {
		case "windows":
			p = Platform.WINDOWS;
			break;
		case "linux":
			p = Platform.LINUX;
			break;
		default:
			p = Platform.WINDOWS;
			;
			break;
		}
		return p;
	}

}

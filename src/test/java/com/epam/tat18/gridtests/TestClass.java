package com.epam.tat18.gridtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.tat18.pageobjects.GitLoginPage;
import com.epam.tat18.pageobjects.GitMainPage;
import com.epam.tat18.pageobjects.GitRepositoryPage;

public class TestClass {

	/**
	 * Before executing test class you must run SeleniumGrid hub and at
	 * least one node with Chrome and FF browsers connected
	 */

	private final static String URL = "http:/github.com";
	private final static String LOGIN_EMAIL = "d.galievsky@gmail.com";
	private final static String LOGIN_PASSWORD = "master1";
	private static WebDriver wd;
	public Logger logger = LogManager.getLogger(TestClass.class);

	@Parameters({ "browser", "platform" })
	@BeforeClass
	public void startTest(String browser, String platform) {

		/**
		 * Getting instance of Remote WebDriver from factory with @params from
		 * testng.xml and opening target URL
		 */

		wd = new DriverFactory().getRemoteWebdriver(browser, platform);
		logger.info("Driver created!");
		wd.get(URL);
		wd.manage().window().maximize();
		logger.info(wd.getCurrentUrl(), wd);
	}

	@Test
	public void openGitHub() {
		/**
		 * Test runs through pages and asserts that the last page loaded correctly
		 */
		new GitMainPage(wd).pressSignInButton();
		new GitLoginPage(wd).enterCredentials(LOGIN_EMAIL, LOGIN_PASSWORD);
		new GitRepositoryPage(wd).openDropdownMenu().logoutFromRepository();
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("The world's leading software development platform · GitHub"));

	}

	@AfterClass(description = "Close browser")
	public void closeBrowser() {
		/**
		 * Method close browser and terminate WebDriver instance
		 */
		wd.quit();
	}

}

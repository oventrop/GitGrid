package com.epam.tat18.gridtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.tat18.pageobjects.GitLoginPage;
import com.epam.tat18.pageobjects.GitMainPage;
import com.epam.tat18.pageobjects.GitRepositoryPage;

public class TestClass {

	private final static String LOGIN_EMAIL = "d.galievsky@gmail.com";
	private final static String LOGIN_PASSWORD = "master1";
	private static WebDriver wd;
	public Logger logger = LogManager.getLogger(TestClass.class);

	@Parameters({ "browser", "platform" })
	@BeforeClass
	public void startTest(String browser, String platform) {
		
		wd = new DriverFactory(browser, platform).getRemoteDriver();
		logger.info("Driver created!");
	}

	@Test
	public void openGitHub() {

		wd.get("http:/github.com");
		logger.info(wd.getCurrentUrl(), wd );
		wd.manage().window().maximize();
		new GitMainPage(wd).pressSignInButton();
		GitLoginPage loginPage = new GitLoginPage(wd);
		loginPage.enterLogin(LOGIN_EMAIL);
		loginPage.enterPassword(LOGIN_PASSWORD);
		new GitRepositoryPage(wd).openDropdownMenu().logoutFromRepository();
		}

	@AfterClass(description = "Close browser")
	public void closeBrowser() {
		wd.quit();
	}

}

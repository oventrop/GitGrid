package com.epam.tat18.gridtests;

import java.net.MalformedURLException;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
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

	@Parameters({ "browser", "platform" })
	@BeforeClass
	public void startTest(String browser, String platform) throws MalformedURLException {
	//	wd = new Select().chooseRemoteBrowser(browser, platform);

		 wd = new Select().chooseLocalBrowser(browser);
	}

	@Test
	public void openGitHub() {
		wd.get("https://github.com/");
		wd.manage().window().maximize();
		GitMainPage mainPage = new GitMainPage(wd);
		mainPage.pressSignInButton();
		GitLoginPage loginPage = new GitLoginPage(wd);
		loginPage.enterLoginPassword(LOGIN_EMAIL, LOGIN_PASSWORD);
		GitRepositoryPage repoPage = new GitRepositoryPage(wd);
		repoPage.openDropdownMenu();
		repoPage.logoutFromRepository();
	}

	public boolean isElementPresent(By by) {
		return wd.findElement(by).isDisplayed();
	}

	@AfterClass(description = "Close browser")
	public void closeBrowser() {
		wd.quit();
	}

}

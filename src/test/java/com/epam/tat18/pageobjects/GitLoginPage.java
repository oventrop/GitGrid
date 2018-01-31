package com.epam.tat18.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitLoginPage extends AbstractPage {

	public GitLoginPage(WebDriver wd) {
		super(wd);
	}

	private static final String LOGIN_FIELD = "login_field";
	private static final String PASSWORD_FIELD = "password";

	@FindBy(id = LOGIN_FIELD)
	private WebElement loginField;

	@FindBy(id = PASSWORD_FIELD)
	private WebElement passwordField;

	@FindBy(xpath = "//*[@name = 'commit']")
	private WebElement submitButton;

	// *[@id="login"]/form/div[4]/input[3]

	public GitRepositoryPage enterLogin(String login) {

		waitForElementVisibility(loginField);
		
		loginField.click();
		loginField.clear();
		loginField.sendKeys(login);
		return new GitRepositoryPage(driver);
	}

	public GitRepositoryPage enterPassword(String password) {
		waitForElementVisibility(passwordField);
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(password);

		submitButton.click();

		return new GitRepositoryPage(driver);

	}
	
	
}

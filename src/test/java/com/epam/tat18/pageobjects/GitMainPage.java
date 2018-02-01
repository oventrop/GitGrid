package com.epam.tat18.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitMainPage extends AbstractPage {

	public GitMainPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[text()='Sign in']")
	private WebElement signInButton;

	public GitLoginPage pressSignInButton() {
		waitForElementVisibility(signInButton);
		signInButton.click();
		return new GitLoginPage(driver);

	}
}

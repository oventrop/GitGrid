package com.epam.tat18.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitRepositoryPage extends AbstractPage {

	public GitRepositoryPage(WebDriver wd) {
		super(wd);
	}

	@FindBy(xpath = "//*[text()='New repository']")
	WebElement newRepositoryButton;

	@FindBy(xpath = "//*[@class = \"avatar float-left mr-1\"]")
	WebElement dropdownMenu;
	
	@FindBy(xpath = "//*[@class = \"dropdown-item dropdown-signout\"][1]")
	WebElement logoutButton;
	

	public GitRepositoryPage openDropdownMenu() {

		waitForElementVisibility(dropdownMenu);
		dropdownMenu.click();
		return new GitRepositoryPage(driver);
	}
	
	public GitMainPage logoutFromRepository () {
		waitForElementVisibility(logoutButton);
		logoutButton.click();
		return new GitMainPage(driver);
	}

}

package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummary {

	public AccountSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Changes done according to version 20.1
	@FindBy(linkText="Transfer Funds")
	private WebElement tranferFunds;
	
	public void clickTransferFundsLink()
	{
		tranferFunds.click();
	}
	
}

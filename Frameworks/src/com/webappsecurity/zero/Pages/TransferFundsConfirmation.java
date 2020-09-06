package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {

	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement sucessMsg;
	
	public String getMsg() {
	String getmessage=	sucessMsg.getText();
	return getmessage;
	}
	
	
}

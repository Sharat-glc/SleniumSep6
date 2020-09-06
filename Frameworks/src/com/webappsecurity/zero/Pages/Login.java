package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_login")
	private WebElement uName;
	
	@FindBy(id= "user_password")
	private WebElement uPass;
	
	@FindBy(name = "submit")
	private WebElement uSignin;
	
	
	public void applicationLogin(String loginName, String loginPassword) {
		uName.sendKeys(loginName);
		uPass.sendKeys(loginPassword);
		uSignin.click();
	}
	
	
}

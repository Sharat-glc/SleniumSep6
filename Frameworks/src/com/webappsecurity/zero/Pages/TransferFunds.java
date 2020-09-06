package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {

	
	public TransferFunds(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="tf_fromAccountId")
		private WebElement fromAccount;
		
		@FindBy(id="tf_toAccountId")
		private WebElement toAccount;
		
		@FindBy(id="tf_amount")
		private WebElement tfAmount;
		
		@FindBy(id="tf_description")
		private WebElement tfDesc;
		
		@FindBy(id="btn_submit")
		private WebElement continueBtn;
		
		public void enterFundTransferDetails(String amount, String description) {
			
			Select fromActDD= new Select(fromAccount);
			fromActDD.selectByIndex(2);
			
			Select toAcctDD= new Select(toAccount);
			toAcctDD.selectByIndex(3);
			
			tfAmount.sendKeys(amount);
			tfDesc.sendKeys(description);
			continueBtn.click();
			
		}
		
		
	}


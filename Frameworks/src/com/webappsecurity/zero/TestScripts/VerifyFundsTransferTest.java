package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsConfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundsTransferTest {

	WebDriver driver;

	@BeforeClass
	public void OpenApplication() {
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void verifyFundsTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary ass = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);

		String[][] data = GenericMethods.getData("E:\\TestData\\TestData.xlsx", "Sheet1");
		for (int i = 1; i < data.length; i++) {

			lp.applicationLogin(data[i][0], data[i][1]);
			ass.clickTransferFundsLink();
			tf.enterFundTransferDetails(data[i][2], data[i][3]);
			tfv.clickSubmit();
			String actualMsg = tfc.getMsg();
			Assert.assertEquals(actualMsg, data[i][4]);
			driver.close();
			driver.get("http://zero.webappsecurity.com/login.html");
		}

	}

}

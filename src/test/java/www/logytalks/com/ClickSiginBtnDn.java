package www.logytalks.com;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.ExtentManager;
import Base.Hooks;
import pageObjects.HomePage;

@Listeners(resources.Listeners.class)
public class ClickSiginBtnDn extends Hooks {

	public ClickSiginBtnDn() throws IOException {
		super();
	}

	@Test
	public void clickRegistrationbtnDn() throws IOException {

		ExtentManager.log("Starting clickRegistrationbtnDn");

		HomePage home = new HomePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(home.getpopOutClose()));

		home.getpopOutClose().click();
		home.getsignUpBtnDown().click();

		String expectedUrl = "https://logytalks-live.itechnolabs.tech/register";
		try {
			AssertJUnit.assertEquals(expectedUrl, driver.getCurrentUrl());
			ExtentManager.pass("Reached Signin page");
		} catch (Exception e) {
			ExtentManager.fail(e.toString());
		}

	}

}

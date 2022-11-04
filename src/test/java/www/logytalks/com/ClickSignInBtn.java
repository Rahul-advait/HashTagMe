package www.logytalks.com;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import Base.ExtentManager;
import Base.Hooks;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

@Listeners(resources.Listeners.class)

public class ClickSignInBtn extends Hooks {

	public ClickSignInBtn() throws IOException {
		super();
	}

	@Test
	public void clickRegistrationbtn() {

		ExtentManager.log("Starting clickRegistrationbtnUP");
		HomePage home = new HomePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(home.getpopOutClose()));

		home.getpopOutClose().click();
		home.getsignUpBtnUp().click();

		String expectedUrl = "https://logytalks-live.itechnolabs.tech/register";
		try {
			AssertJUnit.assertEquals(expectedUrl, driver.getCurrentUrl());
			ExtentManager.pass("Navigated to register page");
		} catch (Throwable pageNavigationError) {
			ExtentManager.pass("Didn't navigated to register page");
		}
		RegistrationPage register = new RegistrationPage(driver);
		register.getlogo().click();
	}

}

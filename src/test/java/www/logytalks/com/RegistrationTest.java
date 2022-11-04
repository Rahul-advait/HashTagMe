package www.logytalks.com;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BasePage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BasePage {
	SoftAssert softassert = new SoftAssert();

	public RegistrationTest() throws IOException {
		super();
	}

	@AfterClass
	public void softAssertResult() {
		softassert.assertAll();
	}

	@BeforeMethod
	public void navigateToRegisterPage() throws IOException {
		driver = getDriver();
		driver.get(getUrl());

		HomePage home = new HomePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(home.getpopOutClose()));

		home.getpopOutClose().click();
		home.getsignUpBtnUp().click();

		String expectedUrl = "https://logytalks-live.itechnolabs.tech/register";
		try {
			Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			System.out.println("Navigated to correct webpage");
		} catch (Throwable pageNavigationError) {
			System.out.println("Didn't navigate to correct webpage");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(dataProvider = "getData")
	public void registration(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) {

		RegistrationPage register = new RegistrationPage(driver);

		register.getinputFirstName().sendKeys(first_name);
		register.getinputLastName().sendKeys(last_name);
		register.getinputEmail().sendKeys(email);
		register.getinputPassword().sendKeys(password);
		register.getinputConfPassword().sendKeys(CoPassword);
		register.getfieldOfInterest().click();
		register.getinputFieldOfInterest().sendKeys(foi);
		List<WebElement> fieldsOfInterests = register.getlistFieldOfInterest();

		for (WebElement FieldOfInterest : fieldsOfInterests) {
			if (FieldOfInterest.getText().contains("Testing")) {
				FieldOfInterest.click();
				break;
			}
		}

		register.gettermsBtn().click();
		register.getregisterSubmitBtn().click();

		String expectedUrl = "https://logytalks-live.itechnolabs.tech/email/verify";

		try {
			softassert.assertEquals(expectedUrl, driver.getCurrentUrl());
			System.out.println("Navigated to correct webpage");
		} catch (Exception e) {
			System.out.println("Didn't navigate to correct webpage");
		}

	}

}

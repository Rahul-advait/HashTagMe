package www.logytalks.com;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BasePage;
import Base.ExtentManager;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

@Listeners(resources.Listeners.class)
public class RegistrationTest extends BasePage {
	SoftAssert softassert = new SoftAssert();

	public RegistrationTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void navigateToRegisterPage() throws IOException {
		driver = getDriver();
		driver.get(getUrl());

		HomePage home = new HomePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		wait.until(ExpectedConditions.elementToBeClickable(home.getpopOutClose()));

		home.getpopOutClose().click();
		home.getsignUpBtnUp().click();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		driver = null;

	}

	@RowNumber
	@Test(dataProvider = "getData")
	public void registration(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) {

		ExtentManager.log("Starting Login Test");
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
		ExtentManager.log("Entered details");
		register.getregisterSubmitBtn().click();
		String expectedUrl = "https://logytalks-live.itechnolabs.tech/email/verify";
		if (!matchUrl(expectedUrl, driver.getCurrentUrl())) {
			Assert.fail();
		}

	}

}

package www.logytalks.com;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.ExtentManager;
import Base.Hooks;
import pageObjects.HomePage;
import pageObjects.SignInPage;

@Listeners(resources.Listeners.class)
public class LoginTest extends Hooks {
	public LoginTest() throws IOException {
		super();
	}

	@RowNumber
	@Test(dataProvider = "getData")
	public void loginCheck(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) {

		ExtentManager.log("Starting Login Test");

		HomePage home = new HomePage(driver);
		home.getloginBtn().click();

		SignInPage signin = new SignInPage(driver);

		signin.getemailInput().sendKeys(email);
		signin.getpasswordInput().sendKeys(password);

		signin.getsubmitLoginBtn().click();
		String expectedUrl = "https://logytalks-live.itechnolabs.tech/upcoming-conferences";
		if (!matchUrl(expectedUrl, driver.getCurrentUrl())) {
			Assert.fail();
		}
	}

}

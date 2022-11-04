package www.logytalks.com;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class LoginTest extends BasePage {
	public LoginTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void navigateToRegisterPage() throws IOException {
		driver = getDriver();
		driver.get(getUrl());

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}

	@Test(dataProvider = "getData")
	public void loginCheck(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) {
		HomePage home = new HomePage(driver);
		home.getloginBtn().click();

		SignInPage signin = new SignInPage(driver);

		signin.getemailInput().sendKeys(email);
		signin.getpasswordInput().sendKeys(password);

		signin.getsubmitLoginBtn().click();

	}

}

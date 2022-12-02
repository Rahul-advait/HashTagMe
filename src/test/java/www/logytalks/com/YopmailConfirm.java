package www.logytalks.com;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BasePage;
import Base.ExtentManager;
import pageObjects.SignInPage;

@Listeners(resources.Listeners.class)

public class YopmailConfirm extends BasePage {

	public YopmailConfirm() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		driver = getDriver();
		driver.get("https://yopmail.com/en/");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("after method");
		driver.close();
		driver.quit();
	}

	@Test(dataProvider = "getData")
	public void emailConfirm(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) {

		ExtentManager.log("Starting Yopmail confirmation test");

		driver.findElement(By.cssSelector("#login")).sendKeys(email);

		driver.findElement(By.cssSelector("button")).click();

		ExtentManager.pass("Reached inbox of " + email);
		driver.switchTo().frame("ifmail");

		driver.findElement(By.linkText("Verify Email Address")).click();

		ExtentManager.pass("Clicked on verify link ");
		driver.switchTo().parentFrame();

		ArrayList<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(windowsHandles.get(1));

		SignInPage signin = new SignInPage(driver);

		ExtentManager.log("Reached signup page");
		signin.getemailInput().sendKeys(email);
		signin.getpasswordInput().sendKeys(password);
		signin.getsubmitLoginBtn().click();

		Assert.fail();
	}
}

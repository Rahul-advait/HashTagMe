package www.logytalks.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;

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
		driver.close();
		driver.quit();
	}

	@Test
	public void emailConfirm() {

		driver.findElement(By.cssSelector("#login")).sendKeys("rahulsingh103@yopmail.com");

		driver.findElement(By.cssSelector("button")).click();

		try {
			driver.switchTo().frame("1");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		try {
			driver.findElement(By.linkText("Verify Email Address")).click();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;

	By emailInput = By.cssSelector("input#email");
	By passwordInput = By.cssSelector("input#password");
	By forgotPasswordLink = By.linkText("Forgot Password?");
	By submitLoginBtn = By.cssSelector(".update-profile-btn1");
	By dontHaveAcntLink = By.linkText("You don't have an account? Sign up");
	By rememberBtn = By.cssSelector(".checkmark");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getemailInput() {
		return driver.findElement(emailInput);
	}

	public WebElement getpasswordInput() {
		return driver.findElement(passwordInput);
	}

	public WebElement getforgotPasswordLink() {
		return driver.findElement(forgotPasswordLink);
	}

	public WebElement getsubmitLoginBtn() {
		return driver.findElement(submitLoginBtn);
	}

	public WebElement getdontHaveAcntLink() {
		return driver.findElement(dontHaveAcntLink);
	}

	public WebElement getrememberBtn() {
		return driver.findElement(rememberBtn);
	}

}

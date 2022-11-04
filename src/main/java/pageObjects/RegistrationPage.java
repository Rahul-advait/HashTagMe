package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	public WebDriver driver;

	By inputFirstName = By.cssSelector("input#name");
	By inputLastName = By.cssSelector("[name='last_name']");
	By inputEmail = By.cssSelector("input#email");
	By inputPassword = By.cssSelector("input#password");
	By inputConfPassword = By.cssSelector("[name='password_confirmation']");
	By fieldOfInterest = By.cssSelector(".select2-selection__rendered");
	By inputFieldOfInterest = By.cssSelector("[type='search']");
	By listFieldOfInterest = By.cssSelector(".select2-results ul>li");
	By termsBtn = By.name("terms");
	By registerSubmitBtn = By.cssSelector("[data-select2-id='7'] button");
	By alreadyMemberBtn = By.cssSelector(".term-condition-a > b");
	By referralInput = By.cssSelector("input[name='referral_code']");
	By logo = By.cssSelector("[alt='virtual conference platorm']");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getinputFirstName() {
		return driver.findElement(inputFirstName);
	}

	public WebElement getinputLastName() {
		return driver.findElement(inputLastName);
	}

	public WebElement getinputEmail() {
		return driver.findElement(inputEmail);
	}

	public WebElement getinputPassword() {
		return driver.findElement(inputPassword);
	}

	public WebElement getinputConfPassword() {
		return driver.findElement(inputConfPassword);
	}

	public WebElement getfieldOfInterest() {
		return driver.findElement(fieldOfInterest);
	}

	public WebElement getinputFieldOfInterest() {
		return driver.findElement(inputFieldOfInterest);
	}

	public List<WebElement> getlistFieldOfInterest() {
		return driver.findElements(listFieldOfInterest);
	}

	public WebElement gettermsBtn() {
		return driver.findElement(termsBtn);
	}

	public WebElement getregisterSubmitBtn() {
		return driver.findElement(registerSubmitBtn);
	}

	public WebElement getalreadyMemberBtn() {
		return driver.findElement(alreadyMemberBtn);
	}

	public WebElement getreferralInput() {
		return driver.findElement(referralInput);
	}
	
	public WebElement getlogo() {
		return driver.findElement(logo);
	}

}

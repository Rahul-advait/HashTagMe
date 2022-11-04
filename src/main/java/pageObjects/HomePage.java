
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	By popOutClose = By.xpath("//div[@id='modal-subscribe']/div[@role='document']//button[@type='button']");
	By popOutInputName = By.cssSelector("#name-subscriber");
	By popOutInputEmail = By.cssSelector("#email-subscriber");
	By popOutInputCategory = By.cssSelector("#email-subscriber");
	By popOutSubmitbtn = By.cssSelector("#subscriber-form button");
	By signUpBtnUp = By.linkText("SIGN UP FOR FREE");
	By loginBtn = By.linkText("LOGIN");
	By signUpBtnDown = By.linkText("Join For Free");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getpopOutClose() {
		return driver.findElement(popOutClose);
	}

	public WebElement getpopOutInputName() {
		return driver.findElement(popOutInputName);
	}

	public WebElement getpopOutInputEmail() {
		return driver.findElement(popOutInputEmail);
	}

	public WebElement getpopOutInputCategory() {
		return driver.findElement(popOutInputCategory);
	}

	public WebElement getpopOutSubmitbtn() {
		return driver.findElement(popOutSubmitbtn);
	}

	public WebElement getsignUpBtnUp() {
		return driver.findElement(signUpBtnUp);
	}

	public WebElement getloginBtn() {
		return driver.findElement(loginBtn);
	}

	public WebElement getsignUpBtnDown() {
		return driver.findElement(signUpBtnDown);
	}

}

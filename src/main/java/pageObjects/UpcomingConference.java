package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpcomingConference {
	public WebDriver driver;

	By createConferenceBtn = By.linkText("Create Conference");

	public UpcomingConference(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCreateConferenceBtn() {
		return driver.findElement(createConferenceBtn);
	}

}

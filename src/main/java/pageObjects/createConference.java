package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createConference {

	public WebDriver driver;

	By popUpClosebtn = By.cssSelector(".introjs-tooltip-header [role]");
	By conferenceTitle = By.cssSelector("input[name='title']");
	By conferenceAuthor = By.cssSelector("input[name='author']");
	By dateField = By.cssSelector("input[name='date']");
	By dates = By.xpath("//tbody/tr/td");
	By logo = By.cssSelector("img[alt='logo']");
	By startTime = By.cssSelector("input[name='time']");
	By endTime = By.cssSelector("input[name='end_time']");
	
	public createConference(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getConferenceTitle() {
		return driver.findElement(conferenceTitle);
	}

	public WebElement getConferenceAuthor() {
		return driver.findElement(conferenceTitle);
	}

	public WebElement getDateField() {
		return driver.findElement(dateField);
	}

	public List<WebElement> getDates() {
		return driver.findElements(dates);
	}

	public WebElement getpopup() {
		return driver.findElement(popUpClosebtn);
	}
	public WebElement getLogo() {
		return driver.findElement(logo);
	}

	public WebElement getStartTime() {
		return driver.findElement(startTime);
	}
	
	public WebElement getEndTime() {
		return driver.findElement(endTime);
	}
}

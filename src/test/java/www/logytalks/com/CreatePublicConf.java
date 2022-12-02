package www.logytalks.com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.ExtentManager;
import Base.Hooks;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.UpcomingConference;
import pageObjects.createConference;

@Listeners(resources.Listeners.class)
public class CreatePublicConf extends Hooks {

	public CreatePublicConf() throws IOException {
		super();
	}

	@RowNumber(rowNumber = "2")
	@Test(dataProvider = "getData")
	public void publicConference(String email, String password, String CoPassword, String first_name, String last_name,
			String foi) throws InterruptedException {

		ExtentManager.log("Starting Create Conference Test");

		// Login
		HomePage home = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(home.getpopOutClose()));

		home.getpopOutClose().click();
		home.getloginBtn().click();

		SignInPage signin = new SignInPage(driver);

		signin.getemailInput().sendKeys(email);
		signin.getpasswordInput().sendKeys(password);

		signin.getsubmitLoginBtn().click();
		ExtentManager.pass("User logged in ");

		// Create conference
		UpcomingConference upcomingConf = new UpcomingConference(driver);
		upcomingConf.getCreateConferenceBtn().click();

		createConference publicConference = new createConference(driver);

		ExtentManager.log("Creating conference");

		wait.until(ExpectedConditions.elementToBeClickable(publicConference.getpopup()));

		publicConference.getpopup().click();
		String conferenceTitle = getTitleByProp();

		publicConference.getConferenceTitle().sendKeys(conferenceTitle);
		publicConference.getConferenceAuthor().sendKeys(first_name + " " + last_name);
		publicConference.getDateField().click();

		List<WebElement> days = publicConference.getDates();
		for (WebElement day : days) {
			if (day.getText().contains(today())) {
				day.click();
				break;
			}
		}

		publicConference.getStartTime().sendKeys(currentTime());
	}

}

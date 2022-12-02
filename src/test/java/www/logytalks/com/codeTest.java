package www.logytalks.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class codeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://logytalks-live.itechnolabs.tech/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#modal-subscribe .close")));

		driver.findElement(By.cssSelector("div#modal-subscribe .close")).click();

		// Login
		driver.findElement(By.linkText("LOGIN")).click();

		driver.findElement(By.cssSelector("input#email")).sendKeys("PriyankaBisht@yopmail.com");

		driver.findElement(By.cssSelector("input#password")).sendKeys("test@123");

		driver.findElement(By.cssSelector(".update-profile-btn1")).click();

		driver.findElement(By.linkText("Create Conference")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".introjs-tooltip-header [role]")));

		driver.findElement(By.cssSelector(".introjs-tooltip-header [role]")).click();
	}

}

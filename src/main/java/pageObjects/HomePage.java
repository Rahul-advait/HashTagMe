package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class HomePage {
    private static String screenShotDestinationPath;
    public WebDriver driver;
    private String SEARCH_BOX = ".css-qbdosj-Input";
    private String ALL_STOCKS = "//div[@id='react-select-5-listbox']/div/div";
    private String LOGO = "[alt='logo']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    private void takeSnapShot(int count) throws IOException {
        File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

        String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + count + ".png";
        screenShotDestinationPath = destFile;

        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isLogoPresent() {
        try {
            WebElement logo = driver.findElement(By.cssSelector("[alt='logo']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void waitMethod(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    private void waitMethod(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void clickSearchBox() {
        WebElement searchBox = driver.findElement(By.cssSelector(SEARCH_BOX));
        waitMethod(searchBox);
        searchBox.click();
    }

    private WebElement getStock(int i) {
        List<WebElement> stocks = driver.findElements(By.xpath(ALL_STOCKS));
        waitMethod(stocks);

        WebElement stock = stocks.get(i);
        waitMethod(stock);
        return stock;
    }

    private WebElement clickSearchBoxAndGetStock(int i) {
        clickSearchBox();
        return getStock(i);
    }

    private void clickStock(int i) {
        clickSearchBoxAndGetStock(i).click();
    }

    public void clickAllStock() throws IOException {
        int count = 0;

        for (int i = 86; i < 252; i++) {
            System.out.print(i + ", ");
            try {
                clickStock(i);
                takeSnapShot(count);
            } catch (Exception e) {
                if (isLogoPresent()) {
                    clickStock(i);
                    takeSnapShot(count);
                } else {
                    count++;
                    driver.navigate().refresh();
                    System.out.println(clickSearchBoxAndGetStock(i - 1).getText());
                    getStock(i).click();
                }
            }
        }
    }

}

package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class BasePage {

	public static WebDriver driver;
	private String url;
	private String title;
	private Properties prop;
	public static String screenShotDestinationPath;

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(data);
	}

	public WebDriver getDriver() throws IOException {

		if (driver == null) {

			if (prop.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");

				driver = new ChromeDriver();

			} else if (prop.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\geckodriver.exe");

				driver = new FirefoxDriver();
			} else {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\msedgedriver.exe");

				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		}
		return driver;
	}

	public String getUrl() throws IOException {

		url = prop.getProperty("url");

		return url;
	}

	public String takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png";
		screenShotDestinationPath = destFile;

		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return name;

	}

	public static String getScreenshotDestinationPath() {
		return screenShotDestinationPath;
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public String today() {
		return new SimpleDateFormat("d").format(new Date());
	}
	
	public String currentTime() {
		return new SimpleDateFormat("HH-mm").format(new Date());
	}

	public boolean matchUrl(String expectedUrl, String currentUrl) {
		if (expectedUrl.equals(currentUrl)) {
			ExtentManager.pass("Reached correct url");
			return true;
		} else {
			ExtentManager.fail("Reached incorrect url");
			return false;
		}

	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface RowNumber {
		String rowNumber() default "";
	}

	@DataProvider
	public Object[][] getData(Method method) throws IOException {

		RowNumber rows = method.getAnnotation(RowNumber.class);
		Object[][] data = new Object[3][6];
		FileInputStream workbookLocation = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\credentials.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = row.getCell(j).toString();
			}
		}
		if (rows.rowNumber().equals("")) {
			return data;
		}
		int whichRow = Integer.parseInt(rows.rowNumber());
		return new Object[][] { data[whichRow - 1] };

	}
	
	public String getTitleByProp() {
		title = prop.getProperty("publictitle");
		return title;
	}
}

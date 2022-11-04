package Base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BasePage {

	public static ExtentReports extentReports;
	public static String extentReportsPrefix;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public ExtentManager() throws IOException {
		super();
	}

	public static ExtentReports getReport() {
		if (extentReports == null) {
			setupReport("Live Project 1");
		}
		return extentReports;

	}

	private static ExtentReports setupReport(String testName) {

		extentReports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//report//" + extentReportsPrefix_Name(testName) + ".html");
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("Tester", "My Name");
		spark.config().setReportName("Regression test");
		spark.config().setDocumentTitle("Test Results");
		spark.config().setTheme(Theme.DARK);
		return extentReports;

	}

	private static String extentReportsPrefix_Name(String testName) {
		String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		extentReportsPrefix = testName + "_" + date;
		return extentReportsPrefix;
	}

	public static void flushReport() {
		extentReports.flush();
	}

	public synchronized static void log(String message) {
		getTest().info(message);
	}

	public synchronized static void pass(String message) {
		getTest().pass(message);
	}

	public synchronized static void fail(String message) {
		getTest().fail(message);
	}

	public synchronized static ExtentTest getTest() {
		return extentTest.get();
	}

	public synchronized static ExtentTest createTest(String name) {
		ExtentTest test = extentReports.createTest(name);
		extentTest.set(test);
		return getTest();
	}

	public synchronized static void attachImage() {
		getTest().addScreenCaptureFromPath(getScreenshotDestinationPath());
	}

}

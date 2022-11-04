package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BasePage;
import Base.ExtentManager;

public class Listeners extends BasePage implements ITestListener {

	public Listeners() throws IOException {
		super();
	}

	public void onStart(ITestContext context) {
		ExtentManager.getReport();
		ExtentManager.createTest(context.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		ExtentManager.getTest().fail(result.getThrowable());
		try {
			System.out.println("Test Failed" + result.getName());
			takeSnapShot(result.getMethod().getMethodName());
			ExtentManager.attachImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		ExtentManager.flushReport();
	}
}

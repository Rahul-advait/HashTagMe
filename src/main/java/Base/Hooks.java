package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class Hooks extends BasePage {

	public Hooks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		driver = null;
	}

}

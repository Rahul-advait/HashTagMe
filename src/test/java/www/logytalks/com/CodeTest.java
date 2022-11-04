package www.logytalks.com;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;


public class CodeTest extends BasePage {

	public CodeTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void navigateToRegisterPage() throws IOException {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("After Method");
	}

	@DataProvider
	public Object[][] getData() throws IOException {

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

		return data;

	}

	@Test(dataProvider = "getData")
	public void registration(String email, String password, String coPassword, String first_name, String last_name,
			String foi) {

		System.out.println(email);
		System.out.println(password);
		System.out.println(coPassword);
		System.out.println(first_name);
		System.out.println(last_name);
		System.out.println(foi);

	}

}

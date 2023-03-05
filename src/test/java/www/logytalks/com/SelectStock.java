package www.logytalks.com;

import Base.ExtentManager;
import Base.Hooks;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;

@Listeners(resources.Listeners.class)
public class SelectStock extends Hooks {

    public SelectStock() throws IOException {
        super();
    }

    @Test
    public void checkAllStocks() throws IOException {

        ExtentManager.log("Start selecting");

        HomePage home = new HomePage(driver);

        home.clickAllStock();


    }

    /*
     * String expectedUrl = "https://logytalks-live.itechnolabs.tech/register"; try
     * { AssertJUnit.assertEquals(expectedUrl, driver.getCurrentUrl());
     * ExtentManager.pass("Reached Signin page"); } catch (Exception e) {
     * ExtentManager.fail(e.toString()); }
     */


}


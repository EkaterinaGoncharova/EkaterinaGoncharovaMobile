package scenarios.webTests;

import io.restassured.RestAssured;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenarios.Hooks;
import setup.PropertyFile;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    public static final String TITLE = "Internet Assigned Numbers Authority";

    protected SimpleWebTests() {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        Assert.assertEquals(RestAssured.get(SUT).statusCode(), 200);
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        Assert.assertEquals(driver().getTitle(), TITLE);
        Assert.assertTrue(driver().getCurrentUrl().contains(SUT));
        System.out.println("Site opening done");
    }
}
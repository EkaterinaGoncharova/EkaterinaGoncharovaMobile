package scenarios.webTests;

import io.restassured.RestAssured;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenarios.Hooks;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        Assert.assertEquals(driver().getTitle(), TITLE);
        Assert.assertTrue(driver().getCurrentUrl().contains(SUT));
        Assert.assertEquals(RestAssured.get(SUT).statusCode(), 200);
        System.out.println("Site opening done");
    }
}
package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareAndroidNative();
        //prepareAndroidWeb();
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest() {
        By add_btn = By.id("com.example.android.contactmanager:id/addContactButton");
        //By add_btn = By.className("android.widget.Button");
        //By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    //@Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}

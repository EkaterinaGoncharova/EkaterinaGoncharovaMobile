package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.net.URL;

/**
 * Initialize a driver with test properties
 */
@Parameters({"appPackage", "appActivity", "platform", "driver", "devicename", "sut", "title", "udid"})
public class Driver extends TestProperties {
    private AppiumDriver driverSingle = null;
    protected DesiredCapabilities capabilities;
    private WebDriverWait waitSingle;

    // Properties to be read
    protected String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    protected String TEST_PLATFORM;
    protected String DRIVER;
    protected String DEVICE_NAME;
    protected String TITLE;
    protected String UDID;
    protected String APP_PACKAGE;
    protected String APP_ACTIVITY;


    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("devicename");
        TITLE = getProp("title");
        UDID = getProp("udid");
        APP_PACKAGE = getProp("appPackage");
        APP_ACTIVITY = getProp("appActivity");

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);

        // Setup type of application: nativeTests, webTests (or hybrid)
        if (APP_PACKAGE != null && APP_ACTIVITY != null && SUT == null) {
            // Native
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        } else if (SUT != null && APP_PACKAGE == null && APP_ACTIVITY == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}



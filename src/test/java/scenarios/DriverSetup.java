package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidNative() throws MalformedURLException {// exception required by java.net.URL

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory capabilities
        //capabilities.setCapability("device","Android");
        capabilities.setCapability("deviceName", "LGD6181c1c4692");
        capabilities.setCapability("platformName", "Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
        // e.g. "resources" folder of the project
        File appDir = new File("C:\\projects\\MyFirstTrainingAppiumTest\\src\\main\\resources");
        File app = new File(appDir, "ContactManager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    /**
     * Set of capabilities to test Android web app
     *
     * @throws MalformedURLException
     */
    protected void prepareAndroidWeb() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName", "LGD6181c1c4692");
        capabilities.setCapability("platformName", "Android");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserName", "Browser");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}


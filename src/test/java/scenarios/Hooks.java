package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.Driver;
import setup.PropertyFile;


@Test(groups = {"native", "web"})
public class Hooks extends Driver {

    @Parameters("currentProps")
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp(String currentProps) throws Exception {
        setPropertyFile(PropertyFile.toPropertyFile(currentProps));
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}

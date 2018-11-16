package scenarios.nativeTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenarios.Hooks;
import setup.PropertyFile;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        //Check that Contact Name field is displayed
        By contactName = By.id(app_package_name + "contactNameEditText");
        Assert.assertTrue(driver().findElement(contactName).isDisplayed());

        //Check that for Contact Phone field is displayed
        By contactPhone = By.id(app_package_name + "contactPhoneEditText");
        Assert.assertTrue(driver().findElement(contactPhone).isDisplayed());

        //Check Contact Name title
        By contactNameTitle = By.id("Contact Name");
        Assert.assertEquals(driver().findElement(contactNameTitle).getText(), "Contact Name");

        //Check Contact Phone title
        By contactPhoneTitle = By.id("Contact Phone");
        Assert.assertEquals(driver().findElement(contactPhoneTitle).getText(), "Contact Phone");

        System.out.println("Simplest Appium test done");
    }
}

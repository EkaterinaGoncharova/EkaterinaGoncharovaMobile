HW#3

1. "Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?"

Using "singleton" allows to guarantee the uniqueness of an object. This will force
the user to use the same object for all instances where the WebDriver is required.

2. "Suggest improvements for .properties reading. What are the purposes?"

We create a field in Hooks.java which will contain value of PropertyFile enum:

```
private PropertyFile currentProps;
```

and initialize it in setUp() method:

```
setPropertyFile(currentProps);
```

and we should add a parameter to Hooks constructor and pass value relevant for test:

```
protected SimpleNativeTests() throws Exception {
    super(PropertyFile.NATIVE);
}
protected SimpleWebTests() throws Exception {
    super(PropertyFile.WEB);
}
```

3. "Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test"

```
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
```

5. "Which checks would you place in the “web” test?"

I checked site title, URL and http response status code

6. "Implement checks for “web” test in code and try to use."

```
Assert.assertEquals(driver().getTitle(), TITLE);
Assert.assertTrue(driver().getCurrentUrl().contains(SUT));
Assert.assertEquals(RestAssured.get(SUT).statusCode(), 200);
```

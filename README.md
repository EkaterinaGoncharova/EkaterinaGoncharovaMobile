HW#4

1. "Add support of appPackage and appActivity parameters for Android devices
(reading from a .properties file and then setting in the DesiredCapabilities).
Locally installed Appium DT has no need in these parameters, but for Appium
server of Minsk Mobile Farm it’s mandatory.
a. Or try to use autoLaunch capability with app as before. Does this approach work?"

```
appPackage=com.example.android.contactmanager
appActivity=com.example.android.contactmanager.ContactManager
...
capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
```
APP capability doesn't work. Application has to be installed before test manually
or via Farm API.

2. "Change settings to run web test on a certain iOS device on Mobile Test Farm.
Run test with your changes. Did test pass?"

```
udid=25ad632db73b1de523be6565f395cae349b4dd13
...
capabilities.setCapability(MobileCapabilityType.UDID, UDID);
```
Test passed succesfully.

3. "Change settings to run native test on a certain/random Android device on Mobile
 Test Farm. Run test with your changes. Did test pass?"

```
devicename=LGE Nexus 5
```



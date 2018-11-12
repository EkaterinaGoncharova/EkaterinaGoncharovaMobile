1. "Setup project that has been discussed in the class.
Make sure you can run both tests (native and web) successfully."

Done.


2. "For existing native mobile autotest try to use another locator (xpath, classname, ?).
Define these locators using Appium Inspector. Are there any difference with id version?"

I found three ways to find locators: by id, classname and xpath.
1) For id we should use By.id method and parameter is id:
By add_btn = By.id("com.example.android.contactmanager:id/addContactButton");

2) For classname we should use By.classname method and parameter is a name of a class:
By add_btn = By.className("android.widget.Button");

3) For xpath we should use By.xpath method and parameter is xpath:
By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");


3. "Modify existing tests to run on a real device. What should be changed?"

We should change 'deviceName' capability to serial number of your device.
capabilities.setCapability("deviceName", "LGD6181c1c4692");
You can find it via 'adb devices' command.

4. "Connect a real device to Appium (describe required actions) and run tests.
Are there any difference with run on emulator?"

To use real device you should connect it via USB or Wi-Fi and turn on developer mode
and USB debugging

5. "What should be improved/changed in existing test code? Why, for what?"

1) thread.sleep() shouldn't be use in production code;
2) DriverSetup shouldn't be in test package;
3) System.out.println is used instead of logger;
4) comment/uncomment is used to change test mode from 'native' to 'web'
or to change a type of locator
5) values are hardcoded on test, they should be moved from test to another file;
6) used absolute path;
7) code dublicated in DriverSetup class;
8) assertions should be used, test cannot be a test without assertions.


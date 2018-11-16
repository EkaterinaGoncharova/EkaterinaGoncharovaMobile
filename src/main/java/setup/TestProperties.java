package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties {
    Properties currentProps = new Properties();
    String currentPropFile;

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream("./src/" + currentPropFile);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected void setPropertyFile(PropertyFile propertyFile) {
        currentPropFile = propertyFile.getFileName();
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);

    }
}
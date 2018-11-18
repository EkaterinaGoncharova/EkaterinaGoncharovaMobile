package setup;

public enum PropertyFile {

    NATIVE_ANDROID("mobile_farm_native_android_tests"),
    WEB_ANDROID("mobile_farm_web_android_tests"),
    WEB_IOS("mobile_farm_web_ios_tests");

    private String currentProps;

    PropertyFile(String crtPrp) {
        this.currentProps = crtPrp;
    }

    public static PropertyFile toPropertyFile(String userStr) {
        for (PropertyFile file : PropertyFile.values()) {
            if (file.currentProps.equals(userStr)) {
                return file;
            }
        }
        throw new IllegalArgumentException("File was not found");
    }

    public String getFileName() {
        return currentProps + ".properties";
    }
}

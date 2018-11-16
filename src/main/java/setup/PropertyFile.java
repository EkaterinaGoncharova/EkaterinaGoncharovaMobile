package setup;

public enum PropertyFile {

    NATIVE("nativetests"),
    WEB("webtests");

    private String currentProps;

    PropertyFile(String crtPrp) {
        this.currentProps = crtPrp;
    }

    public String getFileName() {
        return currentProps + ".properties";
    }
}

package vn.codegym.model.bean;

public class EmailSetting {
    private String language;
    private int pageSize;
    private boolean enableSpamsFilter;
    private String signature;

    public EmailSetting() {
    }

    public EmailSetting(String language, int pageSize, boolean enableSpamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enableSpamsFilter = enableSpamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnableSpamsFilter() {
        return enableSpamsFilter;
    }

    public void setEnableSpamsFilter(boolean enableSpamsFilter) {
        this.enableSpamsFilter = enableSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

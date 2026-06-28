//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.opencellsoft.utils;

public class FileErrorInfo extends ErrorInfo {
    private String filename;

    public FileErrorInfo(String fn, ErrorInfo error) {
        super(error.getErrorCode(), error.getMessage());
        this.filename = fn;
    }

    public FileErrorInfo(String fn, int code, String msg) {
        super(code, msg);
        this.filename = fn;
    }

    public FileErrorInfo(String fn, String msg) {
        super(msg);
        this.filename = fn;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.filename).append(super.toString());
        return sb.toString();
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

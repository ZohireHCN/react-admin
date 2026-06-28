//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.opencellsoft.utils;

public class ErrorInfo {
    private int errorCode;
    private String message;

    public ErrorInfo(int code, String msg) {
        this.errorCode = code;
        this.message = msg;
    }

    public ErrorInfo(String msg) {
        this.errorCode = -1;
        this.message = msg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [").append(this.errorCode).append(":").append(this.message).append("]");
        return sb.toString();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.firefly.myapp.utils;

public class ResponseFormatter<T> {
    private boolean status;
    private String message;
    private T result;

    public ResponseFormatter() {
        this.status = true;
        this.message = "Success";
        this.result = null;
    }

    public ResponseFormatter(T result) {
        this.status = true;
        this.message = "Success";
        this.result = result;
    }

    public ResponseFormatter(boolean status, String message) {
        this.status = status;
        this.message = message;
        this.result = null;
    }

    public ResponseFormatter(boolean status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

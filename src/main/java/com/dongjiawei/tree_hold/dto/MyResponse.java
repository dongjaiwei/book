package com.dongjiawei.tree_hold.dto;


public class MyResponse<D> {
    int code;
    String message;
    D data;

    public MyResponse() {
    }

    public MyResponse(int code, String message, D data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public D getData() {
        return data;
    }



    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(D data) {
        this.data = data;
    }

}


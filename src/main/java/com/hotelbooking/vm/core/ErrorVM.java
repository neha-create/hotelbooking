package com.hotelbooking.vm.core;

import java.io.Serializable;

public class ErrorVM implements Serializable {

    private static final long serialVersionUID = -4441996416869690126L;

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("code - " + code);
        sb.append("message - " + message);

        return sb.toString();
    }

}

package com.hotelbooking.vm.core;

import java.io.Serializable;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDataVM implements Serializable {

    private static final long serialVersionUID = -1308725518620161628L;

    private String message;
    
    private JSONObject jsonResp;

    public BaseDataVM() {
        super();
    }

    public BaseDataVM(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public JSONObject getJsonResp() {
		return jsonResp;
	}

	public void setJsonResp(JSONObject jsonResp) {
		this.jsonResp = jsonResp;
	}
}

package com.hotelbooking.vm.core;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseErrorVM implements Serializable {

	private static final long serialVersionUID = -8101327695273217603L;

	private String code;

	private String message;

	private List<ErrorVM> errors;

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

	public List<ErrorVM> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVM> errors) {
		this.errors = errors;
	}

}

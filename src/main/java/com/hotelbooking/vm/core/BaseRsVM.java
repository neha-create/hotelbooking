package com.hotelbooking.vm.core;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRsVM extends BaseVM {

	private static final long serialVersionUID = 4334669267115607360L;

	private String status;

	private BaseErrorVM error;

	private BaseDataVM data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BaseErrorVM getError() {
		return error;
	}

	public void setError(BaseErrorVM error) {
		this.error = error;
	}

	public BaseDataVM getData() {
		return data;
	}

	public void setData(BaseDataVM data) {
		this.data = data;
	}

}

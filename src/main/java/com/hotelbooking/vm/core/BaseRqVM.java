package com.hotelbooking.vm.core;

public class BaseRqVM extends BaseVM {

	private static final long serialVersionUID = 85381423028274032L;

	private String appId;

	private String username;
	private String clienttype;
	
	public BaseRqVM() {
		super();
	}

	public BaseRqVM(String username) {
		super();
		this.username = username;
	}

	public BaseRqVM(String appId, String username) {
		super();
		this.appId = appId;
		this.username = username;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClienttype() {
		return clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

}

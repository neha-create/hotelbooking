package com.hotelbooking.vm.core;

public class HotelRqVM extends BaseRqVM {

	private static final long serialVersionUID = -6416146057275426598L;
	
	
	private String cityCode;
	
	private String checkInDate;
	
	private String checkOutDate;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	

}

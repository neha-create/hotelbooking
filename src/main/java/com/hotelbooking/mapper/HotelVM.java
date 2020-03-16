package com.hotelbooking.mapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hotelbooking.BO.Address;
import com.hotelbooking.BO.Contact;
import com.hotelbooking.BO.Price;
import com.hotelbooking.vm.core.BaseRqVM;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelVM extends BaseRqVM {

	private static final long serialVersionUID = 6733160892736813399L;

	private String hotelName;

	private List<String> lines;

	private String postalCode;

	private String cityName;

	private String countryCode;

	private String phone;

	private String currency;

	private String total;

	// private Address address;

	// private Contact contact;

	// private Price price;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}

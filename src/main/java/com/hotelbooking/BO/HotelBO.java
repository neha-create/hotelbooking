package com.hotelbooking.BO;

import org.json.JSONObject;

public class HotelBO {

	
	private String Hotelname;

	private String address;

	private String contactnumber;

	private String hotelrate;
	
	private String hoteldstance;
	
	private JSONObject json;

	public String getHotelname() {
		return Hotelname;
	}

	public void setHotelname(String hotelname) {
		Hotelname = hotelname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getHotelrate() {
		return hotelrate;
	}

	public void setHotelrate(String hotelrate) {
		this.hotelrate = hotelrate;
	}

	public String getHoteldstance() {
		return hoteldstance;
	}

	public void setHoteldstance(String hoteldstance) {
		this.hoteldstance = hoteldstance;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}
}

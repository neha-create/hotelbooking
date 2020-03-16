package com.hotelbooking.BO;

import java.util.List;

public class Hotel {
	private String type;

	private String hotelId;

	private String chainCode;

	private String dupeId;

	private String name;

	private String rating;

	private String cityCode;

	private double latitude;

	private double longitude;

	private HotelDistance hotelDistance;

	private Address address;

	private Contact contact;

	private Description description;

	private List<String> amenities;

	private List<Media> media;
	
	private String currency;
	
	private String price;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelId() {
		return this.hotelId;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	public String getChainCode() {
		return this.chainCode;
	}

	public void setDupeId(String dupeId) {
		this.dupeId = dupeId;
	}

	public String getDupeId() {
		return this.dupeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRating() {
		return this.rating;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setHotelDistance(HotelDistance hotelDistance) {
		this.hotelDistance = hotelDistance;
	}

	public HotelDistance getHotelDistance() {
		return this.hotelDistance;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Description getDescription() {
		return this.description;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	public List<String> getAmenities() {
		return this.amenities;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public List<Media> getMedia() {
		return this.media;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

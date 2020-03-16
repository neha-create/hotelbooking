package com.hotelbooking.mapper;

import java.util.Collections;
import java.util.List;

import com.hotelbooking.vm.core.BaseDataVM;

public class HotelDataVM extends BaseDataVM {

	private static final long serialVersionUID = -940475708641662829L;

	private List<HotelVM> hotels = Collections.<HotelVM>emptyList();

	public HotelDataVM() {
		super();
	}

	public List<HotelVM> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelVM> hotels) {
		this.hotels = hotels;
	}

}

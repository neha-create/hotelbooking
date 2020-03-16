package com.hotelbooking.service;

import com.hotelbooking.vm.core.BaseRsVM;
import com.hotelbooking.vm.core.HotelRqVM;

public interface HotelService {

	public BaseRsVM searchHotel(HotelRqVM rqVM);
	
}

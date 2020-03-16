package com.hotelbooking.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.service.HotelService;
import com.hotelbooking.util.HotelHeader;
import com.hotelbooking.vm.core.BaseRsVM;
import com.hotelbooking.vm.core.HotelRqVM;
import com.hotelbooking.vm.core.ResponseUtils;

@RestController
@RequestMapping(value = "/api")
public class HotelController {

	static Log logger = LogFactory.getLog(HotelController.class);

	@Autowired
	HotelService hotelService;

	//@GetMapping("/gethotel")
	@RequestMapping(value = "/gethotel", method = RequestMethod.GET)
	public BaseRsVM getHotelData(@RequestParam(value = "cityCode", defaultValue = "World") String cityCode,
			@RequestParam(value = "checkInDate", defaultValue = "2025-03-11") String checkInDate,
			@RequestParam(value = "checkOutDate", defaultValue = "2025-03-12") String checkOutDate,
			@RequestHeader(value = HotelHeader.AUTHORIZATION, required = true) String authorization) {

		System.out.println("City cide is " + cityCode);
		if (logger.isDebugEnabled()) {
			logger.debug("Executing getHotelData [POST /getHotelData]");
		}
		try {
			HotelRqVM rqVM = new HotelRqVM();
			rqVM.setCityCode(cityCode);
			rqVM.setCheckInDate(checkInDate);
			rqVM.setCheckOutDate(checkOutDate);
			System.out.println(cityCode + checkInDate + checkOutDate);
			return hotelService.searchHotel(rqVM);
		} catch (Exception e) {
			logger.error("Exception in getHotelData(getHotelData)" + e);
			return ResponseUtils.prepareFailureResponse(e);
		}
	}

}

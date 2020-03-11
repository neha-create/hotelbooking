package com.hotelbooking.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hotelbooking.util.ErrorCodes;
import com.hotelbooking.util.Utils;
import com.hotelbooking.vm.core.HotelRqVM;

public class HotelHelper {
	static Log logger = LogFactory.getLog(HotelHelper.class);

	public static List<String> validateHotelDetails(HotelRqVM rqVM) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing validateHotelDetails(HotelRqVM) ->");
		}

		List<String> errors = new ArrayList<String>();
		try {
			String hName = Utils.getValidString(rqVM.getCityCode());
			if (Utils.isEmpty(hName)) {
				logger.error(ErrorCodes.EC_REQUIRED_CITY_CODE);
				errors.add(ErrorCodes.EC_REQUIRED_CITY_CODE);
			}
			String chkDate = Utils.getValidString(rqVM.getCheckInDate());
			if (Utils.isEmpty(chkDate)) {
				logger.error(ErrorCodes.EC_REQUIRED_CHECK_IN_DATE);
				errors.add(ErrorCodes.EC_REQUIRED_CHECK_IN_DATE);
			}
			
			String chotDate = Utils.getValidString(rqVM.getCheckOutDate());
			if (Utils.isEmpty(chotDate)) {
				logger.error(ErrorCodes.EC_REQUIRED_CHECK_OUT_DATE);
				errors.add(ErrorCodes.EC_REQUIRED_CHECK_OUT_DATE);
			}
			
		} catch (Exception e) {
			logger.error("Exception in validateHotelDetails(HotelRqVM) - " + e);
			errors.add(ErrorCodes.EC_INVALID_INPUT);
		}
		return errors;
	}
}

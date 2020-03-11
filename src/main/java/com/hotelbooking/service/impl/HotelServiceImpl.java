package com.hotelbooking.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hotelbooking.helper.HotelHelper;
import com.hotelbooking.service.HotelService;
import com.hotelbooking.util.ErrorCodes;
import com.hotelbooking.util.GetAccessToken;
import com.hotelbooking.util.MessageBundles;
import com.hotelbooking.util.MessageCodes;
import com.hotelbooking.util.Utils;
import com.hotelbooking.vm.core.BaseDataVM;
import com.hotelbooking.vm.core.BaseRsVM;
import com.hotelbooking.vm.core.HotelRqVM;
import com.hotelbooking.vm.core.ResponseUtils;

@Service
public class HotelServiceImpl implements HotelService {

	static Log logger = LogFactory.getLog(HotelServiceImpl.class);

	@Override
	public BaseRsVM searchHotel(HotelRqVM rqVM) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing searchHotel(HotelRqVM) ->");
		}
		try {
			List<String> errors = HotelHelper.validateHotelDetails(rqVM);
			if (Utils.isNotEmpty(errors)) {
				logger.error(ErrorCodes.EC_INVALID_INPUT);
				return ResponseUtils.prepareFailureResponse(ErrorCodes.EC_INVALID_INPUT, errors);
			}
	
			String params = "cityCode=" + rqVM.getCityCode() + "&checkInDate=" + rqVM.getCheckInDate()
					+ "&checkOutDate=" + rqVM.getCheckOutDate();
			String hotelUrl = "https://test.api.amadeus.com/v2/shopping/hotel-offers?" + params;
		
			String accesstoken = GetAccessToken.getAccessToken();
			URL urls = new URL(hotelUrl);
			HttpURLConnection con = (HttpURLConnection) urls.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer " + accesstoken);
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(false);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject myresponse = new JSONObject(response.toString());
			
			String message = MessageBundles.getMessage(MessageCodes.MC_COMPLETED_SUCCESSFUL);
			BaseDataVM dataVM = new BaseDataVM();
			dataVM.setMessage(message+myresponse);
			return ResponseUtils.prepareSuccessResponse(dataVM);
		} catch (Exception e) {
			logger.error("Exception in searchHotel(HotelRqVM) - " + e);
			return ResponseUtils.prepareFailureResponse(e);
		}

	}
	
	
}

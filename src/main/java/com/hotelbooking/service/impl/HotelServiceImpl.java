package com.hotelbooking.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelbooking.BO.Offers;
import com.hotelbooking.BO.Price;
import com.hotelbooking.BO.Root;
import com.hotelbooking.mapper.HotelDataVM;
import com.hotelbooking.mapper.HotelRestTemplate;
import com.hotelbooking.mapper.HotelVM;
import com.hotelbooking.service.HotelService;
import com.hotelbooking.util.MessageBundles;
import com.hotelbooking.util.MessageCodes;
import com.hotelbooking.vm.core.BaseRsVM;
import com.hotelbooking.vm.core.HotelRqVM;
import com.hotelbooking.vm.core.ResponseUtils;

@Service
public class HotelServiceImpl implements HotelService {

	static Log logger = LogFactory.getLog(HotelServiceImpl.class);

	public BaseRsVM searchHotel(HotelRqVM rqVM) {
		if (logger.isDebugEnabled()) {
			logger.debug("Executing searchHotel(HotelRqVM) ->");
		}
		BaseRsVM rsVM = null;
		RestTemplate restTemplate = new RestTemplate();
		String accesstoken = HotelRestTemplate.getAccess();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + accesstoken);
		headers.set("Authorization", "Bearer " + accesstoken);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String params = "cityCode=" + rqVM.getCityCode() + "&checkInDate=" + rqVM.getCheckInDate() + "&checkOutDate="
				+ rqVM.getCheckOutDate();
		String hotelUrl = "https://test.api.amadeus.com/v2/shopping/hotel-offers?" + params;

		ResponseEntity<Root> responseEntity = restTemplate.exchange(hotelUrl, HttpMethod.GET, entity, Root.class);

		HotelDataVM dataVM = new HotelDataVM();
		List<HotelVM> dBOs = new ArrayList<HotelVM>();

		try {
			Root obj = responseEntity.getBody();
			if (null == obj) {
				dataVM.setMessage(MessageBundles.getMessage(MessageCodes.MC_NO_RECORDS_FOUND));
			} else {

				for (int i = 0; i < obj.getData().size(); i++) {
					HotelVM hotelVM = new HotelVM();
					Price price = new Price();
					List<Offers> offers = obj.getData().get(i).getOffers();
					for (int ii = 0; ii < offers.size(); ii++) {
						price.setCurrency(offers.get(ii).getPrice().getCurrency());
						price.setTotal(offers.get(ii).getPrice().getTotal());
					}
					hotelVM.setHotelName(obj.getData().get(i).getHotel().getName());
					hotelVM.setLines(obj.getData().get(i).getHotel().getAddress().getLines());
					hotelVM.setPostalCode(obj.getData().get(i).getHotel().getAddress().getPostalCode());
					hotelVM.setCityName(obj.getData().get(i).getHotel().getAddress().getCityName());
					hotelVM.setCityName(obj.getData().get(i).getHotel().getAddress().getCountryCode());
					hotelVM.setPhone(obj.getData().get(i).getHotel().getContact().getPhone());
					hotelVM.setCurrency(price.getCurrency());
					hotelVM.setTotal(price.getTotal());
					dBOs.add(hotelVM);
				}
				dataVM.setMessage(MessageBundles.getMessage(MessageCodes.MC_RETRIEVED_SUCCESSFUL));
				dataVM.setHotels(dBOs);

			}
			rsVM = ResponseUtils.prepareSuccessResponse(dataVM);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception in searchHotel(HotelRqVM) - " + e);
			return ResponseUtils.prepareFailureResponse(e);
		}

		return rsVM;

	}

}

package com.hotelbooking.mapper;

import java.util.Collections;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HotelRestTemplate {

	public static String getAccess() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://test.api.amadeus.com/v1/security/oauth2/token";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();

		bodyMap.add("grant_type", "client_credentials");
		bodyMap.add("client_id", "u9OMkDxwkRSnGnsuvAv0pVcAbi0e15aH");
		bodyMap.add("client_secret", "03CmGzjYbeOFqucU");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);
		String result = restTemplate.postForObject(url, requestEntity, String.class);
		JSONObject jsonResponse = new JSONObject(result);

		return jsonResponse.get("access_token").toString();
	}
}

package com.hotelbooking.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.hotelbooking.BO.HotelBO;
import com.hotelbooking.vm.core.HotelRqVM;

public class Test {
	public static void main(String[] args) throws Exception {

		String urlParameters = "grant_type=client_credentials&client_id=u9OMkDxwkRSnGnsuvAv0pVcAbi0e15aH&client_secret=03CmGzjYbeOFqucU";
//		// try {
//		//
//		// URL url = new
//		// URL("https://test.api.amadeus.com/v1/security/oauth2/token");//your url i.e
//		// fetch data from .
//		// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		// conn.setRequestMethod("POST");
//		// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		// if (conn.getResponseCode() != 200) {
//		// throw new RuntimeException("Failed : HTTP Error code : "
//		// + conn.getResponseCode());
//		// }
//		// InputStreamReader in = new InputStreamReader(conn.getInputStream());
//		// BufferedReader br = new BufferedReader(in);
//		// String output;
//		// while ((output = br.readLine()) != null) {
//		// System.out.println(output);
//		// }
//		// conn.disconnect();
//		//
//		// } catch (Exception e) {
//		// System.out.println("Exception in NetClientGet:- " + e);
//		// }
//
//		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//		int postDataLength = postData.length;
//		String request = "https://test.api.amadeus.com/v1/security/oauth2/token";
//		URL url = new URL(request);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setDoOutput(true);
//		conn.setInstanceFollowRedirects(false);
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		conn.setRequestProperty("charset", "utf-8");
//		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
//		conn.setUseCaches(false);
//		 //System.out.println("dsd"+conn.getHeaderField("access_token"));
//		 try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
//		 wr.write(postData);
//		 }
//		
//		 BufferedReader br = null;
//		 if (conn.getResponseCode() == 200) {
//		 br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		 String strCurrentLine;
//		 while ((strCurrentLine = br.readLine()) != null) {
//			// System.out.println(strCurrentLine.toString());
//			 if (strCurrentLine.toString().contains("access_token")) {
//				 Pattern p = Pattern.compile("\"([^\"]*)\"");
//				 Matcher m = p.matcher(strCurrentLine);
//				 while (m.find()) {
//				   System.out.println(m.group(1));
//				 }
//			}
//		 System.out.println(strCurrentLine);
//		 }
//		 } else {
//		 br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		 String strCurrentLine;
//		 while ((strCurrentLine = br.readLine()) != null) {
//		 System.out.println(strCurrentLine);
//		 }
//		 }
//		 
////		 BufferedReader in = new BufferedReader(
////	             new InputStreamReader(conn.getInputStream()));
////	     String inputLine;
////	     StringBuffer response = new StringBuffer();
////	     while ((inputLine = in.readLine()) != null) {
////	     	response.append(inputLine);
////	     }
////	     in.close();
////	     //print in String
////	     System.out.println(response.toString());
////		 JSONObject myResponse = new JSONObject("{ ch:"+br.toString()+"}");
////		 System.out.println(myResponse);
////		 JSONObject responseObject = myResponse.get("access_token");
////	     System.out.println("result after Reading JSON Response");
////	     System.out.println("statusCode- "+responseObject);
//	     String server = conn.getHeaderField("access_token");
//	     
//	     Map<String, List<String>> map = conn.getHeaderFields();
//	     for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//	         System.out.println("Key : " + entry.getKey() + 
//	                  " ,Value : " + entry.getValue());
//	     }
	     
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
	     String accesstoken= GetAccessToken.getAccessToken();
	     System.out.println("newly generate de--> "+accesstoken);
	     String hotelUrl = "https://test.api.amadeus.com/v2/shopping/hotel-offers?cityCode=PAR";
	     URL urls = new URL(hotelUrl);
	     HttpURLConnection con = (HttpURLConnection) urls.openConnection();
	     con.setRequestMethod("GET");
	     con.setRequestProperty("Authorization", "Bearer " + accesstoken);
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(false);
			con.setUseCaches(false);
			 
			 int responseCode = con.getResponseCode();
			System.out.println(con.getResponseCode());
			 BufferedReader br = null;
			 if (con.getResponseCode() == 200) {
			 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 String strCurrentLine;
			 while ((strCurrentLine = br.readLine()) != null) {
			 System.out.println(strCurrentLine);
			 }
			 } else {
				 System.out.println("no 200");
			 br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			 String strCurrentLine;
			 while ((strCurrentLine = br.readLine()) != null) {
			 System.out.println(strCurrentLine);
			 }
			 }
//		HotelRqVM rqVM = new HotelRqVM();
//		rqVM.setCityCode("PAR");
//		rqVM.setCityCode("2020-03-15");
//		rqVM.setCheckOutDate("2020-03-16");
//		String hotelUrl = "https://test.api.amadeus.com/v2/shopping/hotel-offers";
//		HttpClient client = new DefaultHttpClient();
//		HttpGet request = new HttpGet(hotelUrl);
//		  List nameValuePairs = new ArrayList(1);
//		  nameValuePairs.add(new BasicNameValuePair("cityCode", rqVM.getCityCode()));
//		  nameValuePairs.add(new BasicNameValuePair("checkInDate", rqVM.getCheckInDate()));
//		  nameValuePairs.add(new BasicNameValuePair("checkOutDate", rqVM.getCheckOutDate()));
//		  request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//		  HttpResponse response = client.execute(request);
//		  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//		  String line = "";
//		  while ((line = rd.readLine()) != null) {
//		   System.out.println(line);
//		  }
	}
}

package com.hotelbooking.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAccessToken {

	 public static String getAccessToken() throws IOException {
	//public static void main(String[] args) throws IOException {

		String urlParameters = "grant_type=client_credentials&client_id=u9OMkDxwkRSnGnsuvAv0pVcAbi0e15aH&client_secret=03CmGzjYbeOFqucU";
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		String request = "https://test.api.amadeus.com/v1/security/oauth2/token";
		URL url = new URL(request);
		String key ="";
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		conn.setUseCaches(false);
		 //System.out.println("dsd"+conn.getHeaderField("access_token"));
		 try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
		 wr.write(postData);
		 }
			BufferedReader br = null;
			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String strCurrentLine;
				while ((strCurrentLine = br.readLine()) != null) {
					// System.out.println(strCurrentLine.toString());
					if (strCurrentLine.toString().contains("access_token")) {
						Pattern p = Pattern.compile("\"([^\"]*)\"");
						Matcher matcher = p.matcher(strCurrentLine);
						while (matcher.find()) {
							System.out.println(matcher.group(1));
							key +=matcher.group(1);
						}
					}
				}
			}else {
				System.out.println("response not working");
			}

		return key.substring("access_token".length()).trim();

	}
}

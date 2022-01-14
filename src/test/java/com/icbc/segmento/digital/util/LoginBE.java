package com.icbc.segmento.digital.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class LoginBE {

	private static String user;
	private static String pass;
	private static String deviceId;
	private static Response resp;
	
	public LoginBE(String user, String pass, String deviceId) {
		LoginBE.user = user;
		LoginBE.pass = pass;
		LoginBE.deviceId = deviceId;
	}
	
	public Response getResponse() {

		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LOGIN)
				.setRelaxedHTTPSValidation()
				.build();
		
//		Map<String, String> headers = new HashMap<String, String>();
		
//		headers.put("Postman-Token", "<calculated when request is sent>");
////		headers.put("Content-Length", "0");
//		headers.put("Host", "<calculated when request is sent>");
//		headers.put("User-Agent", "PostmanRuntime/7.28.4");
//		headers.put("Accept", "*/*");
//		headers.put("Accept-Encoding", "gzip, deflate, br");
//		headers.put("Connection", "keep-alive");
				
		resp = 
				given().
				redirects().follow(false).
				relaxedHTTPSValidation().
				spec(requestSpec).
				contentType(ContentType.JSON).
				queryParam("klogonUserId", user).
				queryParam("klogonPass", pass).
				queryParam("kdeviceId", deviceId).
//				headers(headers).
			when().
				post().
			then().
				body("result", equalTo("ok")).
//				log().all().
				extract().
				response();
	
		return resp;
	}
	
	public HashMap<String, String> getLoginDataHashMap(String user, String pass, String deviceId) {
		
		HashMap<String, String> loginData = new HashMap<String, String>();
		
		loginData.put("user", user);
		loginData.put("pass", pass);
		loginData.put("deviceId", deviceId);
		
		return loginData;
	}
	
	public String getHzSessionId(String aJsonOutput) {
		JSONObject jsonObj = new JSONObject(aJsonOutput);
		return "dse_sessionId=" + jsonObj.getJSONObject("data").getString("hzSessionId");
	}
	
	public String getDocType(String aJsonOutput) {
		JSONObject jsonObj = new JSONObject(aJsonOutput);
		return jsonObj.getJSONObject("data").getString("docType");
	}
	
	public String getDocNum(String aJsonOutput) {
		JSONObject jsonObj = new JSONObject(aJsonOutput);
		return jsonObj.getJSONObject("data").getString("docNum");
	}
}

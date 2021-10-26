package com.icbc.segmento.digital.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
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
		
//		HashMap<String, String> loginData = getLoginDataHashMap(user, pass, deviceId);
		
		
		resp = 
				given().
				relaxedHTTPSValidation().
				spec(requestSpec).
				contentType(ContentType.JSON).
//				queryParams(loginData).
				queryParam("klogonUserId", user).
				queryParam("klogonPass", pass).
				queryParam("kdeviceId", deviceId).
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
		String hzSessionId = aJsonOutput.substring(aJsonOutput.length()-55, aJsonOutput.length()-3);
		return "dse_sessionId=" + hzSessionId;
	}
	
}

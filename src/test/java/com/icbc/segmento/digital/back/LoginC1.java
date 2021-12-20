package com.icbc.segmento.digital.back;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.ebanking.model.RequestHeader;
import com.icbc.segmento.digital.util.Link;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.ebanking.retail.model.ClientCredential;
import com.ebanking.retail.model.DeviceData;
import com.ebanking.retail.model.ChannelLoginSessionInput;
import com.ebanking.retail.model.RequestChannelLoginSessionInput;

public class LoginC1 {

	private static String transactionId = "869dda0d-99ed-4a9c-89c4-b00fbcc6a187";
	private static String channel = "mbr";
	private static String userName = "F26886516";
	private static String encodedPassword = "prueba01";
	private static String deviceId = "815875a7f37b77ed19121984";
	private static String browser = "Chrome";
	private static String deviceDescription = "Redmi Note 7";
	private static String language = "es_US";
	private static String ipAddress = "172.0.0.0";
	private static String screenResolution = "\n dpi: 352, \n height: 2157, \n width: 1080";
	private static String osType = "Android";
	private static String osVersion = "10";
	private static String nationalityCode = "080";
	private static String geolocation = "\n latitude: -34.6519203, \n longitude: -58.35838565 ";
	private static Response resp;

	public Response getResponse() {

		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri("https://mds-channel-security-authentication-5-0-dev.apps.ocp4-tst.intranet.local/channel-security-authentication/5.0/login")
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId)
				.channel(channel);
		
		ClientCredential clientCredential = new ClientCredential()
				.userName(userName)
				.encodedPassword(encodedPassword);
		
		DeviceData deviceData = new DeviceData()
				.deviceId(deviceId)
				.browser(browser)
				.deviceDescription(deviceDescription)
				.language(language)
				.ipAddress(ipAddress)
				.screenResolution(screenResolution)
				.osType(osType)
				.osVersion(osVersion)
				.nationalityCode(nationalityCode)
				.geolocation(geolocation);
		
		ChannelLoginSessionInput data = new ChannelLoginSessionInput()
				.clientCredential(clientCredential)
				.deviceData(deviceData);
		
		RequestChannelLoginSessionInput request = (RequestChannelLoginSessionInput) new RequestChannelLoginSessionInput()
				.data(data)
				.header(header);
	
		resp = 
				given().
				relaxedHTTPSValidation().
				spec(requestSpec).
				contentType(ContentType.JSON).
				body(request).
			when().
				post().
			then().
				log().all().
				extract().
				response();
		
		System.out.println("cookie:" + resp.getCookie("JSESSIONID"));
		return resp;
	}
	
	public String getCookie(Response response) {
		return "JSESSIONID=" + response.getCookie("JSESSIONID");
	}
}
package com.icbc.segmento.digital.back.step;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.GetClientDataInput;
import com.ebanking.retail.model.RequestChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.ebanking.retail.model.RequestGetClientDataInput;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.dependency.ListBlrTwelveStatementInput;
import com.icbc.segmento.digital.util.dependency.RequestListBlrTwelveStatementInput;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetEmailsMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("se prepara el metodo login con los datos {string} {string} {string}")
	public void sePreparaElMetodoLoginConLosDatos(String user, String pass, String deviceId) {
		System.out.println("----------------------------LOGIN");
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("llamo al metodo getClientData")
	public void llamoAlMetodoGetClientData() {
		System.out.println("----------------------------GETCLIENTDATA");
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEWGETCLIENTDATA)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();

		RequestHeader header = new RequestHeader();
		
		Request request = new Request()
				.header(header);
		
		String aux = "{\r\n" + 
				"\r\n" + 
				"    \"header\": {\r\n" + 
				"\r\n" + 
				"        \"caller\": {\r\n" + 
				"\r\n" + 
				"            \"system\": \"retail\",\r\n" + 
				"\r\n" + 
				"            \"name\": \"com.midd.test.service.ChannelClientService\",\r\n" + 
				"\r\n" + 
				"            \"operation\": \"getClientData\",\r\n" + 
				"\r\n" + 
				"            \"version\": \"1.0.5\",\r\n" + 
				"\r\n" + 
				"            \"ip\": \"10.11.12.13\",\r\n" + 
				"\r\n" + 
				"            \"port\": \"28080\",\r\n" + 
				"\r\n" + 
				"            \"layer\": \"service\",\r\n" + 
				"\r\n" + 
				"            \"index\": 2,\r\n" + 
				"\r\n" + 
				"            \"latency\": 247\r\n" + 
				"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"    \"channel\": \"mbr\",\r\n" + 
				"\r\n" + 
				"    \"groupId\": \"20000000001\",\r\n" + 
				"\r\n" + 
				"    \"password\": \"mbr2014\",\r\n" + 
				"\r\n" + 
				"    \"remoteHost\": \"10.11.12.13\",\r\n" + 
				"\r\n" + 
				"    \"serviceName\": \"getClientData\",\r\n" + 
				"\r\n" + 
				"    \"sessionId\": \"8a33ff49-64adce33-0164-add58e7b-9876\",\r\n" + 
				"\r\n" + 
				"    \"transactionId\": \"8a33ff49-64adce33-0164-add58e7b-0032\",\r\n" + 
				"\r\n" + 
				"    \"userId\": \"mbrusr\"\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"}";
		
		Response responseGetClientData =		
    			given().
    				spec(requestSpec).
    				header("Content-Type", "application/json").
    				header("Cookie", hzSessionId).
    				body(aux).
    			when().
    			log().all().
    				post().
    			then().
    				log().all().
    				extract().
    				response();	
		
		assertEquals("El status code es incorrecto " + responseGetClientData.getStatusCode() , 200, responseGetClientData.getStatusCode());
		
	}

	@When("llamo al metodo getEmailsMBR con {string}")
	public void llamoAlMetodoGetEmailsMBRCon(String transactionId) {
	    
		System.out.println("----------------------------GETEMAILS");
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GET_EMAILS_MBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		Request request = new Request()
				.header(header);
		
		String aux = "{\r\n" + 
				"\r\n" + 
				"    \"header\": {\r\n" + 
				"\r\n" + 
				"        \"transactionId\": \"5544ad82-98e4-496c-8fad-2a900bec2a72\"\r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"}";
		
		response =		
    			given().
    				spec(requestSpec).
    				header("Content-Type", "application/json").
    				header("Cookie", hzSessionId).
    				body(aux).
    			when().
    				log().all().
    				post().
    			then().
    				log().all().
    				extract().
    				response();	
		
	}

	@Then("se valida que el code sea el esperado de getEmailsMBR")
	public void seValidaQueElCodeSeaElEsperadoDeGetEmailsMBR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

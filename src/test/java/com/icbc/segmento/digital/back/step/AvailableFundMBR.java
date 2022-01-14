package com.icbc.segmento.digital.back.step;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelPaymentInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelPaymentInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class AvailableFundMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("se prepara el logueo con los datos {string} {string} {string} para availableFundMBR")
	public void sePreparaElLogueoConLosDatosParaAvailableFundMBR(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response responseLogin = login.getResponse();
		hzSessionId = login.getHzSessionId(responseLogin.asString());
		
		assertEquals("El status code es incorrecto" + responseLogin.getStatusCode() , 200, responseLogin.getStatusCode());
		
	}

	@When("llamo al metodo availableFundMBR")
	public void llamoAlMetodoAvailableFundMBR() {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.AVAILABLE_FUND_MBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		String request = "{\r\n" + 
				"    \"header\": {\r\n" + 
				"        \"caller\": {\r\n" + 
				"            \"system\": \"retail\",\r\n" + 
				"            \"name\": \"com.midd.test.service.AccountsService\",\r\n" + 
				"            \"operation\": \"listAccounts\",\r\n" + 
				"            \"version\": \"1.0.4\",\r\n" + 
				"            \"ip\": \"10.11.12.13\",\r\n" + 
				"            \"port\": 28080,\r\n" + 
				"            \"layer\": \"service\",\r\n" + 
				"            \"index\": 2,\r\n" + 
				"            \"latency\": 247\r\n" + 
				"        },\r\n" + 
				"        \"channel\": \"PRE\",\r\n" + 
				"        \"groupId\": \"20000000001\",\r\n" + 
				"        \"password\": \"xxx\",\r\n" + 
				"        \"remoteHost\": \"10.11.12.13\",\r\n" + 
				"        \"serviceName\": \"clientData\",\r\n" + 
				"        \"sessionId\": \"8a33ff49-64adce33-0164-add58e7b-9876\",\r\n" + 
				"        \"transactionId\": \"8a33ff49-64adce33-0164-add58e7b-0032\",\r\n" + 
				"        \"taskId\": \"0123456789\",\r\n" + 
				"        \"userId\": \"preuser\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		response =		
				given().
					spec(requestSpec).
					body(request).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("se valida que el code sea el esperado de availableFundMBR")
	public void seValidaQueElCodeSeaElEsperadoDeAvailableFundMBR() {
		assertEquals("El status code es incorrecto" + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

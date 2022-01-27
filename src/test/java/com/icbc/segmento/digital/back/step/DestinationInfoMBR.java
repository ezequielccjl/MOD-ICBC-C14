package com.icbc.segmento.digital.back.step;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

import com.icbc.segmento.digital.util.LoginBE;

import io.restassured.response.Response;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelDestinationInfoInput;
import com.ebanking.retail.model.RequestChannelDestinationInfoInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.dependency.ListBlrTwelveStatementInput;
import com.icbc.segmento.digital.util.dependency.RequestListBlrTwelveStatementInput;

public class DestinationInfoMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("Login exitoso con {string} {string} {string}")
	public void loginExitosoCon(String user, String pass, String deviceId) {
	    
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("Realiza la consulta con {string} {string} {string} {string}")
	public void realizaLaConsultaCon(String transactionId, String destinationAliasCbuCvu, String resultCode, String schema) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.DESTINATION_INFO_MBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionId);
		
		ChannelDestinationInfoInput destinationInfoInput = new ChannelDestinationInfoInput()
				.destinationAliasCbuCvu(destinationAliasCbuCvu);
		
		RequestChannelDestinationInfoInput request = (RequestChannelDestinationInfoInput) new RequestChannelDestinationInfoInput()
				.data(destinationInfoInput)
				.header(rh);
		
		response =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
    				body(request).
    			when().
    				post().
    			then().
    				body("header.resultCode", equalTo(resultCode)).
    				log().all().
					body(matchesJsonSchemaInClasspath(schema)).
    				extract().
    				response();	
		
	}

	@Then("Se verifica el codigo de respuesta")
	public void seVerificaElCodigoDeRespuesta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

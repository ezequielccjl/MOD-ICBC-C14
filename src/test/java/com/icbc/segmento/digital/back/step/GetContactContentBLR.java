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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetContactContentBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("preparamos las especificaciones del request")
	public void preparamosLasEspecificacionesDelRequest() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETCONTACTCONTENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo getContactContentBLR con {string} {string} {string} {string}")
	public void llamamosAlMetodoGetContactContentBLRCon(String channel, String transactionId, String resultCode, String schema) {
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		Request request = new Request()
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
					body(matchesJsonSchemaInClasspath(schema)).
					extract().
					response();	
	}

	@Then("validamos la response")
	public void validamosLaResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

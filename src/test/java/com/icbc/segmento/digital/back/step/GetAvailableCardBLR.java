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
import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.AvailableCardInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.RequestAvailableCardInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetAvailableCardBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan las especificaciones necesarias")
	public void sePreparanLasEspecificacionesNecesarias() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETAVAILABLECARDBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo getAvailableCardBLR con {string} {string} {string} {string} {string}")
	public void llamamosAlMetodoGetAvailableCardBLRCon(String channel, String cardNumber, String operationType, String productType, String resultCode) {
		RequestHeader rh = new RequestHeader()
				.channel(channel);
		
    	AvailableCardInput input = new AvailableCardInput()
    			.cardNumber(cardNumber)
    			.operationType(operationType)
    			.productType(productType);
    	
    	
    	RequestAvailableCardInput request = (RequestAvailableCardInput) new RequestAvailableCardInput()
    			.data(input)
    			.header(rh);
    	
    	System.out.println(request);
    	
    	response =		
				given().
					spec(requestSpec).
//					contentType(ContentType.JSON).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("validamos la response devuelta")
	public void validamosLaResponseDevuelta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

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
import com.ebanking.retail.model.CanceledProductsInput;
import com.ebanking.retail.model.RequestCanceledProductsInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class CanceledProductsBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("declaramos el requestSpecification")
	public void declaramosElRequestSpecification() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.CANCELEDPRODUCTSBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}
	
	@When("llamamos al metodo canceledProductsBLR con {string} {string} {string} {string} {string} {string} {string}")
	public void llamamosAlMetodoCanceledProductsBLRCon(String channel, String transactionId, String clientNumber, String fromCode, String toCode, String resultCode, String schema) {
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		CanceledProductsInput input = new CanceledProductsInput()
				.clientNumber(clientNumber)
				.fromCode(fromCode)
				.toCode(toCode);
		
		RequestCanceledProductsInput request = (RequestCanceledProductsInput) new RequestCanceledProductsInput()
				.data(input)
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
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
	
	@Then("se valida el codigo de la response")
	public void seValidaElCodigoDeLaResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}

	
}

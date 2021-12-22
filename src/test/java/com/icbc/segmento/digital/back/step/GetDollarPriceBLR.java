package com.icbc.segmento.digital.back.step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.DollarPriceInput;
import com.ebanking.retail.model.RequestDollarPriceInput;
import com.icbc.segmento.digital.util.Link;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDollarPriceBLR {
	
	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan los valores del request")
	public void sePreparanLosValoresDelRequest() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETDOLLARPRICEBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo getDollarPrice con {string} {string} {string} {string} {string}")
	public void llamoAlMetodoGetDollarPriceCon(String channel, String transactionId, String codorgb, String codsegm, String resultCode) {
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		DollarPriceInput dpi = new DollarPriceInput().codorgb(codorgb).codsegm(codsegm);
		
		RequestDollarPriceInput request = ((RequestDollarPriceInput) new RequestDollarPriceInput()
				.header(rh))
				.data(dpi);
		
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
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();
    	
    	
    	
	}

	@Then("se valida la respuesta del ms")
	public void seValidaLaRespuestaDelMs() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());   
	}

}

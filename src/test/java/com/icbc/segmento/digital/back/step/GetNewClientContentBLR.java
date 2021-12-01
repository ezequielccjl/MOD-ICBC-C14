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

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetNewClientContentBLR {
	
	private static RequestSpecification requestSpec;
	private static Response response;

	@Given("preparamos las especificaciones para el request")
	public void preparamosLasEspecificacionesParaElRequest() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETNEWCLIENTCONTENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo getFaqContent con {string} {string} {string} {string}")
	public void llamamosAlMetodoGetFaqContentCon(String transactionId, String channel, String userId, String password) {
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionId)
				.channel(channel)
				.userId(userId)
				.password(password);
    	
		Request request = new Request()
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
//					body("header.resultCode", equalTo("ok")).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("validamos el response")
	public void validamosElResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}

	
}

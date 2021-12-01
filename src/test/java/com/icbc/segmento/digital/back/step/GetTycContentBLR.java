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
public class GetTycContentBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("las especificaciones del request se preparan")
	public void lasEspecificacionesDelRequestSePreparan() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETTYCCONTENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo getTycContentBLR con {string} {string} {string} {string} {string}")
	public void llamoAlMetodoGetTycContentBLRCon(String channel, String password, String serviceName, String transactionId, String userId) {
	    
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.password(password)
				.serviceName(serviceName)
				.transactionId(transactionId)
				.userId(userId);
    	
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

	@Then("se valida el codigo de respuesta")
	public void seValidaElCodigoDeRespuesta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

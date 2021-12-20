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
public class ServicesHierarchyBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Se hace la preparacion de las especificaciones")
	public void seHaceLaPreparacionDeLasEspecificaciones() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.SERVICESHIERARCHYBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Se realiza la consulta al metodo servicesHierarchyBLR con {string} {string}")
	public void seRealizaLaConsultaAlMetodoServicesHierarchyBLRCon(String channel, String transactionId) {
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
//					body("header.resultCode", equalTo("ok")).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("Se verifica la response devuelta por el metodo")
	public void seVerificaLaResponseDevueltaPorElMetodo() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

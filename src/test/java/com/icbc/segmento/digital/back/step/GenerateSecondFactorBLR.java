package com.icbc.segmento.digital.back.step;

import com.icbc.segmento.digital.util.Link;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

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
import com.ebanking.retail.model.AamrGenerarSegundoFactorInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.RequestAamrGenerarSegundoFactorInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.icbc.segmento.digital.util.Link;

public class GenerateSecondFactorBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Llamada al servicio generateSecondFactorBLR")
	public void llamadaAlServicioGenerateSecondFactorBLR() {
	    
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GENERATESECONDFACTORBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
	}

	@When("Envio {string} {string} {string} {string} {string} {string} {string} {string} al servicio")
	public void envioAlServicio(String channel, String transactionId, String documentNumber, String docTypeCode, String providerName, String medioCode, String claveCode, String resultCode) {
	 
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		AamrGenerarSegundoFactorInput generateSecondFactorInput = new AamrGenerarSegundoFactorInput()
				.documentNumber(documentNumber)
				.docTypeCode(docTypeCode)
				.providerName(providerName)
				.medioCode(medioCode)
				.claveCode(claveCode);
		
		RequestAamrGenerarSegundoFactorInput request = (RequestAamrGenerarSegundoFactorInput) new RequestAamrGenerarSegundoFactorInput()
				.data(generateSecondFactorInput)
				.header(rh);
		
		response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
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

	@Then("Verificacion del status code")
	public void verificacionDelStatusCode() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

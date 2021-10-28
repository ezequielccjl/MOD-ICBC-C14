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

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetSecondFactorBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Llamada al servicio getSecondFactorBLR")
	public void llamadaAlServicioGetSecondFactorBLR() {
	    
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETSECONDFACTORBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
	}

	@When("Envio {string} {string} {string} {string} {string} {string} {string} true")
	public void envioTrue(String channel, String password, String serviceName, String transactionId, String userId, String docNumber, String docCode) {
	    
		boolean generatorIndicator = true;
		
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.password(password)
				.serviceName(serviceName)
				.transactionId(transactionId)
				.userId(userId);
		
    	GetSecondFactorInput getSecondFactorInput = new GetSecondFactorInput()
    			.docNumber(docNumber)
    			.docCode(docCode)
    			.generatorIndicator(generatorIndicator);
    	
    	
    	RequestGetSecondFactorInput request = (RequestGetSecondFactorInput) new RequestGetSecondFactorInput()
    			.data(getSecondFactorInput)
    			.header(rh);
    	
    	System.out.println(request);
    	
    	response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
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

	@Then("Verifico el status code")
	public void verificoElStatusCode() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

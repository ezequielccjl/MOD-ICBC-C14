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
import com.ebanking.retail.model.MessagingInput;
import com.ebanking.retail.model.RequestMessagingInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class MessagingOpBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Se preparan las especificaciones requeridas")
	public void sePreparanLasEspecificacionesRequeridas() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.MESSAGINGOPBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Llamada al metodo messagingOpBLR con {string} {string} {string} {string} {string} {string} {string}")
	public void llamadaAlMetodoMessagingOpBLRCon(String channel, String clientNumber, String docNumber, String typeDoc, String gender, String show, String resultCode) {
		
		RequestHeader header = new RequestHeader()
				.channel(channel);
    	
    	RequestMessagingInput request = (RequestMessagingInput) new RequestMessagingInput()
    			.header(header);
    	
    	if(resultCode.contentEquals("ok")) {
    		
    		MessagingInput data = new MessagingInput()
        			.clientNumber(clientNumber)
        			.docNumber(docNumber)
        			.typeDoc(typeDoc)
        			.gender(gender)
        			.show(show);
    		
    		request.data(data);
    	}
    	    	
    	response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("Verifico el status code devuelto")
	public void verificoElStatusCodeDevuelto() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

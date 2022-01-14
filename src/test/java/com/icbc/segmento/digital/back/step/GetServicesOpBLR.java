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

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.AvailableCardInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.GetServicesOpInput;
import com.ebanking.retail.model.RequestAvailableCardInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.ebanking.retail.model.RequestGetServicesOpInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetServicesOpBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan las especificaciones del request de getServicesOpBLR")
	public void sePreparanLasEspecificacionesDelRequestDeGetServicesOpBLR() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GET_SERVICES_OP_BLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo getServicesOpBLR con {string} {string} {string} {string}")
	public void llamoAlMetodoGetServicesOpBLRCon(String channel, String transactionId, String operationServiceId, String resultCode) {
		
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		GetServicesOpInput data = new GetServicesOpInput();
		
		if(operationServiceId.contentEquals("3")) {
			data.operationServiceId(Integer.parseInt(operationServiceId));
		} else {
			data.operationServiceId(null);
		}
		
		RequestGetServicesOpInput request = (RequestGetServicesOpInput) new RequestGetServicesOpInput()
				.data(data)
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
					body(request).
				when().
				log().all().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
					log().all().
					extract().
					response();	
	}

	@Then("se valida la response de getServicesOpBLR")
	public void seValidaLaResponseDeGetServicesOpBLR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

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
import com.ebanking.retail.model.RequestAvailableCardInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ServicesHolidays {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan las especificaciones del request de servicesHolidaysBLR")
	public void sePreparanLasEspecificacionesDelRequestDeServicesHolidaysBLR() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.SERVICES_HOLIDAYS_BLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo servicesHolidaysBLR con {string} {string}")
	public void llamoAlMetodoServicesHolidaysBLRCon(String channel, String transactionId) {
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		Request request = new Request()
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("se valida la response de servicesHolidaysBLR")
	public void seValidaLaResponseDeServicesHolidaysBLR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

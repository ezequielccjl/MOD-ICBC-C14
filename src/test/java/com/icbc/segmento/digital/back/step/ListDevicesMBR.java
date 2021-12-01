package com.icbc.segmento.digital.back.step;

import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

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
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListDevicesMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("Se loguea con {string} {string} {string} correctamente")
	public void seLogueaConCorrectamente(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	
	}

	@When("Se realiza la consulta al metodo listDevicesMBR con {string} {string}")
	public void seRealizaLaConsultaAlMetodoListDevicesMBRCon(String transactionId, String channel) {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTDEVICESMBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		Request request = new Request()
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
					body(request).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("Se verifica la response code devuelta")
	public void seVerificaLaResponseCodeDevuelta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

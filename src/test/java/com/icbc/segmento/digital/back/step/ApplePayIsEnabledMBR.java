package com.icbc.segmento.digital.back.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelApplePayIsEnabledInput;
import com.ebanking.retail.model.ChannelProductCardListDataMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelApplePayIsEnabledInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ApplePayIsEnabledMBR {
	
	private static Response response;
	private static String hzSessionId;

	@Given("se prepara el logueo con los datos {string} {string} {string}")
	public void sePreparaElLogueoConLosDatos(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
    	
	}

	@When("llamo al metodo applePayIsEnabledMBR con {string}")
	public void llamoAlMetodoApplePayIsEnabledMBRCon(String transactionId) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.APPLEPAYISENABLEDMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionId);
		
		ChannelApplePayIsEnabledInput input = new ChannelApplePayIsEnabledInput();
		
		RequestChannelApplePayIsEnabledInput request = (RequestChannelApplePayIsEnabledInput) new RequestChannelApplePayIsEnabledInput()
				.data(input)
				.header(rh);
		
		response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					header("Cookie", hzSessionId).
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

	@Then("se valida que el code sea el esperado")
	public void seValidaQueElCodeSeaElEsperado() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

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
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.model.ServiceInstance;
import com.ebanking.retail.model.ChannelNewProductSendMailInput;
import com.ebanking.retail.model.ChannelSecondFactorInput;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestChannelNewProductSendMailInput;
import com.ebanking.retail.model.RequestChannelSecondFactorInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class NewProductSendMailMBR {
	
	private static String hzSessionId;
	private static Response response;
	
	@Given("se ejecuta login con {string} {string} {string} para newProductSendMailMBR")
	public void seEjecutaLoginConParaNewProductSendMailMBR(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}
	
	@When("llamo al metodo getClientData con  {string} para newProductSendMailMBR")
	public void llamoAlMetodoGetClientDataConParaNewProductSendMailMBR(String transactionId) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEWGETCLIENTDATA)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		Request request = new Request()
				.header(header);
		
		response =		
			given().
				spec(requestSpec).
				header("Cookie", hzSessionId).
				body(request).
			when().
				post().
			then().
				log().all().
				extract().
				response();	
	}

	@When("llamo al metodo newProductSendMailMBR con {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamoAlMetodoNewProductSendMailMBRCon(String channel, String transactionId, String requestDate, String incomeDescription, String productDescription, String subProductDescription, String productCode, String subjectDescription, String contactPhoneNumber, String email, String messageCode) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEW_PRODUCT_SEND_MAIL_MBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		long fecha = Long.parseLong(requestDate.replace("-", ""));
		Date requestDate2 = new Date(fecha);
		
		ChannelNewProductSendMailInput data = new ChannelNewProductSendMailInput()
				.requestDate(requestDate2)
				.incomeDescription(incomeDescription)
				.productDescription(productDescription)
				.subProductDescription(subProductDescription)
				.productCode(productCode)
				.subjectDescription(subjectDescription)
				.contactPhoneNumber(contactPhoneNumber)
				.email(email);
		
		RequestChannelNewProductSendMailInput request = (RequestChannelNewProductSendMailInput) new RequestChannelNewProductSendMailInput()
				.data(data)
				.header(header);
		
		response =		
			given().
				spec(requestSpec).
				header("Cookie", hzSessionId).
				body(request).
			when().
				post().
			then().
				body("header.messageCode", equalTo(messageCode)).
				log().all().
				extract().
				response();	
	}

	@Then("validamos el codigo que nos devuelve el metodo")
	public void validamosElCodigoQueNosDevuelveElMetodo() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}

}

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
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.PaymentInputs;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.ebanking.retail.model.RequestPaymentInputs;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class PaymentBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Se preparan las especificaciones para el request")
	public void sePreparanLasEspecificacionesParaElRequest() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.PAYMENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Llamo al metodo paymentBLR con los datos {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamoAlMetodoPaymentBLRConLosDatos(String channel, String transactionId, String confirmPaymentIndicator, String currencyCode, String cardNumber, String accountProductNumber, String accountProductCurrency, String cardTypeIndicator, String resultCode) {
		
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
    	PaymentInputs paymentInput = new PaymentInputs()
    			.confirmPaymentIndicator(Boolean.valueOf(confirmPaymentIndicator))
    			.currencyCode(currencyCode)
    			.cardNumber(cardNumber)
    			.accountProductNumber(accountProductNumber)
    			.accountProductCurrency(accountProductCurrency)
    			.cardTypeIndicator(cardTypeIndicator);
    	
    	RequestPaymentInputs request = (RequestPaymentInputs) new RequestPaymentInputs()
    			.data(paymentInput)
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

	@Then("Verificamos que el response code sea correcto")
	public void verificamosQueElResponseCodeSeaCorrecto() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

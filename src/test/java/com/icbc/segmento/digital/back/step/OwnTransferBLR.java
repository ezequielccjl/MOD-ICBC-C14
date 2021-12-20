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
import com.ebanking.retail.model.AccountTransfer;
import com.ebanking.retail.model.Currency;
import com.ebanking.retail.model.CurrencyTransfer;
import com.ebanking.retail.model.MessagingInput;
import com.ebanking.retail.model.OwnTransferInput;
import com.ebanking.retail.model.RequestMessagingInput;
import com.ebanking.retail.model.RequestOwnTransferInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class OwnTransferBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan las especificaciones necesarias para el request")
	public void sePreparanLasEspecificacionesNecesariasParaElRequest() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.OWNTRANSFERBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo ownTransferBLR con {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamamosAlMetodoOwnTransferBLRCon(String transactionId, String channel, String number, String docCode, String docNumber, String accountCode, String code, String description, String destinationNumber, String destinationCode, String destionationDescription, String currencyDescription, String amount, String resultCode) {
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId)
				.channel(channel);
		
		Currency originCurrency = new Currency()
				.code(code)
				.description(description);
		
		AccountTransfer originAccountTransfer = ((AccountTransfer) new AccountTransfer()
				.number(number))
				.docCode(docCode)
				.docNumber(docNumber)
				.accountCode(accountCode)
				.currency(originCurrency);
		
		Currency destinationCurrency = new Currency()
				.code(destinationCode)
				.description(destionationDescription);
		
		AccountTransfer destinationAccountTransfer = ((AccountTransfer) new AccountTransfer()
				.number(destinationNumber))
				.accountCode(accountCode)
				.currency(destinationCurrency);
		
		CurrencyTransfer currencyTransfer = new CurrencyTransfer()
				.code(code)
				.description(currencyDescription);
		
    	OwnTransferInput data = new OwnTransferInput()
    			.originAccountTransfer(originAccountTransfer)
    			.destinationAccountTransfer(destinationAccountTransfer)
    			.currencyTransfer(currencyTransfer)
    			.amount(Double.valueOf(amount));
    	
    	RequestOwnTransferInput request = (RequestOwnTransferInput) new RequestOwnTransferInput()
    			.data(data)
    			.header(header);
    	    	
    	response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
					log().all().
					extract().
					response();	
	}

	@Then("validamos la response que nos devuelta")
	public void validamosLaResponseQueNosDevuelta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

	}
	
}

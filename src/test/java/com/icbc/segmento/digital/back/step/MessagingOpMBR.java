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
import com.ebanking.retail.model.ChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.Currency;
import com.ebanking.retail.model.CurrencyTransfer;
import com.ebanking.retail.model.MessagingInput;
import com.ebanking.retail.model.OwnTransferInput;
import com.ebanking.retail.model.RequestChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.RequestMessagingInput;
import com.ebanking.retail.model.RequestOwnTransferInput;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.MessagingOpAux;

@RunWith(Cucumber.class)
@CucumberOptions()
public class MessagingOpMBR {

	private static String hzSessionId;
	private static Response response;
	
	@Given("se realiza el login exitosamente con {string} {string} {string}")
	public void seRealizaElLoginExitosamenteCon(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());

		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("llamo al metodo getClientData con {string}")
	public void llamoAlMetodoGetClientDataCon(String transactionId) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEWGETCLIENTDATA)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		BodyHeader header = new BodyHeader();
		String request = header.getHeaderWithTransactionId(transactionId);
	
    	Response responseGetClientData =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
    				header("Content-Type", "application/json").
    				body(request).
    			when().
    			log().all().
    				post().
    			then().
//    				body("header.resultCode", equalTo("ok")).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
		
		assertEquals("El status code es incorrecto " + responseGetClientData.getStatusCode() , 200, responseGetClientData.getStatusCode());
		
	}

	@When("llamo al metodo messagingOpMBR con {string} {string}")
	public void llamoAlMetodoMessagingOpMBRCon(String channel, String show) {
	
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.MESSAGINGOPMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
//    	RequestHeader rh = new RequestHeader()
//    			.channel(channel);
//    	
//    	MessagingInput data = new MessagingInput()
//    			.show(show);
//    	
//    	RequestMessagingInput request = (RequestMessagingInput) new RequestMessagingInput()
//    			.data(data)
//    			.header(rh);

		MessagingOpAux auxiliar = new MessagingOpAux();
		
    	response =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
    				body(auxiliar.getBodyWithChannelAndShow(channel, show)).
    			when().
    				post().
    			then().
//    				body("header.resultCode", equalTo("ok")).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
	}

	@Then("validamos el codigo de respuesta que se devuelve")
	public void validamosElCodigoDeRespuestaQueSeDevuelve() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());

	}
	
}

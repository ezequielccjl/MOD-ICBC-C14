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
import com.ebanking.retail.model.AccountTransfer;
import com.ebanking.retail.model.ChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.Currency;
import com.ebanking.retail.model.CurrencyTransfer;
import com.ebanking.retail.model.MessagingInput;
import com.ebanking.retail.model.OwnTransferInput;
import com.ebanking.retail.model.RequestChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.RequestMessagingInput;
import com.ebanking.retail.model.RequestOwnTransferInput;
import com.icbc.segmento.digital.back.LoginC1;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.MessagingOpAux;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListExtractionMBR {
	
	private static String hzSessionId;
	private static Response response;
	
	@Given("se ejecuta el login con {string} {string} {string} de manera correcta")
	public void seEjecutaElLoginConDeManeraCorrecta(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());

	
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("llamo al metodo listExtractionMBR con {string} {string}")
	public void llamoAlMetodoListExtractionMBRCon(String channel, String transactionId) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTEXTRACTIONMBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.channel(channel)
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
//    				body("header.resultCode", equalTo("ok")).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
		
		
	}

	@Then("validamos el codigo del response")
	public void validamosElCodigoDelResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());

	}

}

package com.icbc.segmento.digital.back.step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelDollarPriceInput;
import com.ebanking.retail.model.RequestChannelDollarPriceInput;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDollarPriceMBR {
	
	private static Response response;
	private static String hzSessionId;
	
	@Given("preparamos logueo con {string} {string} {string}")
	public void preparamosLogueoCon(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	}

	@When("llamo al metodo getDollarPriceMBR con {string} {string} {string}")
	public void llamoAlMetodoGetDollarPriceMBRCon(String channel, String transactionId, String fromInvestment) {
		
		System.out.println("----------------------------GETCLIENTDATA");
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
//    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
//    				header("Content-Type", "application/json").
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
		
		//---------------
		
		
		RequestSpecification requestSpec2 = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETDOLLARPRICEMBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		ChannelDollarPriceInput cdi = new ChannelDollarPriceInput()
				.fromInvestment(fromInvestment);
		
		RequestChannelDollarPriceInput request2 = (RequestChannelDollarPriceInput) new RequestChannelDollarPriceInput()
				.data(cdi)
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec2).
					body(request2).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("validamos el codigo final del response")
	public void validamosElCodigoFinalDelResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    
	}

}

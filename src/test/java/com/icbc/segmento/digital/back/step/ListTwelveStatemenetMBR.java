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

import java.sql.Date;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.GetClientDataInput;
import com.ebanking.retail.model.RequestChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.RequestGetClientDataInput;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.dependency.ListBlrTwelveStatementInput;
import com.icbc.segmento.digital.util.dependency.RequestListBlrTwelveStatementInput;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListTwelveStatemenetMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("El usuario realiza login con {string} {string} {string}")
	public void elUsuarioRealizaLoginCon(String user, String pass, String deviceId) {
	    
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		System.out.println(hzSessionId);
		System.out.println("===================================Login");
		
	}

	@When("Realiza la consulta al metodo getClientData con {string}")
	public void realizaLaConsultaAlMetodoGetClientDataCon(String transactionId) {
	 
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETCLIENTDATAMBR)
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
    	String respGetClientData = responseGetClientData.asPrettyString();
    	System.out.println("+++++++++"+respGetClientData);
		
		assertEquals("El status code es incorrecto " + responseGetClientData.getStatusCode() , 200, responseGetClientData.getStatusCode());
		System.out.println("===================================getClientData");
	}

	@When("Realiza la consulta al metodo listProductCard con {string}")
	public void realizaLaConsultaAlMetodoListProductCardCon(String transactionId) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTPRODUCTCARD)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	RequestHeader rh = new RequestHeader()
    			.transactionId(transactionId);
    	
    	Request request = new Request().header(rh);
    	System.out.println(request.toString()+" -----------------------------");
    	
    	Response responseListProductCard =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
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
		
		assertEquals("El status code es incorrecto " + responseListProductCard.getStatusCode() , 200, responseListProductCard.getStatusCode());
		System.out.println("===================================listProductCard");
		
	}

	@When("Realiza la consulta al metodo listTwelveStatementMBR con {string} {string} {string} {string} {string}")
	public void realizaLaConsultaAlMetodoListTwelveStatementMBRCon(String transactionId, String canceledIndicator, String cardProductIndexNumber, String cardBrandIndicatorCode, String resultCode) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTTWELVESTATEMENTMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	RequestHeader rh = new RequestHeader()
    			.transactionId(transactionId);
    	
    	ChannelMbrListTwelveStatementInput listTwelveStatementInput = new ChannelMbrListTwelveStatementInput()
    			.canceledIndicator(Boolean.valueOf(canceledIndicator))
    			.cardProductIndexNumber(cardProductIndexNumber)
    			.cardBrandIndicatorCode(cardBrandIndicatorCode);
    	
    	RequestChannelMbrListTwelveStatementInput request = (RequestChannelMbrListTwelveStatementInput) new RequestChannelMbrListTwelveStatementInput()
    			.data(listTwelveStatementInput)
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
    				body("header.resultCode", equalTo(resultCode)).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
    	System.out.println("===================================listTwelveStatement");
	}

	@Then("Verifico la response")
	public void verificoLaResponse() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

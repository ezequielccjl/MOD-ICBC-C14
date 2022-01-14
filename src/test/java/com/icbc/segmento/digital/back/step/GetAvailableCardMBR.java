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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.GetClientDataInput;
import com.ebanking.retail.model.RequestChannelMbrListTwelveStatementInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.ebanking.retail.model.RequestGetClientDataInput;
import com.icbc.segmento.digital.util.BodyHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.dependency.ListBlrTwelveStatementInput;
import com.icbc.segmento.digital.util.dependency.RequestListBlrTwelveStatementInput;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetAvailableCardMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("Se realiza login con {string} {string} {string} correctamente")
	public void seRealizaLoginConCorrectamente(String user, String pass, String deviceId) {
		System.out.println("----------------------------LOGIN");
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("Se realiza la consulta al metodo getClientData con {string}")
	public void seRealizaLaConsultaAlMetodoGetClientDataCon(String transactionId) {
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
		
	}

	@When("Se realiza la consulta al metodo listProducts con {string}")
	public void seRealizaLaConsultaAlMetodoListProductsCon(String transactionId) {
		System.out.println("----------------------------LISTPRODUCTS");
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LIST_PRODUCTS_MBR)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		List<Filter> listCode = new ArrayList<Filter>();
		listCode.add(new Filter().code("01"));
		listCode.add(new Filter().code("02"));
		listCode.add(new Filter().code("11"));
		listCode.add(new Filter().code("12"));
		listCode.add(new Filter().code("17"));
		listCode.add(new Filter().code("37"));
		listCode.add(new Filter().code("38"));
		listCode.add(new Filter().code("61"));
		listCode.add(new Filter().code("62"));
			
		ChannelProductListInputMbr channelProductListInput = new ChannelProductListInputMbr().filter(listCode);
																 	
		RequestChannelProductListInputMbr request = (RequestChannelProductListInputMbr) (new RequestChannelProductListInputMbr())
				.data(channelProductListInput)
				.header(header);		
    
    	response =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				header("Cookie", hzSessionId).
    				body(request).
    			when().
    				post().
    			then().
    				log().all().
    				extract().
    				response();	
	}

	@When("Se realiza la consulta al metodo getAvailableCardMBR con {string}")
	public void seRealizaLaConsultaAlMetodoGetAvailableCardMBRCon(String channel) {
		System.out.println("----------------------------GETAVAILABLECARD");
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETAVAILABLECARDMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	RequestHeader rh = new RequestHeader()
    			.channel(channel);
    	
    	Request request = new Request()
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
//    				body("header.resultCode", equalTo("ok")).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
	}

	@Then("Se verifica la response devuelta")
	public void seVerificaLaResponseDevuelta() {
		System.out.println("----------------------------FINAL");
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

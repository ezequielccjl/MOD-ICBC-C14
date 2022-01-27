package com.icbc.segmento.digital.back.step;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelCardExpensesRecentInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelCardExpensesRecentInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.Utilities;

@RunWith(Cucumber.class)
@CucumberOptions()
public class CardExpensesRecentMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("se prepara el login para el metodo con los datos {string} {string} {string}")
	public void sePreparaElLoginParaElMetodoConLosDatos(String user, String pass, String deviceId) {
	    LoginBE login = new LoginBE(user, pass, deviceId);
	    Response loginResponse = login.getResponse();
	    hzSessionId = login.getHzSessionId(loginResponse.asString());
	    
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	}

	@When("se ejecuta el paso intermedio listProducts con los datos {string}")
	public void seEjecutaElPasoIntermedioListProductsConLosDatos(String transactionId) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LIST_PRODUCTS_MBR)
				.setRelaxedHTTPSValidation()
				.build();
    	
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
																 	
		RequestChannelProductListInputMbr requestChannelProductListInput = (RequestChannelProductListInputMbr) (new RequestChannelProductListInputMbr())
				.data(channelProductListInput);		
		
		Response listProductResponse =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					header("Cookie", hzSessionId).
					body(requestChannelProductListInput).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
		
	}

	@When("se ejecuta el metodo cardExpensesRecentMBR con los datos {string} {string} {string} {string}")
	public void seEjecutaElMetodoCardExpensesRecentMBRConLosDatos(String transactionId, String productId, String errorCode, String schema) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.CARDEXPENSESRECENTMBR)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		ChannelCardExpensesRecentInput data = new ChannelCardExpensesRecentInput()
				.productId(productId);
		
		RequestChannelCardExpensesRecentInput request = (RequestChannelCardExpensesRecentInput) new RequestChannelCardExpensesRecentInput()
				.data(data)
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
					body(matchesJsonSchemaInClasspath(schema)).
					extract().
					response();	
		
		if(errorCode.contentEquals("error")) {
    		Utilities utils = new Utilities();
    		JSONArray jsonArray = new JSONObject(utils.prettyPrintResponse(response)).getJSONObject("header").getJSONArray("errorDetail");
    		String errorCodeFromJsonArray = utils.getStringFromJsonArray(jsonArray, "code");
    		assertEquals("El errorCode es incorrecto: " + errorCodeFromJsonArray , errorCode, errorCodeFromJsonArray);    	
    	}
		
	}

	@Then("se chequea que el response code sea el esperado")
	public void seChequeaQueElResponseCodeSeaElEsperado() {
		assertEquals("El status code es incorrecto" + response.getStatusCode() , 200, response.getStatusCode());
	}
	
}

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

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.AddContactsInput;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestAddContactsInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.Utilities;

public class AddContactBLR {

	private static Response response;
	
	@Given("El usuario loguea")
	public void elUsuarioLoguea() {
	    
	}

	@When("Realiza la consulta con {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void realizaLaConsultaCon(String transactionid, String channel, String documentnumber, String documenttype, String cuitcuilnumber, String cbunumber, String description, String accountcode, String errorCode) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.ADDCONTACTBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionid)
				.channel(channel);
		
    	AddContactsInput addContactInput = new AddContactsInput()
    			.documentNumber(documentnumber)
    			.documentType(documenttype)
    			.cuitCuilNumber(cuitcuilnumber)
    			.cbuNumber(cbunumber)
    			.description(description)
    			.accountCode(accountcode);
    	
    	
    	RequestAddContactsInput request = (RequestAddContactsInput) new RequestAddContactsInput()
    			.data(addContactInput)
    			.header(rh);
    	    	
    	response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					body(request).
				when().
					post().
				then().
					log().all().
					extract().
					response();	

    	if(errorCode.contentEquals("1000")) {
    		Utilities utils = new Utilities();
    		JSONArray jsonArray = new JSONObject(utils.prettyPrintResponse(response)).getJSONObject("header").getJSONArray("error");
    		String errorCodeFromJsonArray = utils.getStringFromJsonArray(jsonArray, "code");
    		assertEquals("El errorCode es incorrecto: " + errorCodeFromJsonArray , errorCode, errorCodeFromJsonArray);    	
    	}

		
	}

	@Then("Verifico el codigo")
	public void verificoElCodigo() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

package com.icbc.segmento.digital.back.step;

import cucumber.api.PendingException;
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
import com.ebanking.retail.model.DeleteContactInput;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestAddContactsInput;
import com.ebanking.retail.model.RequestDeleteContactInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.DeleteContactAux;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.Utilities;

@RunWith(Cucumber.class)
@CucumberOptions()
public class DeleteContactBLR {
	
	private static Response response;
	private static Response response2;
	private static String hzSessionId;
	private static String docType;
	private static String docNum;

    @Given("^El usuario se loguea con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioSeLogueaConSomethingSomethingSomething(String user, String pass, String deviceId) {
        
    	LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		docType = login.getDocType(loginResponse.asString());
		docNum = login.getDocNum(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
    	
    }

    @When("Realiza la consulta con los datos {string} {string} {string} {string} {string} {string}")
    public void realizaLaConsultaConLosDatos(String transactionid, String channel, String documentnumber, String documentcode,  String destinationcbucvualias, String errorCode) {
        System.out.println("------------------------------ADDCONTACT");
    	RequestSpecification requestSpec2;
		requestSpec2 = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.ADDCONTACTBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader rh2 = new RequestHeader()
				.transactionId("12c21775-afdf-4a08-a0b9-2939360fe1c9")
				.channel("mbr");
		
    	AddContactsInput addContactInput = new AddContactsInput()
    			.documentNumber("16445351")
    			.documentType("04")
    			.cuitCuilNumber("27148193342")
    			.cbuNumber("0150501601000008074781")
    			.description("del carmen")
    			.accountCode("4");
    	
    	
    	RequestAddContactsInput request2 = (RequestAddContactsInput) new RequestAddContactsInput()
    			.data(addContactInput)
    			.header(rh2);
    	
    	System.out.println(request2);
    	
    	response2 =		
				given().
					spec(requestSpec2).
					contentType(ContentType.JSON).
					body(request2).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
    	
		assertEquals("El status code es incorrecto " + response2.getStatusCode() , 200, response2.getStatusCode());    	

        System.out.println("------------------------------DELETECONTACT");

    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.DELETECONTACTBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	/*
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionid)
				.channel(channel);
		
    	DeleteContactInput deleteContactInput = new DeleteContactInput()
    			.destinationCbuCvuAlias(destinationcbucvualias)
    			.documentNumber(documentnumber)
    			.documentCode(documentcode);
    	
    	RequestDeleteContactInput request = (RequestDeleteContactInput) new RequestDeleteContactInput()
    			.data(deleteContactInput)
    			.header(rh);*/
    	    	
    	DeleteContactAux aux = new DeleteContactAux();
    	
    	String request = aux.getBody(transactionid, channel, documentnumber, documentcode, destinationcbucvualias);
    	
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
    	
    	System.out.println("------------------------------ERRORCODE");
    	
    	if(errorCode.contentEquals("1000")) {
    		Utilities utils = new Utilities();
    		JSONArray jsonArray = new JSONObject(utils.prettyPrintResponse(response)).getJSONObject("header").getJSONArray("errorDetail");
    		String errorCodeFromJsonArray = utils.getStringFromJsonArray(jsonArray, "code");
    		assertEquals("El errorCode es incorrecto: " + errorCodeFromJsonArray , errorCode, errorCodeFromJsonArray);    	
    	}

    	
    }

    @Then("^Verifico el codigo de respuesta$")
    public void verificoElCodigoDeRespuesta() {
    	System.out.println("------------------------------FINAL");

		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

    }

}
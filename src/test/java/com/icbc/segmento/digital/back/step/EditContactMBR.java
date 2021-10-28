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

import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelEditContactInput;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestChannelEditContactInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class EditContactMBR {

	private static String hzSessionId;
	private static Response response;
	
	@Given("Usuario loguea con {string} {string} {string}")
	public void usuarioLogueaCon(String user, String pass, String deviceid) {
	    
		LoginBE login = new LoginBE(user, pass, deviceid);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("Realiza consulta con los datos {string} {string} {string} {string} {string} {string} {string}")
	public void realizaConsultaConLosDatos(String transactionId, String channel, String destinationCbuCvuAlias, String cuitcuilNumber, String cbuNumber, String description, String accountCode) {
	    
		 
    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.EDITCONTACTMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionId)
				.channel(channel);
		
    	ChannelEditContactInput editContactInput = new ChannelEditContactInput()
    			.destinationCbuCvuAlias(destinationCbuCvuAlias)
    			.cbuNumber(cbuNumber)
    			.cuitcuilNumber(cuitcuilNumber)
    			.description(description)
    			.accountCode(accountCode);
    	
    	
    	RequestChannelEditContactInput request = (RequestChannelEditContactInput) new RequestChannelEditContactInput()
    			.data(editContactInput)
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
//					body("header.resultCode", equalTo("ok")).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
		
	}

	@Then("Verifico el codigo de la respuesta")
	public void verificoElCodigoDeLaRespuesta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}

	
}

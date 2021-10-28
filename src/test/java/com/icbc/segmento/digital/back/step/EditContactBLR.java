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
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class EditContactBLR {
	
	private static Response response;
	private static String hzSessionId;

    @Given("^El usuario loguea con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioLogueaConSomethingSomethingSomething(String user, String pass, String deviceId) {
        
    	LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
    	
    }

    @When("^Hace la consulta con los datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void haceLaConsultaConLosDatosSomethingSomethingSomethingSomethingSomethingSomethingSomethingSomethingSomething(String transactionid, String channel, String destinationcbucvualias, String documentnumber, String documentcode, String cuitcuilnumber, String cbunumber, String description, String accountcode) {
        
    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.EDITCONTACTBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionid)
				.channel(channel);
		
    	EditContactInput editContactInput = new EditContactInput()
    			.destinationCbuCvuAlias(destinationcbucvualias)
    			.documentNumber(documentnumber)
    			.documentCode(documentcode)
    			.cuitCuilNumber(cuitcuilnumber)
    			.cbuNumber(cbunumber)
    			.description(description)
    			.accountCode(accountcode);
    	
    	
    	RequestEditContactInput request = (RequestEditContactInput) new RequestEditContactInput()
    			.data(editContactInput)
    			.header(rh);
    	
    	System.out.println(request);
    	
    	response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
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

    @Then("^Verifico la respuesta$")
    public void verificoLaRespuesta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	

    }

}

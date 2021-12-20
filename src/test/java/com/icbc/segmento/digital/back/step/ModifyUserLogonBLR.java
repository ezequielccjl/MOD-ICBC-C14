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
import com.ebanking.retail.model.ModifyUserLogonInput;
import com.ebanking.retail.model.RequestModifyUserLogonInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ModifyUserLogonBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("se preparan las especificaciones para el metodo")
	public void sePreparanLasEspecificacionesParaElMetodo() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.MODIFYUSERLOGONBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo modifyUserLogonBLR con {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamoAlMetodoModifyUserLogonBLRCon(String channel, String transactionId, String klogonUserId, String klogonType, String klogonNum, String klogonPass, String kgender, String resultCode) {
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		ModifyUserLogonInput input = new ModifyUserLogonInput()
				.klogonUserId(klogonUserId)
				.klogonType(klogonType)
				.klogonNum(klogonNum)
				.klogonPass(klogonPass)
				.kgender(kgender);
    	
		RequestModifyUserLogonInput request = (RequestModifyUserLogonInput) new RequestModifyUserLogonInput()
				.data(input)
				.header(rh);
		
    	response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo(resultCode)).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("validamos que el response code sea el esperado")
	public void validamosQueElResponseCodeSeaElEsperado() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

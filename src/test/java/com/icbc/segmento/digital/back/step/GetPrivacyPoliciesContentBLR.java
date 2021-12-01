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

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.PrivacyPoliciesInput;
import com.ebanking.retail.model.RequestPrivacyPoliciesInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetPrivacyPoliciesContentBLR {
	
	private static RequestSpecification requestSpec;
	private static Response response;

	@Given("se preparan las especificaciones para llamar al metodo")
	public void sePreparanLasEspecificacionesParaLlamarAlMetodo() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETPRIVACYPOLICIESCONTENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamo al metodo getPrivacyPoliciesContentBLR con {string} {string} {string} {string} {string} {string}")
	public void llamoAlMetodoGetPrivacyPoliciesContentBLRCon(String channel, String password, String serviceName, String transactionId, String userId, String contentName) {
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.password(password)
				.serviceName(serviceName)
				.transactionId(transactionId)
				.userId(userId);
    	
		PrivacyPoliciesInput privacyPoliciesInput = new PrivacyPoliciesInput()
				.contentName(contentName);
		
		RequestPrivacyPoliciesInput request = (RequestPrivacyPoliciesInput) new RequestPrivacyPoliciesInput()
				.data(privacyPoliciesInput)
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
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

	@Then("se valida que el response sea el esperado")
	public void seValidaQueElResponseSeaElEsperado() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

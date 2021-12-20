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
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelPrivacyPoliciesInput;
import com.ebanking.retail.model.RequestChannelPrivacyPoliciesInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetPrivacyPoliciesContentMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("se prepara el login para los datos {string} {string} {string}")
	public void sePreparaElLoginParaLosDatos(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	
	}

	@When("llamo al metodo getPrivacyPoliciesContentMBR con {string} {string} {string}")
	public void llamoAlMetodoGetPrivacyPoliciesContentMBRCon(String transactionId, String contentName, String resultCode) {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETPRIVACYPOLICIESCONTENTMBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.transactionId(transactionId);
		
		ChannelPrivacyPoliciesInput privacyPoliciesInput = new ChannelPrivacyPoliciesInput()
				.contentName(contentName);
		
		RequestChannelPrivacyPoliciesInput request = (RequestChannelPrivacyPoliciesInput) new RequestChannelPrivacyPoliciesInput()
				.data(privacyPoliciesInput)
				.header(rh);
    	
    	response =		
				given().
					spec(requestSpec).
					body(request).
					header("Cookie", hzSessionId).
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

	@Then("se valida que el response code sea el esperado")
	public void seValidaQueElResponseCodeSeaElEsperado() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

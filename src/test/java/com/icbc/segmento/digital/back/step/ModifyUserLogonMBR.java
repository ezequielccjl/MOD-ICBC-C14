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

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelModifyUserLogonInput;
import com.ebanking.retail.model.RequestChannelModifyUserLogonInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ModifyUserLogonMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("realizamos el login con los datos {string} {string} {string}")
	public void realizamosElLoginConLosDatos(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	
	}

	@When("llamo al metodo modifyUserLogonMBR con {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamoAlMetodoModifyUserLogonMBRCon(String channel, String transactionId, String klogonUserId, String klogonType, String klogonNum, String klogonPass, String kgender, String resultCode) {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.MODIFYUSERLOGONMBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
    	
		ChannelModifyUserLogonInput input = new ChannelModifyUserLogonInput()
				.klogonUserId(klogonUserId)
				.klogonType(klogonType)
				.klogonNum(klogonNum)
				.klogonPass(klogonPass)
				.kgender(kgender);
    	
		RequestChannelModifyUserLogonInput request = (RequestChannelModifyUserLogonInput) new RequestChannelModifyUserLogonInput()
				.data(input)
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

	@Then("validamos que el codigo de respuesta sea el esperado")
	public void validamosQueElCodigoDeRespuestaSeaElEsperado() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}

	
}

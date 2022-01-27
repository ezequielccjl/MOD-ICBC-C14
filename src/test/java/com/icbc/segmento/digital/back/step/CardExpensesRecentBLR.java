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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.CanceledProductsInput;
import com.ebanking.retail.model.CardExpensesRecentInput;
import com.ebanking.retail.model.RequestCanceledProductsInput;
import com.ebanking.retail.model.RequestCardExpensesRecentInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.Utilities;

@RunWith(Cucumber.class)
@CucumberOptions()
public class CardExpensesRecentBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Se preparan las especificaciones requeridas para el metodo")
	public void sePreparanLasEspecificacionesRequeridasParaElMetodo() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.CARDEXPENSESRECENTBLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Realiza la consulta con los datos a cardExpensesRecentBLR con {string} {string} {string} {string} {string} {string}")
	public void realizaLaConsultaConLosDatosACardExpensesRecentBLRCon(String transactionId, String typeOp, String cardNumber, String typeCard, String errorCode, String schema) {
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		CardExpensesRecentInput data = new CardExpensesRecentInput()
				.typeOp(typeOp)
				.cardNumber(cardNumber)
				.typeCard(typeCard);
		
		RequestCardExpensesRecentInput request = (RequestCardExpensesRecentInput) new RequestCardExpensesRecentInput()
				.data(data)
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					log().all().
					body(matchesJsonSchemaInClasspath(schema)).
					extract().
					response();	
		
		if(errorCode.contentEquals("error data")) {
    		Utilities utils = new Utilities();
    		JSONArray jsonArray = new JSONObject(utils.prettyPrintResponse(response)).getJSONObject("header").getJSONArray("errorDetail");
    		String errorCodeFromJsonArray = utils.getStringFromJsonArray(jsonArray, "code");
    		assertEquals("El errorCode es incorrecto: " + errorCodeFromJsonArray , errorCode, errorCodeFromJsonArray);    	
    	}
	}

	@Then("Se verifica el codigo de respuesta devuelto")
	public void seVerificaElCodigoDeRespuestaDevuelto() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

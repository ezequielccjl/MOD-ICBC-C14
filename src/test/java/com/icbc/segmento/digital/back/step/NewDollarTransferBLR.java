package com.icbc.segmento.digital.back.step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import com.icbc.segmento.digital.util.Link;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.NewDollarTransferInput;
import com.ebanking.retail.model.RequestNewDollarTransferInput;

public class NewDollarTransferBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("preparamos las especificaciones necesarias del metodo newDollarTransferBLR")
	public void preparamosLasEspecificacionesNecesariasDelMetodoNewDollarTransferBLR() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEW_DOLLAR_TRANSFER_BLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo newDollarTransferBLR con {string} {string} {string} {string} {string} {string} {string}")
	public void llamamosAlMetodoNewDollarTransferBLRCon(String channel, String transactionId, String cuentao, String cuentad, String moneda, String monto, String resultCode) {
	    
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		NewDollarTransferInput data = new NewDollarTransferInput()
				.cuentao(cuentao)
				.cuentad(cuentad)
				.moneda(moneda)
				.monto(monto);
		
		RequestNewDollarTransferInput request = (RequestNewDollarTransferInput) new RequestNewDollarTransferInput()
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
					body("header.resultCode", equalTo(resultCode)).
//					body("data.accounts[0].productType.code", equalTo("01")).
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
		
	}

	@Then("validamos el code que nos trajo la respuesta del metodo newDollarTransferBLR")
	public void validamosElCodeQueNosTrajoLaRespuestaDelMetodoNewDollarTransferBLR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

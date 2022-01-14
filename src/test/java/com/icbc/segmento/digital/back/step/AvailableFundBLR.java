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
import com.ebanking.retail.model.CanceledProductsInput;
import com.ebanking.retail.model.RequestCanceledProductsInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class AvailableFundBLR {
	
	private static RequestSpecification requestSpec;
	private static Response response;

	@Given("Se preparan las especificaciones requeridas para el metodo availableFundBLR")
	public void sePreparanLasEspecificacionesRequeridasParaElMetodoAvailableFundBLR() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.AVAILABLE_FUND_BLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Realiza la consulta con los datos a availableFundBLR")
	public void realizaLaConsultaConLosDatosAAvailableFundBLR() {
		
		String request = "{\r\n" + 
				"    \"header\": {\r\n" + 
				"        \"caller\": {\r\n" + 
				"            \"system\": \"retail\",\r\n" + 
				"            \"name\": \"com.midd.test.service.AccountsService\",\r\n" + 
				"            \"operation\": \"listAccounts\",\r\n" + 
				"            \"version\": \"1.0.4\",\r\n" + 
				"            \"ip\": \"10.11.12.13\",\r\n" + 
				"            \"port\": 28080,\r\n" + 
				"            \"layer\": \"service\",\r\n" + 
				"            \"index\": 2,\r\n" + 
				"            \"latency\": 247\r\n" + 
				"        },\r\n" + 
				"        \"channel\": \"PRE\",\r\n" + 
				"        \"groupId\": \"20000000001\",\r\n" + 
				"        \"password\": \"xxx\",\r\n" + 
				"        \"remoteHost\": \"10.11.12.13\",\r\n" + 
				"        \"serviceName\": \"clientData\",\r\n" + 
				"        \"sessionId\": \"8a33ff49-64adce33-0164-add58e7b-9876\",\r\n" + 
				"        \"transactionId\": \"8a33ff49-64adce33-0164-add58e7b-0032\",\r\n" + 
				"        \"taskId\": \"0123456789\",\r\n" + 
				"        \"userId\": \"preuser\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		response =		
				given().
					spec(requestSpec).
					body(request).
				when().
					post().
				then().
					body("header.resultCode", equalTo("ok")).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("Se verifica el codigo de respuesta devuelto de availableFundBLR")
	public void seVerificaElCodigoDeRespuestaDevueltoDeAvailableFundBLR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

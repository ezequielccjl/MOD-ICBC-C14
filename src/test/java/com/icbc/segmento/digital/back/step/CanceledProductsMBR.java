package com.icbc.segmento.digital.back.step;


import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelCanceledProductsInput;
import com.ebanking.retail.model.ChannelDeleteExtractionInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.ChannelProductType;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.LoginSessionInput;
import com.ebanking.retail.model.ProductListInput;
import com.ebanking.retail.model.RequestChannelCanceledProductsInput;
import com.ebanking.retail.model.RequestChannelDeleteExtractionInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.ebanking.retail.model.RequestLoginSessionInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions()
public class CanceledProductsMBR {
	
	private static String hzSessionId;
	private static Response listProductResponse;

	@Given("Se realiza un login exitoso con {string} {string} {string}")
	public void seRealizaUnLoginExitosoCon(String user, String pass, String deviceId) {
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	    
	}

	@When("Realiza la consulta canceledProductsMBR con {string} {string} {string}")
	public void realizaLaConsultaCanceledProductsMBRCon(String channel, String transactionId, String clientNumber) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.CANCELEDPRODUCTSMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
		List<ChannelProductType> codeList = new ArrayList<ChannelProductType>();
		codeList.add(new ChannelProductType().code("87"));
		
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.transactionId(transactionId);
		
		ChannelCanceledProductsInput data = new ChannelCanceledProductsInput()
				.clientNumber(clientNumber)
				.filterChannelProductTypesData(codeList);
																 	
		RequestChannelCanceledProductsInput requestChannelProductListInput = (RequestChannelCanceledProductsInput) (new RequestChannelCanceledProductsInput())
				.data(data)
				.header(header);		
		
		listProductResponse =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					header("Cookie", hzSessionId).
					body(requestChannelProductListInput).
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

	@Then("Se verifica el codigo de respuesta que devuelve")
	public void seVerificaElCodigoDeRespuestaQueDevuelve() {
		assertEquals("El status code es incorrecto " + listProductResponse.getStatusCode() , 200, listProductResponse.getStatusCode());    	

	}
	
}

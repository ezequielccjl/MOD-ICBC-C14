package com.icbc.segmento.digital.back.step;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelCardExpensesRecentInput;
import com.ebanking.retail.model.ChannelLimitTransactionInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelCardExpensesRecentInput;
import com.ebanking.retail.model.RequestChannelLimitTransactionInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.Utilities;

@RunWith(Cucumber.class)
@CucumberOptions()
public class CheckLimitTransactionMBR {
	
	private static Response response;
	private static String hzSessionId;

	@Given("se prepara el login para el metodo checkLimitTransactionMBR con los datos {string} {string} {string}")
	public void sePreparaElLoginParaElMetodoCheckLimitTransactionMBRConLosDatos(String user, String pass, String deviceId) {
		  LoginBE login = new LoginBE(user, pass, deviceId);
		    Response loginResponse = login.getResponse();
		    hzSessionId = login.getHzSessionId(loginResponse.asString());
		    
			assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	}

	@When("se ejecuta el metodo checkLimitTransactionMBR con los datos {string} {string} {string} {string} {string}")
	public void seEjecutaElMetodoCheckLimitTransactionMBRConLosDatos(String transactionId, String channel, String dateOperMin, String dateOperMax, String currency) {
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.CHECK_LIMIT_TRANSACTION_MBR)
				.setRelaxedHTTPSValidation()
				.build();
    	
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId)
				.channel(channel);
			
		long fecha = Long.parseLong(dateOperMin.replace("-", ""));
		Date dateOperMin2 = new Date(fecha);

		long fecha2 = Long.parseLong(dateOperMax.replace("-", ""));
		Date dateOperMax2 = new Date(fecha2);
		
		ChannelLimitTransactionInput data = new ChannelLimitTransactionInput()
				.dateOperMin(dateOperMin2)
				.dateOperMax(dateOperMax2)
				.currency(currency);
		
		RequestChannelLimitTransactionInput request = (RequestChannelLimitTransactionInput) new RequestChannelLimitTransactionInput()
				.data(data)
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					header("Cookie", hzSessionId).
					body(request).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("se chequea la respuesta esperada")
	public void seChequeaLaRespuestaEsperada() {
		assertEquals("El status code es incorrecto" + response.getStatusCode() , 200, response.getStatusCode());
	}

	
}

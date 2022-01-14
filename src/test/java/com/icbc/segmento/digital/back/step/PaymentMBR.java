package com.icbc.segmento.digital.back.step;

import static org.junit.Assert.assertEquals;

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

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelPaymentInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelPaymentInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class PaymentMBR {

	private static Response response;
	private static String hzSessionId;
	
	@Given("Se loguea con {string} {string} {string} correctamente para paymentMBR")
	public void seLogueaConCorrectamenteParaPaymentMBR(String user, String pass, String deviceId) {
	    
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response responseLogin = login.getResponse();
		hzSessionId = login.getHzSessionId(responseLogin.asString());
		
		assertEquals("El status code es incorrecto" + responseLogin.getStatusCode() , 200, responseLogin.getStatusCode());
		
	}

	@When("Se realiza la consulta al metodo getClientDataMBR")
	public void seRealizaLaConsultaAlMetodoGetClientDataMBR() {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEWGETCLIENTDATA)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		Request request = new Request();
		
		Response responseGetClientData =		
				given().
					spec(requestSpec).
					body(request).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
		
		assertEquals("El status code es incorrecto " + responseGetClientData.getStatusCode() , 200, responseGetClientData.getStatusCode());    	
	}

	@When("Se realiza la consulta al metodo listProductsMBR con {string} {string} {string} {string} {string} {string} {string} {string}")
	public void seRealizaLaConsultaAlMetodoListProductsMBRCon(String code1, String code2, String code3, String code4, String code5, String code6, String code7, String code8) {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LIST_PRODUCTS_MBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		List<Filter> listCode = new ArrayList<Filter>();
		listCode.add(new Filter().code(code1));
		listCode.add(new Filter().code(code2));
		listCode.add(new Filter().code(code3));
		listCode.add(new Filter().code(code4));
		listCode.add(new Filter().code(code5));
		listCode.add(new Filter().code(code6));
		listCode.add(new Filter().code(code7));
		listCode.add(new Filter().code(code8));
			
		ChannelProductListInputMbr channelProductListInput = new ChannelProductListInputMbr()
				.filter(listCode);
																 	
		RequestChannelProductListInputMbr requestChannelProductListInput = (RequestChannelProductListInputMbr) (new RequestChannelProductListInputMbr())
				.data(channelProductListInput);		
		
		Response responseListProducts =		
				given().
					spec(requestSpec).
					body(requestChannelProductListInput).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
		
		assertEquals("El status code es incorrecto " + responseListProducts.getStatusCode() , 200, responseListProducts.getStatusCode());    	
	
	}

	@When("Se realiza la consulta al metodo paymentMBR {string} {string} {string} {string} {string} {string}")
	public void seRealizaLaConsultaAlMetodoPaymentMBR(String transactionId, String accountProductIndex, String cardIndex, String confirmPaymentIndicator, String currencyCode, String amount) {
		RequestSpecification requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.PAYMENT_MBR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader header = new RequestHeader()
				.transactionId(transactionId);
		
		ChannelPaymentInput data = new ChannelPaymentInput()
				.accountProductIndex(Integer.parseInt(accountProductIndex))
				.cardIndex(Integer.parseInt(cardIndex))
				.confirmPaymentIndicator(Boolean.parseBoolean(confirmPaymentIndicator))
				.currencyCode(currencyCode)
				.amount(Double.parseDouble(amount));
		
		RequestChannelPaymentInput request = (RequestChannelPaymentInput) new RequestChannelPaymentInput()
				.data(data)
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
					body(request).
					header("Cookie", hzSessionId).
				when().
					post().
				then().
					log().all().
					extract().
					response();	
	}

	@Then("Se verifica la response code devuelto de paymentMBR")
	public void seVerificaLaResponseCodeDevueltoDePaymentMBR() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());  
		//200 ok
		//403 forbidden
		//404 not found
		
	}
	
}

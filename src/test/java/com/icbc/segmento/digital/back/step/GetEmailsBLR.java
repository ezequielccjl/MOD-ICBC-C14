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
import com.ebanking.model.ServiceInstance;
import com.ebanking.retail.model.AvailableCardInput;
import com.ebanking.retail.model.GetEmailsInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.RequestAvailableCardInput;
import com.ebanking.retail.model.RequestGetEmailsInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.icbc.segmento.digital.util.Link;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetEmailsBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("Se preparan las especificaciones para getEmailsBLR")
	public void sePreparanLasEspecificacionesParaGetEmailsBLR() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GET_EMAILS_BLR)
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("Realiza la consulta al metodo getEmailsBLR con {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void realizaLaConsultaAlMetodoGetEmailsBLRCon(String system, String name, String operation, String version, String ip, String port, String layer, String index, String latency, String channel, String groupId, String password, String remoteHost, String serviceName, String sessionId, String transactionId, String userId, String numClie, String resultCode) {
	    
		ServiceInstance caller = new ServiceInstance()
				.system(system)
				.name(name)
				.operation(operation)
				.version(version)
				.ip(ip)
				.port(port)
				.layer(layer)
				.index(Integer.parseInt(index))
				.latency(Integer.parseInt(latency));
		
		RequestHeader header = new RequestHeader()
				.channel(channel)
				.groupId(groupId)
				.password(password)
				.remoteHost(remoteHost)
				.serviceName(serviceName)
				.sessionId(sessionId)
				.transactionId(transactionId)
				.userId(userId)
				.caller(caller);
		
		GetEmailsInput data = new GetEmailsInput()
				.numClie(numClie);
		
		RequestGetEmailsInput request = (RequestGetEmailsInput) new RequestGetEmailsInput()
				.data(data)
				.header(header);
		
		response =		
				given().
					spec(requestSpec).
//					contentType(ContentType.JSON).
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

	@Then("Verifico el codigo devuelto por el metodo")
	public void verificoElCodigoDevueltoPorElMetodo() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

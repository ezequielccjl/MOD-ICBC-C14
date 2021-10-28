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

import com.ebanking.model.RequestHeader;
import com.ebanking.model.ServiceInstance;
import com.ebanking.retail.model.ChannelSecondFactorInput;
import com.ebanking.retail.model.EditContactInput;
import com.ebanking.retail.model.RequestChannelSecondFactorInput;
import com.ebanking.retail.model.RequestEditContactInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class GetSecondFactorMBR {

	private static String hzSessionId;
	private static Response response;
	
	@Given("Realiza login con {string} {string} {string}")
	public void realizaLoginCon(String user, String pass, String deviceId) {
	    
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
		
	}

	@When("Envio {string} {string} {string} {string} {string} {int} {string} {int} {int} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} al metodo getSecondFactorMBR")
	public void envioAlMetodoGetSecondFactorMBR(String system, String name, String operation, String version, String ip, Integer port, String layer, Integer index, Integer latency, String channel, String groupId, String password, String remoteHost, String serviceName, String sessionId, String transactionId, String taskId, String userId, String generatorIndicator) {
	    
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.GETSECONDFACTORMBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		ServiceInstance caller = new ServiceInstance()
				.system(system)
				.name(name)
				.operation(operation)
				.version(version)
				.ip(ip)
				.port(port.toString())
				.layer(layer)
				.index(index)
				.latency(latency);
		
		RequestHeader rh = new RequestHeader()
				.caller(caller)
				.channel(channel)
				.groupId(groupId)
				.password(password)
				.remoteHost(remoteHost)
				.serviceName(serviceName)
				.sessionId(sessionId)
				.transactionId(transactionId)
				.taskId(taskId)
				.userId(userId);
		
		ChannelSecondFactorInput channelSecondFactorInput = new ChannelSecondFactorInput()
				.generatorIndicator(Boolean.valueOf(generatorIndicator));
		
		RequestChannelSecondFactorInput request = (RequestChannelSecondFactorInput) new RequestChannelSecondFactorInput()
				.data(channelSecondFactorInput)
				.header(rh);
		
		System.out.println(request);
		
		response =		
			given().
				spec(requestSpec).
				contentType(ContentType.JSON).
				header("Cookie", hzSessionId).
				body(request).
			when().
				post().
			then().
	//			body("header.resultCode", equalTo("ok")).
	//			body("data.accounts[0].productType.code", equalTo("01")).
				log().all().
	//			body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
				extract().
				response();	
		
	}

	@Then("Verifico el codigo de status")
	public void verificoElCodigoDeStatus() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

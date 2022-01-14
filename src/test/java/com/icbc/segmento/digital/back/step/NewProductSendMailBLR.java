package com.icbc.segmento.digital.back.step;

import com.icbc.segmento.digital.util.Link;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

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

import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.AamrGenerarSegundoFactorInput;
import com.ebanking.retail.model.GetSecondFactorInput;
import com.ebanking.retail.model.MailAddress;
import com.ebanking.retail.model.NewProductSendMailInput;
import com.ebanking.retail.model.RequestAamrGenerarSegundoFactorInput;
import com.ebanking.retail.model.RequestGetSecondFactorInput;
import com.ebanking.retail.model.RequestNewProductSendMailInput;
import com.ebanking.retail.model.SendMailBc;
import com.ebanking.retail.model.SendMailCc;
import com.ebanking.retail.model.SendMailTo;
import com.ebanking.retail.model.TemplateMessage;
import com.icbc.segmento.digital.util.Link;

public class NewProductSendMailBLR {

	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("preparamos las especificaciones necesarias del metodo")
	public void preparamosLasEspecificacionesNecesariasDelMetodo() {
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.NEW_PRODUCT_SEND_MAIL_BLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}

	@When("llamamos al metodo newProductSendMailBLR con {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void llamamosAlMetodoNewProductSendMailBLRCon(String channel, String transactionId, String replyName, String formatCode, String mailId, String subjectDescription, String replyEmailName, String fromName, String fromAddressEmail, String toName, String toAddressEmail, String ccName, String ccAddressEmail, String bcName, String bcAddressEmail, String requestDate, String documentNumber, String clientName, String productName, String templateName, String clientSurName, String incomeNumber, String subProductName, String phoneNumber, String email, String messageCode) {
		
//		RequestHeader header = new RequestHeader()
//				.channel(channel)
//				.transactionId(transactionId);
//		
//		MailAddress fromMail = new MailAddress()
//				.addressEmail(fromAddressEmail)
//				.name(fromName);
//		
//		SendMailTo toMail = new SendMailTo()
//				.mailAddressValue(toAddressEmail)
//				.mailName(toName);
//		
//		SendMailCc ccMail = new SendMailCc()
//				.emailAddressValue(ccAddressEmail)
//				.mailName(ccName);
//		
//		SendMailBc bcMail = new SendMailBc()
//				.emailAddressValue(bcAddressEmail)
//				.emailName(bcName);
//		
//		long fecha = Long.parseLong(requestDate.replace("-", ""));
//		Date parsedRequestDate = new Date(fecha);
//		
//		TemplateMessage templateMessage = new TemplateMessage()
//				.requestDate(parsedRequestDate)
//				.documentNumber(documentNumber)
//				.clientName(clientName)
//				.productName(productName)
//				.templateName(templateName)
//				.clientSurName(clientSurName)
//				.incomeNumber(incomeNumber)
//				.subProductName(subProductName)
//				.phoneNumber(phoneNumber)
//				.email(email);
//		
//		NewProductSendMailInput data = new NewProductSendMailInput()
//				.fromMailAddresses((List<MailAddress>) fromMail)
//				.toMailAddresses((List<MailAddress>) toMail)
//				.ccMailAddresses((List<MailAddress>) ccMail)
//				.bcMailAddresses((List<MailAddress>) bcMail)
//				.templateMessage(templateMessage)
//				.replyName(replyName)
//				.formatCode(formatCode)
//				.mailId(mailId)
//				.subjectDescription(subjectDescription)
//				.replyEmailName(replyEmailName);
//		
//		RequestNewProductSendMailInput request = (RequestNewProductSendMailInput) new RequestNewProductSendMailInput()
//				.data(data)
//				.header(header);
		
		String requestHardCodeado = "{\r\n" + 
				"    \"header\": {\r\n" + 
				"        \"channel\": \"mbr\",\r\n" + 
				"        \"transactionId\": \"a34f8c43-eda1-4fc4-a11e-248901a04c72\"\r\n" + 
				"    },\r\n" + 
				"    \"data\": {\r\n" + 
				"        \"replyName\": \"\",\r\n" + 
				"        \"formatCode\": \"html\",\r\n" + 
				"        \"mailId\": \"" + mailId + "\",\r\n" + 
				"        \"subjectDescription\": \"ICBC Mobile Banking  / Solicitud de Nuevos Productos - 11299956\",\r\n" + 
				"        \"replyEmailName\": \"\",\r\n" + 
				"        \"fromMailAddresses\": [\r\n" + 
				"            {\r\n" + 
				"                \"name\": \"ICBC Mobile Banking\",\r\n" + 
				"                \"addressEmail\": \"contactenos@icbc.com.ar\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"toMailAddresses\": [\r\n" + 
				"            {\r\n" + 
				"                \"name\": \"Oficial productos\",\r\n" + 
				"                \"addressEmail\": \"daiana.ruiz@icbc.com.ar\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"ccMailAddresses\": [\r\n" + 
				"            {\r\n" + 
				"                \"name\": \"Matias\",\r\n" + 
				"                \"addressEmail\": \"sabrina.quinarivera@icbc.com.ar\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"name\": \"Miguel\",\r\n" + 
				"                \"addressEmail\": \"rodrigo.jacomen@icbc.com.ar\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"bcMailAddresses\": [\r\n" + 
				"            {\r\n" + 
				"                \"name\": \"Sebastian\",\r\n" + 
				"                \"addressEmail\": \"david.vera@icbc.com.ar\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"templateMessage\": {\r\n" + 
				"            \"requestDate\": \"2021-09-20\",\r\n" + 
				"            \"documentNumber\": \"11299956\",\r\n" + 
				"            \"clientName\": \"ACOELCU DAZEL\",\r\n" + 
				"            \"productName\": \"Tarjetas\",\r\n" + 
				"            \"templateName\": \"mbr_solicitud_productos\",\r\n" + 
				"            \"clientSurName\": \"DEBERRU\",\r\n" + 
				"            \"incomeNumber\": \"\",\r\n" + 
				"            \"subProductName\": \"MasterCard Titular\",\r\n" + 
				"            \"phoneNumber\": \"1122334455\",\r\n" + 
				"            \"email\": \"cliente@mail.com\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		//				"        \"mailId\": \"" + mailId + "\",\r\n" + 
		response =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					body(requestHardCodeado).
				when().
					log().all().
					post().
				then().
					log().all().
					body("header.messageCode", equalTo(messageCode)).
//					body("data.accounts[0].productType.code", equalTo("01")).
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}

	@Then("validamos el code que nos trajo la respuesta")
	public void validamosElCodeQueNosTrajoLaRespuesta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());    	
	}
	
}

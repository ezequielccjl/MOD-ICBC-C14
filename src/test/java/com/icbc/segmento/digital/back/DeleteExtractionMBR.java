package com.icbc.segmento.digital.back;

import java.sql.Date;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelDeleteExtractionInput;
import com.ebanking.retail.model.RequestChannelDeleteExtractionInput;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteExtractionMBR {
	
	public static void main(String[] args) {
	
		Response resp;
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri("https://mbr-channel-cardless-extraction-1-0-dev.apps.ocp4-tst.intranet.local/channel-cardless-extraction/1.0/delete-extraction")
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	
		long fecha = 1633662000000L;
		double amount = 1000d;
		
		Date fechafecha = new Date (fecha);
		
		RequestHeader header = (new RequestHeader())
				.transactionId("4a3831d1-8216-4584-99d4-ca3b418254bd");
				
		
		ChannelDeleteExtractionInput deleteExtraction = (new ChannelDeleteExtractionInput())
				.senderAccountNumber("08250111104488")
				.senderAccountCode("01")
				.mandateId("9050")
				.dueDate(fechafecha)
				.amount(amount)
				.beneficiaryDocumentCode("12345678")
				.beneficiaryDocumentNumber("04");
		
		System.out.println(deleteExtraction);
		
		RequestChannelDeleteExtractionInput request = (RequestChannelDeleteExtractionInput) (new RequestChannelDeleteExtractionInput())
				.data(deleteExtraction).header(header);
		
		resp = 
				given().
				relaxedHTTPSValidation().
				spec(requestSpec).
				body(request).
			when().
				post().
			then().
				//body("header.resultCode", equalTo("ok")).
				//body(matchesJsonSchemaInClasspath("schemas/responseGetVirtualCard.json")).
				log().all().
				extract().
				response();
		
		
		assertEquals("El status code es incorrecto" + resp.getStatusCode() , 200, resp.getStatusCode());
		
	}

}

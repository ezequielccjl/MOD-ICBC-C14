package com.icbc.segmento.digital.util;

public class DeleteContactAux {

	public String getBody(String transactionId, String channel, String documentNumber, String documentCode, String destinationCbuCvuAlias) {

		return "{\r\n" + 
    			"    \"header\": {\r\n" + 
    			"        \"transactionId\": \""+transactionId+"\",\r\n" + 
    			"        \"channel\": \""+channel+"\"\r\n" + 
    			"    },\r\n" + 
    			"    \"data\": {\r\n" + 
    			"        \"documentNumber\": \""+documentNumber+"\",\r\n" + 
    			"        \"documentCode\": \""+documentCode+"\",\r\n" + 
    			"        \r\n" + 
    			"        \"destinationCbuCvuAlias\": \""+destinationCbuCvuAlias+"\"\r\n" + 
    			"    }\r\n" + 
    			"}";
	}
	
}

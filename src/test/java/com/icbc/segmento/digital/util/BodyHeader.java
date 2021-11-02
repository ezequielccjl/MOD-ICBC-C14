package com.icbc.segmento.digital.util;

public class BodyHeader {

	public String getHeaderWithTransactionId(String transactionId) {
		return "{\r\n" + 
				"    \"header\": {\r\n" + 
				"        \"transactionId\": \"" + transactionId + "\"\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
}

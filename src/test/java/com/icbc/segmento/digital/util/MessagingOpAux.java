package com.icbc.segmento.digital.util;

public class MessagingOpAux {

	public String getBodyWithChannelAndShow(String channel, String show) {
		return "{\r\n" + 
				"  \"header\": {\r\n" + 
				"    \"channel\": \"" + channel + "\"\r\n" + 
				"  },\r\n" + 
				"  \"data\": {\r\n" + 
				"    \"show\": \"" + show + "\"\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
}

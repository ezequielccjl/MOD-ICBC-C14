package com.icbc.segmento.digital.util.url;

public enum Environment {
	FBD("fbd"), QAT("qat");
	
	private String text;

	private Environment(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

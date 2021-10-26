package com.icbc.segmento.digital.front.step;

public class PageModel extends BasePage{
	
	//locators
	private String inputUsuarioXPath = "//*[@id=\"text-field_16345613546757462\"]";
	private String inputContraseñaXPath = "//*[@id=\"text-field_163456135467691789\"]";
	private String btnIngresar = "//*[@id=\"flex_163456135467798587\"]/ly-button/button";
	
	private String btnPagar = "//*[@id=\"flex_163458081774633768\"]/ly-button[1]/button";
	private String palomita = "//*[@id=\"single-spa-application:@home-mf\"]/app-root/ly-app-container/div/app-card-payment-form-cont/ly-layout-container/div/div/app-card-payment-form-data/form/ly-form-field[1]/div/ly-select/div/div/ly-drop-frame/div/i";
	private String inputPagar = "//*[@id=\"text-field_163458086020331201\"]";
	private String btnPagarFinal = "//*[@id=\"flex_163458157279110\"]/ly-button[2]/button";
	
	//XPATH HARDCODEADOS
	private String liCuentaCorriente ="//*[@id=\"Sliding_163458086021330428\"]/div[2]/div/ly-list/ul/ly-list-item[3]/li";
	private String liPesos = "//*[@id=\"Sliding_163458086021429484\"]/div[2]/div/ly-list/ul/ly-list-item[1]/li/ly-select-simple-option";
	
	
	
	
	public PageModel() {
		
		super(driver);
		
	}

	public void navigateToDEV() {
		navigateTo("www.google.com");
	}
	
	public void ingresarUsuario(String usuario) {
		write(inputUsuarioXPath, usuario);
	}
	
	public void ingresarContraseña(String contraseña) {
		write(inputContraseñaXPath, contraseña);
	}
	
	public void clickIngresar() {
		clickElement(btnIngresar);
	}
}

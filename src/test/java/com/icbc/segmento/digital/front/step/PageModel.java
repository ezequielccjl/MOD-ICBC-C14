package com.icbc.segmento.digital.front.step;

import com.icbc.segmento.digital.front.pom.BasePage;

public class PageModel extends BasePage{
	
	//locators
	private String inputUsuarioXPath = "//*[@id=\"text-field_16345613546757462\"]";
	private String inputContraseñaXPath = "//*[@id=\"text-field_163456135467691789\"]";
	private String btnIngresar = "//*[@id=\"flex_163456135467798587\"]/ly-button/button";
	
	public PageModel() {
		super(driver);
	}

	public void navigateToDEV() {
		navigateTo("https://mbrdev.intranet.local/mbr/dev/shell-mf/#/login");
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

package com.icbc.segmento.digital.front.step;

import org.openqa.selenium.WebDriver;

import com.icbc.segmento.digital.front.pom.BasePage;

public class PageModel extends BasePage{
	
	String barraBusqueda = "//input[@class='gLFyf gsfi']";
	String botonBusqueda = "//input[contains(text(), 'Buscar con Google')]";
	String botonFacebook = "//h3[contains(text(),'Facebook - Inicia sesión o regístrate')]";

	public PageModel() {
		super(driver);
	}
	public static void navegarGoogle() {
		navigateTo("https://www.google.com/");
	}
	
	public void escribirBusqueda(String texto) {
		write(barraBusqueda, texto);
	}
	
	public void buscarBarraBusqueda() {
		find(barraBusqueda);
	}
	
	public void clickBuscar() {
		find(barraBusqueda).submit();
	}
	
	public void clickFacebook() {
		clickElement(botonFacebook);
	}
	

}

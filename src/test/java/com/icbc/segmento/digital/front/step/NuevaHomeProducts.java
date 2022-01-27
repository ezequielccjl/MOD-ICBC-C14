package com.icbc.segmento.digital.front.step;

import static org.junit.Assert.assertTrue;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NuevaHomeProducts {
	
	PageModel pm = new PageModel();
	
	// NuevaHome-SaludoAlUsuario
	@Then("Reviso que aparezca el saludo al usuario")
	public void revisoQueAparezcaElSaludoAlUsuario() {
		Boolean apareceSaludo = pm.elementoDisponible("//h3[contains(text(),'�Hola')]");
        System.out.println(apareceSaludo);
       	assertTrue(apareceSaludo);

	}
	
	// NuevaHome-OcultarSaldos
	@When("Presiono en ocultar saldos")
	public void presionoEnOcultarSaldos() {
		
		pm.clickElement("//p[contains(text(), 'Ocultar saldos')]");
	    
	}

	@Then("Valido que el saldo este oculto")
	public void validoQueElSaldoEsteOculto() {
		Boolean apareceSaldoOculto = pm.elementoDisponible("//div[contains(text(),'$***')]");
        System.out.println(apareceSaldoOculto);
       	assertTrue(apareceSaldoOculto);
	}
	
	// NuevaHome-NuevaBotonera
	@Then("Verifico que se encuentre nueva botonera")
	public void verificoQueSeEncuentreNuevaBotonera() {
		
		Boolean aparecePagarQR = pm.elementoDisponible("//div[contains(text(),' Pagar con QR ')]");
        System.out.println(aparecePagarQR);
       	assertTrue(aparecePagarQR);
       	
       	Boolean apareceTransferir = pm.elementoDisponible("//div[contains(text(),' Transferir ')]");
        System.out.println(apareceTransferir);
       	assertTrue(apareceTransferir);
       	
       	Boolean aparecePagarServicios = pm.elementoDisponible("//div[contains(text(),' Pagar Servicios ')]");
        System.out.println(aparecePagarServicios);
       	assertTrue(aparecePagarServicios);
       	
       	Boolean apareceNuevoProducto = pm.elementoDisponible("//div[contains(text(),' Nuevo Producto ')]");
        System.out.println(apareceNuevoProducto);
       	assertTrue(apareceNuevoProducto);
       	
	}

	// NuevaHome-BotonCBUAlias
	@Then("Verifico funcionamiento de boton CBU Alias")
	public void verificoFuncionamientoDeBotonCBUAlias() {
		pm.implicitWait();
		pm.esperarElemento("//h3[contains(text(),'�Hola')]");
		pm.implicitWait();
	    pm.clickElement("//button[contains (text(), 'CBU-ALIAS-QR')]");
	    pm.implicitWait();
	    assertTrue(pm.elementoDisponible("//li[contains(text(), 'Consulta de CBU - Alias')]"));
	}
	
	// NuevaHome-BotonNuevoProducto
	@Then("Verifico que boton Nuevo Producto se encuentre en pantalla")
	public void verificoQueBotonNuevoProductoSeEncuentreEnPantalla() {
	    pm.implicitWait();
	    assertTrue(pm.elementoDisponible("//div[contains(text(), 'Nuevo Producto')]"));
	}
	
	// NuevaHome-BotonNuevoProductoFuncional
	@Then("Verifico que boton Nuevo Producto este funcional")
	public void verificoQueBotonNuevoProductoEsteFuncional() {
		pm.implicitWait();
		pm.clickElement("//div[contains(text(), 'Nuevo Producto')]");
		pm.implicitWait();
	    assertTrue(pm.elementoDisponible("//h3[contains(text(), 'Solicitud de un nuevo producto')]"));
	    
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Cuentas')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Tarjetas')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Inversiones')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Pr�stamos')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Cr�dito a Tasa Cero')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Seguros')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Paquetes')]"));
	    
	}

	// NuevaHome-BarraInferiorDisponible
	@Then("Valido que aparezca barra inferior")
	public void validoQueAparezcaBarraInferior() {
	    assertTrue(pm.elementoDisponible("//div[@class='ly-footer-bar']"));
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'Inversiones')]"));
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'Pagos')]"));
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'Inicio')]"));
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'MODO')]"));
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'M�s')]"));
	}
	
	// NuevaHome-BotonInversiones
	@Then("Valido que funcione de boton Inversiones")
	public void validoQueFuncioneDeBotonInversiones() {
		pm.jseClickIntercepted("//span[contains(text(), 'Inversiones')]");
		assertTrue(pm.elementoDisponible("//h1[contains(text(), 'Inversiones')]"));
	}

	
	// NuevaHome-BotonPagos
	@Then("Valido que funcione de boton Pagos")
	public void validoQueFuncioneDeBotonPagos() {
		pm.jseClickIntercepted("//span[contains(text(), 'Pagos')]");
		assertTrue(pm.elementoDisponible("//span[contains(text(), 'Pagos')]"));
		assertTrue(pm.elementoDisponible("//span[contains(text(), 'DEBIN')]"));
	}

	// NuevaHome-BotonMODO
	@Then("Valido que funcione de boton MODO")
	public void validoQueFuncioneDeBotonMODO() {
		pm.jseClickIntercepted("//span[contains(text(), 'MODO')]");
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Lleg� MODO a tu APP ICBC')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Ya no necesit�s tu billetera')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Pag� con QR')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Envi� y recib� plata')]"));
		
	}
	
	// NuevaHome-MenuHamburguesa
	@Then("Valido que funcione menu hamburguesa")
	public void validoQueFuncioneMenuHamburguesa() {
		pm.jseClickIntercepted("//span[contains(text(), 'M�s')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Extracci�n sin tarjeta')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Gesti�n de productos')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'CompraVenta de U$$')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Resumenes')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Contacto')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Recomendar')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Perfil')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Ayuda')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Cerrar sesi�n')]"));
	}
	
	// NuevaHome-BotonExtraccionSinTarjeta
	@Then("Valido que me redirija a pantalla Extraccion sin tarjeta")
	public void validoQueMeRedirijaAPantallaExtraccionSinTarjeta() {
		pm.jseClickIntercepted("//span[contains(text(), 'M�s')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Extracci�n sin tarjeta')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h1[contains (text(), 'Extracci�n sin tarjeta')]"));
		assertTrue(pm.elementoDisponible("//h2[contains (text(), '�rdenes de extracci�n')]"));
	}



}

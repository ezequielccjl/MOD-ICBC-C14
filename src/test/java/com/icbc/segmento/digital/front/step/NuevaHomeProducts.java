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
		Boolean apareceSaludo = pm.elementoDisponible("//h3[contains(text(),'¡Hola')]");
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
		pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
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
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Préstamos')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Crédito a Tasa Cero')]"));
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
	    assertTrue(pm.elementoDisponible("//span[contains(text(), 'Más')]"));
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
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Llegó MODO a tu APP ICBC')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Ya no necesitás tu billetera')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Pagá con QR')]"));
		assertTrue(pm.elementoDisponible("//div[contains(text(), 'Enviá y recibí plata')]"));
		
	}
	
	// NuevaHome-MenuHamburguesa
	@Then("Valido que funcione menu hamburguesa")
	public void validoQueFuncioneMenuHamburguesa() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Extracción sin tarjeta')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Gestión de productos')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'CompraVenta de U$$')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Resumenes')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Contacto')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Recomendar')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Perfil')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Ayuda')]"));
		assertTrue(pm.elementoDisponible("//li[contains(text(), 'Cerrar sesión')]"));
	}
	
	// NuevaHome-BotonExtraccionSinTarjeta
	@Then("Valido que me redirija a pantalla Extraccion sin tarjeta")
	public void validoQueMeRedirijaAPantallaExtraccionSinTarjeta() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Extracción sin tarjeta')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h1[contains (text(), 'Extracción sin tarjeta')]"));
		assertTrue(pm.elementoDisponible("//h2[contains (text(), 'Órdenes de extracción')]"));
	}

//	NuevaHome-PantallaGestionDeProductos
	@Then("Valido que me redirija a Pantalla Gestion de Productos")
	public void validoQueMeRedirijaAPantallaGestionDeProductos() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Gestión de productos')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Solicitud de un nuevo producto')]"));
		assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Cuentas')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Tarjetas')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Inversiones')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Préstamos')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Crédito a Tasa Cero')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Seguros')]"));
	    assertTrue(pm.elementoDisponible("//strong[contains(text(), 'Paquetes')]"));
	}
	
//	NuevaHome-PantallaCompraVentaUSD ERROR POR SPINNER
	@Then("Valido que me redirija a Pantalla Compra Venta USD")
	public void validoQueMeRedirijaAPantallaCompraVentaUSD() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.clickCompraVenta("//li[contains(text(), 'CompraVenta de U$$')]");
		pm.esperarElemento("//h3[contains (text(), 'Compra / Venta de U$S')]");
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Compra / Venta de U$S')]"));
		assertTrue(pm.elementoDisponible("//div[contains (text(), 'Para realizar la operación de Compra / Venta de U$S se requiere una cuenta de distinta moneda para acreditar los fondos.')]"));
	}
	
//	NuevaHome-PantallaResumenes - DECIDIR SI AVANZAR EN LA PANTALLA
	@Then("Valido que me redirija a Pantalla Resumenes")
	public void validoQueMeRedirijaAPantallaResumenes() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Resumenes')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Resúmenes')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Tarjetas')]"));
	}
	
//	NuevaHome-PantallaContacto
	@Then("Valido que me redirija a Pantalla Contacto")
	public void validoQueMeRedirijaAPantallaContacto() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Contacto')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Teléfonos útiles')]"));
		assertTrue(pm.elementoDisponible("//h3[contains(text(),'Teléfonos útiles')]"));
		assertTrue(pm.elementoDisponible("//p[contains(text(),'Lunes a viernes de 8 a 20 hs y sábados y domingos de 10 a 16 hs')]"));
		assertTrue(pm.elementoDisponible("//a[contains(text(),'0810-555-9200')]"));
		assertTrue(pm.elementoDisponible("//a[contains(text(),'(54-11) 4820-9200')]"));
	}
	
//	NuevaHome-PantallaRecomendar
	@Then("Valido que me redirija a Pantalla Recomendar")
	public void validoQueMeRedirijaAPantallaRecomendar() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Recomendar')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Recomenda y Gana')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'E-mail')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Facebook')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Twitter')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Messenger')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Whatsapp')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Instagram')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Telegram')]"));
	}
	
//	NuevaHome-PantallaPerfil
	@Then("Valido que me redirija a Pantalla Perfil")
	public void validoQueMeRedirijaAPantallaPerfil() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Perfil')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//p[contains (text(), 'Hola,')]"));
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Cambio de clave de ICBC Access y Mobile Banking')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Cambiar la clave')]"));
	}
	
//	NuevaHome-PantallaAyuda DECIDIR SI HACER NAVEGACION
	@Then("Valido que me redirija a Pantalla Ayuda")
	public void validoQueMeRedirijaAPantallaAyuda() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Ayuda')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//h3[contains (text(), 'Ayuda')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Preguntas Frecuentes')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Terminos y condiciones')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Politicas de privacidad')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Seguridad')]"));
		assertTrue(pm.elementoDisponible("//span[contains (text(), 'Contactos')]"));
	}
	
//	NuevaHome-CerrarSesion
	@Then("Verifico que cierro sesion")
	public void verificoQueCierroSesion() {
		pm.jseClickIntercepted("//span[contains(text(), 'Más')]");
		pm.implicitWait();
		pm.jseClickIntercepted("//li[contains(text(), 'Cerrar sesión')]");
		pm.implicitWait();
		assertTrue(pm.elementoDisponible("//div[contains (text(), 'Ingresar con biometría')]"));
		assertTrue(pm.elementoDisponible("//button[contains (text(), 'Ingresar')]"));
		assertTrue(pm.elementoDisponible("//input[contains (@aria-label, 'Esté es un campo tipo Usuario')]"));
		assertTrue(pm.elementoDisponible("//input[contains (@aria-label, 'Esté es un campo tipo Clave')]"));
	}


}

package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NavegacionPagosMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	TouchAction action = new TouchAction(driver);

	//IOS
	String solapaPagosIOS = "//XCUIElementTypeButton[contains (@name, \"Pagos\")]";
	
	//SOLAPA PAGOS
	String opcionPagosIOS = "//XCUIElementTypeStaticText[@name=\"Pagos\"]";
	String descripcionOpcionPagosIOS = "(//XCUIElementTypeStaticText[@name=\"Pagá todos tus servicios, impuestos, tarjetas de crédito y recargá tu celular en línea, sin manejar dinero en efectivo.\"])[1]";
	String opcionDEBINIOS = "(//XCUIElementTypeStaticText[@name=\"DEBIN\"])[1]";
	String descripcionOpcionDEBINIOS = "(//XCUIElementTypeStaticText[@name=\"Generá cobros y autorizá pagos en forma inmediata.\"])[1]";

	//PANTALLA PAGOS
	String pagarCuentasIOS = "(//XCUIElementTypeButton[@name=\"Pagar cuentas Pagar cuentas\"])[1]";
	String comprobantesIOS = "(//XCUIElementTypeButton[@name=\"Comprobantes Comprobantes\"])[1]";
	String proximosVencimientosIOS = "(//XCUIElementTypeOther[@name=\"Próximos vencimientos\"])[1]";
	String btnPagarOtrasCuentasIOS = "(//XCUIElementTypeButton[@name=\"PAGAR OTRAS CUENTAS\"])[1]";
	String btnAtrasOpcionPagosIOS = "(//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	
	//PANTALLA PAGAR OTRAS CUENTAS
	String buscarPorEmpresaIOS = "(//XCUIElementTypeStaticText[@name=\"Buscar por empresa\"])[1]";
	String textFieldBuscarPorEmpresaIOS = "(//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Buscar por empresa\"])[1]";
	String rubrosIOS = "(//XCUIElementTypeStaticText[@name=\"Rubro\"])[1]";
	String btnAtrasPagarOtrasCuentasIOS = "(//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	
	//PANTALLA DEBIN
	String btnAtrasDEBINIOS = "(//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblDEBINIOS = "//XCUIElementTypeOther[@name=\"DEBIN\"]/XCUIElementTypeStaticText[@name=\"DEBIN\"]";
	String solapaAutorizacionesIOS = "//XCUIElementTypeStaticText[@name=\"Autorizaciones\"]";
	String solapaOrdenesIOS = "//XCUIElementTypeStaticText[@name=\"Órdenes\"]";
	String solapaAdhesionesIOS = "//XCUIElementTypeStaticText[@name=\"Adhesiones\"]";
	String solicitudesYDEBINesAPagarIOS = "//XCUIElementTypeStaticText[@name=\"Solicitudes y DEBINes a pagar\"]";
	String descripcionsolicitudesYDEBINesAPagarIOS = "//XCUIElementTypeStaticText[@name=\"Autorizá las solicitudes de DEBINes recurrentes para acordar pagos periódicos. Y realiza el pago inmediato de tus bienes y servicios.\"]";
	String solicitudesDeDEBINesRecurrentesIOS = "//XCUIElementTypeStaticText[@name=\"Solicitudes de DEBINes recurrentes\"]";
	String debinesAPagarIOS = "//XCUIElementTypeStaticText[@name=\"DEBINES a pagar\"]";
	String btnHistorialDeAutorizacionesIOS = "//XCUIElementTypeButton[@name=\"HISTORIAL DE AUTORIZACIONES\"]";
	
	//PANTALLA HISTORIAL DE AUTORIZACIONES
	String btnAtrasHistorialDeAutorizacionesIOS = "(//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblHistorialAutorizacionesIOS = "//XCUIElementTypeStaticText[@name=\"Historial autorizaciones\"]";
	String solapaPagosHistorialAutorizacionesIOS = "//XCUIElementTypeOther[@name=\"Bienvenido\"]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[@name=\"Pagos\"]";
	String solapaSolicitudesHistorialAutorizacionesIOS = "//XCUIElementTypeStaticText[@name=\"Solicitudes\"]";
	String descripcionHistorialAutorizacionesIOS = "//XCUIElementTypeStaticText[@name=\"Aquí podrés ver el historial de pagos de DEBINES recurrentes y órdenes de DEBIN\"]";

	//VARIABLES PARA SWIPE
	int swipeXInicial, swipeXFinal, swipeYInicial, swipeYFinal, cont = 0;
	
	@When("Voy a la solapa Pagos")
	public void irASolapaPagos() {
	    if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(solapaPagosIOS)).click();
	    }

	}
	
	@When("Voy a la opcion Pagos")
	public void irAOpcionPagos() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(opcionPagosIOS)).click();
	    }
	}
	
	@When("Valido que haya entrado en la opcion Pagos")
	public void validarEntradaAOpcionPagos() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			assertTrue(driver.findElement(By.xpath(pagarCuentasIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(comprobantesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(proximosVencimientosIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(btnPagarOtrasCuentasIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(btnAtrasOpcionPagosIOS)).isDisplayed());
	    }
	}
	
	@When("Vuelvo hacia atras en la opcion Pagos")
	public void volverHaciaAtrasEnOpcionPagos() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(btnAtrasOpcionPagosIOS)).click();
	    }
	}	
	
	@Then("Valido que este en la solapa Pagos")
	public void validarSolapaPagos() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
	    	assertTrue(driver.findElement(By.xpath(opcionPagosIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(descripcionOpcionPagosIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(opcionDEBINIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(descripcionOpcionDEBINIOS)).isDisplayed());
	    }
	}
	
	@When("Aprieto el boton pagar otras cuentas")
	public void apretarbtnPagarOtrasCuentas() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(btnPagarOtrasCuentasIOS)).click();
	    }
	}
	
	@When("Valido que entro en la opcion pagar otras cuentas")
	public void validarEntradaAPagarOtrasCuentas() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
	    	assertTrue(driver.findElement(By.xpath(buscarPorEmpresaIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(descripcionOpcionPagosIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(rubrosIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(btnAtrasPagarOtrasCuentasIOS)).isDisplayed());
	    }
	}
	
	@When("Vuelvo hacia atras en la opcion pagar otras cuentas")
	public void volverHaciaAtrasEnOpcionPagarOtrasCuentas() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(btnPagarOtrasCuentasIOS)).click();
	    }
	}
	
	@When("Voy a la opcion DEBIN")
	public void irAOpcionDEBIN() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(opcionDEBINIOS)).click();
	    }
	}
	
	@When("Valido que entro en la opcion DEBIN")
	public void validarEntradaADEBIN() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			assertTrue(driver.findElement(By.xpath(lblDEBINIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solapaAutorizacionesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solapaOrdenesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solapaAdhesionesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solicitudesYDEBINesAPagarIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(descripcionsolicitudesYDEBINesAPagarIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solicitudesDeDEBINesRecurrentesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(debinesAPagarIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(btnHistorialDeAutorizacionesIOS)).isDisplayed());
	    }
	}
		
	@When("Apreto el boton historial de autorizaciones")
	public void apretarBotonHistorialDeAutorizaciones() {
		String botonVisible = "";
		
		if (Hooks.esAndroid()) {
	    	
	    }else {
	    	swipeXInicial = driver.manage().window().getSize().width / 2;
	    	swipeXFinal = driver.manage().window().getSize().width / 2;
	    	swipeYInicial = (int) (driver.manage().window().getSize().height * 0.9);
	    	swipeYFinal = (int) (driver.manage().window().getSize().height * 0.2);
	    	do {
	    		cont = cont + 1;
	    		action.press(PointOption.point(swipeXInicial, swipeYInicial)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(swipeXFinal, swipeYFinal)).release().perform();	
	    		botonVisible = driver.findElement(By.xpath(btnHistorialDeAutorizacionesIOS)).getAttribute("visible");
	    	}while (botonVisible == "false" || cont < 5); 
	    	driver.findElement(By.xpath(btnHistorialDeAutorizacionesIOS)).click();
	    }
		
		
	}
	
	@When("Valido que entro en la pantalla historial de autorizaciones")
	public void validarPantallaHistorialDeAutorizaciones() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
	    	assertTrue(driver.findElement(By.xpath(lblHistorialAutorizacionesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solapaPagosHistorialAutorizacionesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(solapaSolicitudesHistorialAutorizacionesIOS)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(descripcionHistorialAutorizacionesIOS)).isDisplayed());	
	    }
	}
	
	@When("Vuelvo hacia atras en la pantalla de historial de autorizaciones")
	public void volverHaciaAtrasEnHistorialDeAutorizaciones() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(btnAtrasHistorialDeAutorizacionesIOS)).click();
	    }
	}
	
	@When("Vuelvo hacia atras en la opcion DEBIN")
	public void volverHaciaAtrasEnOpcionDEBIN() {
		if (Hooks.esAndroid()) {
	    	
	    }else {
			driver.findElement(By.xpath(btnAtrasDEBINIOS)).click();
	    }
	}
}

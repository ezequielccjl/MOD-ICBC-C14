package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeMobile {
	
		//MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
		//boolean isDisplayed = element.isDisplayed();
		
		static AppiumDriver<MobileElement> driver = Hooks.getDriver();
		String saludo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView";
		String ocultarSaldos = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[2]";
		
		String saludoIOS = "(//XCUIElementTypeStaticText[@name='¡Hola Goem!'])[2]";
		String ocultarSaldosIOS = "(//XCUIElementTypeStaticText[@name='Ocultar saldos'])[2]";
		String saldoOcultoIOS = "//XCUIElementTypeStaticText[@name='$***']";
		
		//NUEVA BOTONERA
		///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.widget.Button
		
		
		// HomeMobile-SaludoAlUsuario
		@Then("Reviso que aparezca el saludo al usuario")
		public void revisoQueAparezcaElSaludoAlUsuario() throws InterruptedException {
			//¡Hola Goem!
			Boolean apareceSaludo;
			Thread.sleep(3000);
			System.out.println("VERIFICACION THEN");
			if (Hooks.esAndroid()) {
				apareceSaludo = driver.findElement(By.xpath(saludo)).isDisplayed();
			}else {
				apareceSaludo = driver.findElement(By.xpath(saludoIOS)).isDisplayed();
			}
			
	        System.out.println(apareceSaludo);
	       	assertTrue(apareceSaludo);
		}
		
		// HomeMobile-OcultarSaldos
		@When("Presiono en ocultar saldos")
		public void presionoEnOcultarSaldos() {
			if (Hooks.esAndroid()) {
				driver.findElement(By.xpath(ocultarSaldos)).click();
			}else {
				driver.findElement(By.xpath(ocultarSaldosIOS)).click();
			}
			
		}
	
		@Then("Valido que el saldo este oculto")
		public void validoQueElSaldoEsteOculto() {
			Boolean apareceSaldoOculto;
			if (Hooks.esAndroid()) {
				apareceSaldoOculto = driver.findElement(By.xpath("/")).isDisplayed();
			}else {
				apareceSaldoOculto = driver.findElement(By.xpath(saldoOcultoIOS)).isDisplayed();
			}
	        System.out.println(apareceSaldoOculto);
	       	assertTrue(apareceSaldoOculto);
		}
		
		// HomeMobile-NuevaBotonera
		@Then("Verifico que se encuentre nueva botonera")
		public void verificoQueSeEncuentreNuevaBotonera() {
		    if (Hooks.esAndroid()) {
		    	Boolean aparecePagarQR = driver.findElement(By.xpath("")).isDisplayed();
		        System.out.println(aparecePagarQR);
		       	assertTrue(aparecePagarQR);
		       	
		       	Boolean apareceTransferir = driver.findElement(By.xpath("")).isDisplayed();
		        System.out.println(apareceTransferir);
		       	assertTrue(apareceTransferir);
		       	
		       	Boolean aparecePagarServicios = driver.findElement(By.xpath("")).isDisplayed();
		        System.out.println(aparecePagarServicios);
		       	assertTrue(aparecePagarServicios);
		       	
		       	Boolean apareceNuevoProducto = driver.findElement(By.xpath("")).isDisplayed();
		        System.out.println(apareceNuevoProducto);
		       	assertTrue(apareceNuevoProducto);
			}else {
				Boolean aparecePagarQR = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Pagar con QR')]")).isDisplayed();
		        System.out.println(aparecePagarQR);
		       	assertTrue(aparecePagarQR);
		       	
		       	Boolean apareceTransferir = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir')]")).isDisplayed();
		        System.out.println(apareceTransferir);
		       	assertTrue(apareceTransferir);
		       	
		       	Boolean aparecePagarServicios = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Pagar Servicios')]")).isDisplayed();
		        System.out.println(aparecePagarServicios);
		       	assertTrue(aparecePagarServicios);
		       	
		       	Boolean apareceNuevoProducto = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Nuevo Producto')]")).isDisplayed();
		        System.out.println(apareceNuevoProducto);
		       	assertTrue(apareceNuevoProducto);
			}
		}
		
		// HomeMobile-BotonCBUAlias
		@Then("Verifico funcionamiento de boton CBU Alias")
		public void verificoFuncionamientoDeBotonCBUAlias() {
			if (Hooks.esAndroid()) {
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name='CBU-ALIAS-QR']")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Consulta de CBU - Alias - QR']")).isDisplayed());
			}
			
		}
		
		// HomeMobile-BotonNuevoProducto
		@Then("Verifico que boton Nuevo Producto se encuentre en pantalla")
		public void verificoQueBotonNuevoProductoSeEncuentreEnPantalla() {
		    if (Hooks.esAndroid()) {
				
			}else {
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Nuevo Producto')]")).isDisplayed());
			}
		}
		
		// HomeMobile-BotonNuevoProductoFuncional
		@Then("Verifico que boton Nuevo Producto este funcional")
		public void verificoQueBotonNuevoProductoEsteFuncional() {
			if (Hooks.esAndroid()) {
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Nuevo Producto')]")).click();
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Solicitud de un nuevo producto']")).isDisplayed());
				
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Cuentas')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Tarjetas')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Inversiones')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Préstamos')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Crédito a Tasa Cero')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Seguros')]")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Paquetes')]")).isDisplayed());
			}
		    
		}
		
		// HomeMobile-BarraInferiorDisponible
		@Then("Valido que aparezca barra inferior")
		public void validoQueAparezcaBarraInferior() {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Inversiones')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Pagos')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Inicio')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'MODO')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).isDisplayed());
		}
		
		// HomeMobile-BotonInversiones
		@Then("Valido que funcione de boton Inversiones")
		public void validoQueFuncioneDeBotonInversiones() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Inversiones')]")).click();
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Inversiones']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Plazos Fijos']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Fondos de Inversión']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra / Venta de U$S']")).isDisplayed());
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Simular']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Nuevo plazo fijo']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Consulta de fondos']")).isDisplayed());
		}

		
		// HomeMobile-BotonPagos
		@Then("Valido que funcione de boton Pagos")
		public void validoQueFuncioneDeBotonPagos() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Pagos')]")).click();
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Pagos']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='DEBIN']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Pagá todos tus servicios, impuestos, tarjetas de crédito y recargá tu celular en línea, sin manejar dinero en efectivo.']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Generá cobros y autorizá pagos en forma inmediata.']")).isDisplayed());
		}
		
		// MobileMobile-MenuHamburguesa
		@Then("Valido que funcione menu hamburguesa")
		public void validoQueFuncioneMenuHamburguesa() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
			
			String xpathExtraccionSinTarjetaIphone = "//XCUIElementTypeStaticText[@name=\"Extracción sin tarjeta\"]";
			String xpathGestionDeProductosIphone = "//XCUIElementTypeStaticText[@name=\"Gestión de productos\"]";
			String xpathCompraVentaDolaresIphone = "//XCUIElementTypeStaticText[@name=\"Compra/Venta de U$S\"]";
			String xpathResumenesIphone = "//XCUIElementTypeStaticText[@name=\"Resúmenes\"]";
			String xpathContactoIphone = "//XCUIElementTypeStaticText[@name=\"Contacto\"]";
			String xpathRecomendarIphone = "//XCUIElementTypeStaticText[@name=\"Recomendar\"]";
			String xpathPerfilIphone = "//XCUIElementTypeStaticText[@name=\"Perfil\"]";
			String xpathAyudaIphone = "//XCUIElementTypeStaticText[@name=\"Ayuda\"]";
			String xpathCerrarSesionIphone = "//XCUIElementTypeStaticText[@name=\"Cerrar sesión\"]";

			assertTrue(driver.findElement(By.xpath();
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Gestión de productos')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'CompraVenta de U$$')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Resumenes')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Contacto')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Recomendar')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Perfil')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Ayuda')]"));
			assertTrue(pm.elementoDisponible("//li[contains(text(), 'Cerrar sesión')]"));
		}

}

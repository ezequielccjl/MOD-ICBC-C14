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
		
		// HomeMobile-BotonTresPuntitos
				@Then("Verifico funcionamiento de boton Tres Puntitos")
				public void verificoFuncionamientoDeBotonTresPuntitos() {
					if (Hooks.esAndroid()) {
						
					}else {
						driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='sub-menu'])[1]")).click();
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra/Venta de U$S']")).isDisplayed());
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Extracción sin tarjeta']")).isDisplayed());
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Agenda']")).isDisplayed());
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Saldo al 31/12']")).isDisplayed());
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Aviso de viaje']")).isDisplayed());
						assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='e-resumen']")).isDisplayed());
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

			assertTrue(driver.findElement(By.xpath(xpathExtraccionSinTarjetaIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathGestionDeProductosIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathCompraVentaDolaresIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathResumenesIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathContactoIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathRecomendarIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathPerfilIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathAyudaIphone)).isDisplayed());
			assertTrue(driver.findElement(By.xpath(xpathCerrarSesionIphone)).isDisplayed());
		}
		
		// HomeMobile-BotonExtraccionSinTarjeta
		@Then("Valido que me redirija a pantalla Extraccion sin tarjeta")
		public void validoQueMeRedirijaAPantallaExtraccionSinTarjeta() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
			
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Extracción sin tarjeta']")).click();
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Extracción sin tarjeta']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Los estados de las órdenes de extracción pueden demorar hasta 24hs en actualizarse. Ante cualquier duda, consultá los movimientos de cuenta.']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Nueva extracción sin tarjeta']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Órdenes de extracción']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Pendientes Pendientes']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Historial Historial']")).isDisplayed());
		}
		
		// HomeMobile-PantallaGestionDeProductos
		@Then("Valido que me redirija a Pantalla Gestion de Productos")
		public void validoQueMeRedirijaAPantallaGestionDeProductos() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Gestión de productos']")).click();
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Cuentas')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Tarjetas')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Inversiones')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Préstamos')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Crédito a Tasa Cero')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Seguros')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Paquetes')]")).isDisplayed());	
		  
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Dar de baja mis productos']")).isDisplayed());	
		}
		
		// HomeMobile-PantallaCompraVentaUSD
		@Then("Valido que me redirija a Pantalla Compra Venta USD")
		public void validoQueMeRedirijaAPantallaCompraVentaUSD() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra/Venta de U$S']")).click();
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra / Venta de U$S']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Comprás a']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Vendés a']")).isDisplayed());
		    
		}
		
		// HomeMobile-PantallaResumenes - DECIDIR SI AVANZAR EN LA PANTALLA
		@Then("Valido que me redirija a Pantalla Resumenes")
		public void validoQueMeRedirijaAPantallaResumenes() {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Resúmenes']")).click();
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Resúmenes']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Consultá los extractos de movimientos y avisos de tus productos ICBC.']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Tarjetas']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='chevron-right']")).isDisplayed());
		}

}

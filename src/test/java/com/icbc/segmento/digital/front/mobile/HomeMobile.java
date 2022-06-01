package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeMobile {
	
		
		static AppiumDriver<MobileElement> driver = Hooks.getDriver();
		String saludo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView";
		String ocultarSaldos = "//android.view.View[contains(@text, 'Ocultar saldos')]";
		
		String saludoIOS = "(//XCUIElementTypeStaticText[@name='¡Hola Goem!'])[2]";
		String ocultarSaldosIOS = "(//XCUIElementTypeStaticText[@name='Ocultar saldos'])[2]";
		String saldoOcultoIOS = "//XCUIElementTypeStaticText[@name='$***']";
		
		
		
		// HomeMobile-SaludoAlUsuario
		@Then("Reviso que aparezca el saludo al usuario")
		public void revisoQueAparezcaElSaludoAlUsuario() throws InterruptedException {
			System.out.println("// HomeMobile-SaludoAlUsuario");
			
			if (Hooks.esAndroid()) {
				assertTrue(Hooks.getDriver().findElement(By.xpath(saludo)).isDisplayed());
			}else {
				assertTrue(driver.findElement(By.xpath(saludoIOS)).isDisplayed());
			}
			
		}
		
		// HomeMobile-OcultarSaldos
		@When("Presiono en ocultar saldos")
		public void presionoEnOcultarSaldos() {
			System.out.println("// HomeMobile-OcultarSaldos");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath(ocultarSaldos)).click(); 
			}else {
				driver.findElement(By.xpath(ocultarSaldosIOS)).click();
			}
			
		}
	
		@Then("Valido que el saldo este oculto")
		public void validoQueElSaldoEsteOculto() {
			Boolean apareceSaldoOculto;
			if (Hooks.esAndroid()) {
				apareceSaldoOculto = Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text = '$***']")).isDisplayed();
			}else {
				apareceSaldoOculto = driver.findElement(By.xpath(saldoOcultoIOS)).isDisplayed();
			}
	        System.out.println(apareceSaldoOculto);
	       	assertTrue(apareceSaldoOculto);
		}
		
		// HomeMobile-NuevaBotonera
		@Then("Verifico que se encuentre nueva botonera")
		public void verificoQueSeEncuentreNuevaBotonera() {
			System.out.println("// HomeMobile-NuevaBotonera");
			
		    if (Hooks.esAndroid()) {
		    	Boolean aparecePagarQR = Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagar con QR')]")).isDisplayed();
		        System.out.println(aparecePagarQR);
		       	assertTrue(aparecePagarQR);
		       	
		       	Boolean apareceTransferir = Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Transferir')]")).isDisplayed();
		        System.out.println(apareceTransferir);
		       	assertTrue(apareceTransferir);
		       	
		       	Boolean aparecePagarServicios = Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagar Servicios')]")).isDisplayed();
		        System.out.println(aparecePagarServicios);
		       	assertTrue(aparecePagarServicios);
		       	
		       	Boolean apareceNuevoProducto = Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Nuevo Producto')]")).isDisplayed();
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
			System.out.println("// HomeMobile-BotonCBUAlias");
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='CBU-ALIAS']")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Consulta de CBU - Alias - QR']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='VER CÓDIGO QR DE MI CUENTA']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='COMPARTIR']")).isDisplayed());
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'CBU:')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'CUIL:')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Caja de ahorro')]")).isDisplayed());
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[@name='CBU-ALIAS-QR']")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Consulta de CBU - Alias - QR']")).isDisplayed());
			}
			
		}
		
		// HomeMobile-BotonTresPuntitos
		@Then("Verifico funcionamiento de boton Tres Puntitos")
		public void verificoFuncionamientoDeBotonTresPuntitos() {
			System.out.println("// HomeMobile-BotonTresPuntitos");
			
			if (Hooks.esAndroid()) {
				
				Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='sub-menu'])[1]")).click();
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Compra/Venta de U$S')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Extracción sin tarjeta')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Agenda')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Saldo al 31/12')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Aviso de viaje')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'e-resumen')]")).isDisplayed());
				
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
			System.out.println("// HomeMobile-BotonNuevoProducto");
			
		    if (Hooks.esAndroid()) {
		    	Boolean apareceNuevoProducto = Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Nuevo Producto')]")).isDisplayed();
		        System.out.println(apareceNuevoProducto);
		       	assertTrue(apareceNuevoProducto);
			}else {
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Nuevo Producto')]")).isDisplayed());
			}
		}
		
		// HomeMobile-BotonNuevoProductoFuncional
		@Then("Verifico que boton Nuevo Producto este funcional")
		public void verificoQueBotonNuevoProductoEsteFuncional() {
			System.out.println("// HomeMobile-BotonNuevoProductoFuncional");
			
			if (Hooks.esAndroid()) {
				
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Nuevo Producto')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Solicitud de un nuevo producto']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Cuentas')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Tarjetas')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Inversiones')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Préstamos')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Crédito a Tasa Cero')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Seguros')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Paquetes')]")).isDisplayed());
		        
				
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
			
			System.out.println("// HomeMobile-BarraInferiorDisponible");
			
			if (Hooks.esAndroid()) {
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Inversiones')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Pagos')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Inicio')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'MODO')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).isDisplayed());
			} else {
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@text, 'Inversiones')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@text, 'Pagos')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@text, 'Inicio')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@text, 'MODO')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@text, 'Más')]")).isDisplayed());
			}
			
		}
		
		// HomeMobile-BotonInversiones
		@Then("Valido que funcione de boton Inversiones")
		public void validoQueFuncioneDeBotonInversiones() {
			System.out.println("// HomeMobile-BotonInversiones");
			
			if (Hooks.esAndroid()) {
				
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Inversiones')]")).click();
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Inversiones']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Plazos Fijos']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Fondos de Inversión']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Compra / Venta de U$S']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Cotización del Dólar']")).isDisplayed());
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Simular']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Nuevo plazo fijo']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Consulta de fondos']")).isDisplayed());
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Inversiones')]")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Inversiones']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Plazos Fijos']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Fondos de Inversión']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra / Venta de U$S']")).isDisplayed());
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Simular']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Nuevo plazo fijo']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Consulta de fondos']")).isDisplayed());
			}
			
		}

		
		// HomeMobile-BotonPagos
		@Then("Valido que funcione de boton Pagos")
		public void validoQueFuncioneDeBotonPagos() {
			System.out.println("// HomeMobile-BotonPagos");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagos')]")).click();//NO SUCH ELEMENT
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Pagos']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='DEBIN']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Pagá todos tus servicios, impuestos, tarjetas de crédito y recargá tu celular en línea, sin manejar dinero en efectivo.']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Generá cobros y autorizá pagos en forma inmediata.']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Pagos')]")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Pagos']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='DEBIN']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Pagá todos tus servicios, impuestos, tarjetas de crédito y recargá tu celular en línea, sin manejar dinero en efectivo.']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Generá cobros y autorizá pagos en forma inmediata.']")).isDisplayed());
			}
			
		}
		
		// MobileMobile-MenuHamburguesa
		@Then("Valido que funcione menu hamburguesa")
		public void validoQueFuncioneMenuHamburguesa() {
			System.out.println("// MobileMobile-MenuHamburguesa");
			
			if (Hooks.esAndroid()) {
				
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				
				String xpathExtraccionSinTarjetaAndroid= "//android.view.View[contains(@text,'Extracción sin tarjeta')]";
				String xpathGestionDeProductosAndroid = "//android.view.View[contains(@text,'Gestión de productos')]";
				String xpathCompraVentaDolaresAndroid = "//android.view.View[contains(@text,'CompraVenta de U$$')]";
				String xpathResumenesAndroid = "//android.view.View[contains(@text,'Resumenes')]";
				String xpathContactoAndroid = "//android.view.View[contains(@text,'Contacto')]";
				String xpathRecomendarAndroid = "//android.view.View[contains(@text,'Recomendar')]";
				String xpathPerfilAndroid = "//android.view.View[contains(@text,'Perfil')]";
				String xpathAyudaAndroid = "//android.view.View[contains(@text,'Ayuda')]";
				String xpathCerrarSesionAndroid = "//android.view.View[contains(@text,'Cerrar sesión')]";

				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathExtraccionSinTarjetaAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathGestionDeProductosAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathCompraVentaDolaresAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathResumenesAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathContactoAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathRecomendarAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathPerfilAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathAyudaAndroid)).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath(xpathCerrarSesionAndroid)).isDisplayed());
				
			}else {
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
			
		}
		
		// HomeMobile-BotonExtraccionSinTarjeta
		@Then("Valido que me redirija a pantalla Extraccion sin tarjeta")
		public void validoQueMeRedirijaAPantallaExtraccionSinTarjeta() {
			
			System.out.println("// HomeMobile-BotonExtraccionSinTarjeta");
			
			if (Hooks.esAndroid()) {
				
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Extracción sin tarjeta')]")).click();
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Extracción sin tarjeta']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Los estados de las órdenes de extracción pueden demorar hasta 24hs en actualizarse. Ante cualquier duda, consultá los movimientos de cuenta.']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Nueva extracción sin tarjeta')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Órdenes de extracción']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Pendientes Pendientes']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Historial Historial']")).isDisplayed());
				
			}else {
				
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Extracción sin tarjeta']")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Extracción sin tarjeta']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Los estados de las órdenes de extracción pueden demorar hasta 24hs en actualizarse. Ante cualquier duda, consultá los movimientos de cuenta.']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Nueva extracción sin tarjeta']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Órdenes de extracción']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Pendientes Pendientes']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Historial Historial']")).isDisplayed());
			}
			
		}
		
		//Finalización de casos en Android-----------------------------
		
		// HomeMobile-PantallaGestionDeProductos
		@Then("Valido que me redirija a Pantalla Gestion de Productos")
		public void validoQueMeRedirijaAPantallaGestionDeProductos() {
			System.out.println("// HomeMobile-PantallaGestionDeProductos");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains (@text, 'Gestión de productos')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Solicitud de un nuevo producto']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Cuentas')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Tarjetas')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Inversiones')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Préstamos')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Crédito a Tasa Cero')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Seguros')]")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Solicitud de un nuevo producto']")).isDisplayed());
			  
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Dar de baja mis productos']")).isDisplayed());	
			}else {
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
		}
		
		// HomeMobile-PantallaCompraVentaUSD
		@Then("Valido que me redirija a Pantalla Compra Venta USD")
		public void validoQueMeRedirijaAPantallaCompraVentaUSD() {
			System.out.println("// HomeMobile-PantallaCompraVentaUSD");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'CompraVenta de U$$')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Compra / Venta de U$S']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Para realizar la operación de Compra / Venta de U$S se requiere una cuenta de distinta moneda para acreditar los fondos.']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='COMPRAR']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='VENDER']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra/Venta de U$S']")).click();
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Compra / Venta de U$S']")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Comprás a']")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Vendés a']")).isDisplayed());
			}
		    
		}
		
		// HomeMobile-PantallaResumenes - DECIDIR SI AVANZAR EN LA PANTALLA
		@Then("Valido que me redirija a Pantalla Resumenes")
		public void validoQueMeRedirijaAPantallaResumenes() {
			System.out.println("// HomeMobile-PantallaResumenes - DECIDIR SI AVANZAR EN LA PANTALLA");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Resumenes')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Resúmenes']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Consultá los extractos de movimientos y avisos de tus productos ICBC.']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Tarjetas']")).isDisplayed());
			    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='chevron-right']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Resúmenes']")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Resúmenes']")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Consultá los extractos de movimientos y avisos de tus productos ICBC.']")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Tarjetas']")).isDisplayed());
			    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='chevron-right']")).isDisplayed());
			}
		}
		
		// HomeMobile-PantallaContacto
		@Then("Valido que me redirija a Pantalla Contacto")
		public void validoQueMeRedirijaAPantallaContacto() {
			System.out.println("// HomeMobile-PantallaContacto");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Contacto')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Teléfonos útiles']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Mesa de ayuda']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='ICBC Mobile Banking y Access Banking']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Lunes a viernes de 7 a 24 hs y sábados, domingos y feriados de 10 a 18 hs']")).isDisplayed()); 
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'0810-555-9200')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='(54-11) 4820-9200']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='0810-444-4652 ó *4652']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='(54-11) 4820-2021']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Contacto']")).click();
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Teléfonos útiles']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Mesa de ayuda']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='ICBC Mobile Banking y Access Banking']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Lunes a viernes de 8 a 20 hs y sábados y domingos de 10 a 16 hs']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeLink[contains(@name,'0810-555-9200')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeLink[[contains(@name,'(54-11) 4820-9200')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeLink[contains(@name,'0810-444-4652ó *4652')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Centro HOLA!']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeLink[contains(@name,'(54-11) 4820-2021')]")).isDisplayed());
			}
			
		}
		
		// HomeMobile-PantallaRecomendar
		@Then("Valido que me redirija a Pantalla Recomendar")
		public void validoQueMeRedirijaAPantallaRecomendar() {
			System.out.println("// NuevaHome-PantallaRecomendar");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Recomendar')]")).click();
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Recomenda y Gana']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Por cada persona que recomiendes e ingrese por primera vez')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='E-mail']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Facebook']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Twitter']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Messenger']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Whatsapp']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Instagram']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Telegram']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Recomendar']")).click();
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Recomenda y Gana']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains (@name,'Por cada persona que recomiendes e ingrese por primera vez']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='E-mail']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Facebook']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Twitter']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Messenger']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Whatsapp']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Instagram']")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Telegram']")).isDisplayed());
			}
		}
		
		// HomeMobile-PantallaPerfil
		@Then("Valido que me redirija a Pantalla Perfil")
		public void validoQueMeRedirijaAPantallaPerfil() {
			System.out.println("// NuevaHome-PantallaPerfil");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Perfil')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Hola,')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'La última vez que ingresaste a ICBC Mobile Banking fue el')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Tu clave vence el')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Cambio de clave de ICBC Access y Mobile Banking']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='La clave deberá ser de 8 caracteres y contener letras y números.']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Clave actual']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Ingresa tu nueva clave']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Confirma tu nueva clave']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Cambiar la clave']")).isDisplayed());
				
				//No se pueden verificar inputs porque no hay referencias
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Perfil']")).click();
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Hola,\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"La última vez que ingresaste a ICBC Mobile Banking fue el\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Tu clave vence el\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Cambio de clave de ICBC Access y Mobile Banking\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"La clave deberá ser de 8 caracteres y contener letras y números.\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Clave actual\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ingresa tu nueva clave\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Confirma tu nueva clave\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Esté es un campo tipo Clave actual\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Esté es un campo tipo Ingresa tu nueva clave\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Esté es un campo tipo Confirma tu nueva clave\"]")).isDisplayed());
			}
			
		}
		
		// HomeMobile-PantallaAyuda
		@Then("Valido que me redirija a Pantalla Ayuda")
		public void validoQueMeRedirijaAPantallaAyuda() {
			System.out.println("// NuevaHome-PantallaAyuda");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Perfil')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Ayuda']")).isDisplayed());//NO SUCH ELEMENT
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Preguntas Frecuentes']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Terminos y condiciones']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Politicas de privacidad']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Seguridad']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Contactos']")).isDisplayed());
				
				//INCOMPLETO
				
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Ayuda']")).click();
			}

		}

		
		// HomeMobile-CerrarSesion
		@Then("Verifico que cierro sesion")
		public void verificoQueCierroSesion() {
			System.out.println("// NuevaHome-CerrarSesion");
			
			if (Hooks.esAndroid()) {
				Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains (@text, 'Más')]")).click();
				Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Cerrar sesión')]")).click();
				
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Ingresar con biometría')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Usuario']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Clave']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Ingresar']")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Transferir con Alias')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Accesos útiles')]")).isDisplayed());
				assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='¿Tenés problemas para ingresar?']")).isDisplayed());
			}else {
				driver.findElement(By.xpath("//XCUIElementTypeButton[contains (@name, 'Más')]")).click();
				driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Cerrar sesión']")).click();
				
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Ingresar con biometría')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Usuario\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Usuario\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Clave\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"Esté es un campo tipo Clave\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Ingresar\"]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos útiles')]")).isDisplayed());
				assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"¿Tenés problemas para ingresar?\"]")).isDisplayed());
			}
			
		}

}

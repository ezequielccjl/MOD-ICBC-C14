package com.icbc.segmento.digital.front.mobile;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class LoginNuevoMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	String usuarioContraseniaIncorrecta = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[3]/android.widget.Button";
	String olvideMiClaveBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.Button";
	
	// LoginNuevo-Mobile-01
	@Then("Verifico campos de pantalla login")
	public void verificoCamposDePantallaLogin() {
		System.out.println("Step: Verifico campos de pantalla login");
	    if (Hooks.esAndroid()) {
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Ingresar con biometría')]")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Usuario']")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Clave']")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Ingresar']")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='¿Tenés problemas para ingresar?']")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Transferir')]")).isDisplayed());
		    assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Accesos útiles')]")).isDisplayed());
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='banner']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Ingresar con biometría')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Esté es un campo tipo Usuario']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name='Esté es un campo tipo Clave']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ingresar']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='¿Tenés problemas para ingresar?']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos útiles')]")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-02
	@When("Clickeo en Ingresar por biometria")
	public void clickeoEnIngresarPorBiometria() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Ingresar con biometría')]")).click();
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Ingresar con biometría')]")).click();
		}
	}

	@Then("Reviso correcta visualizacion de Ingresar por biometria")
	public void revisoCorrectaVisualizacionDeIngresarPorBiometria() {
		System.out.println("Step: Verifico campos de pantalla biometria");
	    if (Hooks.esAndroid()) {
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Ingresá los datos de tu DNI']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Número de DNI']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Número de trámite']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='¿Qué es el número de trámite?']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Cancelar']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Continuar']")).isDisplayed());
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Ingresá los datos de tu DNI']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Esté es un campo tipo Número de DNI']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Esté es un campo tipo Número de trámite']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='¿Qué es el número de trámite?']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancelar']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-03
	@When("Clickeo en Accesos utiles")
	public void clickeoEnAccesosUtiles() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Accesos útiles')]")).click();
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos útiles')]")).click();
		}
	}

	@Then("Reviso correcta visualizacion de Accesos utiles")
	public void revisoCorrectaVisualizacionDeAccesosUtiles() {
		System.out.println("Step: Verifico pantalla Accesos utiles");
	    if (Hooks.esAndroid()) {
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Accesos útiles']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Turnos')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Hacete cliente')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'ICBC Mall')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Beneficios')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Informacion')]")).isDisplayed());
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Accesos útiles']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Turnos')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Hacete cliente')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'ICBC Mall')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Beneficios')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Informacion')]")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-04
	@Then("Clickeo Turnos y reviso correcta visualizacion de pantalla")
	public void ClickeoTurnosYRevisoCorrectaVisualizacionDePantalla() {
	    if (Hooks.esAndroid()) {
	    	Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Turnos')]")).click();
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Turnos online para atención en sucursales ICBC']")).isDisplayed());
		}else {
			
		}
	}
		
	// LoginNuevo-Mobile-05
	@Then("Clickeo Hacete cliente y reviso correcta visualizacion de pantalla")
	public void ClickeoHaceteClienteYRevisoCorrectaVisualizacionDePantalla() {
	if (Hooks.esAndroid()) {
	   	Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Hacete cliente')]")).click();
	   	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sacá ahora tu tarjeta de crédito ICBC.']")).isDisplayed());
	   	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Comenzar Ahora']")).isDisplayed());
	}else {
					
		}
	}
				
	// LoginNuevo-Mobile-06
	@Then("Clickeo ICBC Mall y reviso correcta visualizacion de pantalla")
	public void ClickeoICBCMallYRevisoCorrectaVisualizacionDePantalla() {
	    if (Hooks.esAndroid()) {
	    	Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'ICBC Mall')]")).click();
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='mall.icbc.com.ar wants to send you notifications']")).isDisplayed());
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Block']")).isDisplayed());
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Allow']")).isDisplayed());
		   	Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Block']")).click();
		   	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='INGRESAR']")).isDisplayed());
		}else {
				
		}
	}
				
	// LoginNuevo-Mobile-07
	@Then("Clickeo Beneficios y reviso correcta visualizacion de pantalla")
	public void ClickeoBeneficiosYRevisoCorrectaVisualizacionDePantalla() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Beneficios')]")).click();
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='ICBC Beneficios']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.EditText[@text='beneficios.icbc.com.ar/?cm_mmc=mbr-_-icono-_-login-_-beneficios']")).isDisplayed());
	    	
		}else {
						
		}
	}
	
	// LoginNuevo-Mobile-07-Extra
	@Then("Clickeo Informacion y reviso correcta visualizacion de pantalla")
	public void ClickeoInformacionYRevisoCorrectaVisualizacionDePantalla() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Informacion')]")).click();
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Preguntas Frecuentes']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Términos y condiciones']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Políticas de privacidad']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Seguridad']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Contacto']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='chevron-right'])[1]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='chevron-right'])[2]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='chevron-right'])[3]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='chevron-right'])[4]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.Button[@text='chevron-right'])[5]")).isDisplayed());
		}else {
						
		}
	}
	
	// LoginNuevo-Mobile-08
	@When("Clickeo en Transferir de Accesos utiles")
	public void clickeoEnTransferirDeAccesosUtiles() {
		
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Transferir con Alias')]")).click();
			
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir con Alias')]")).click();			
		}
		
	}

	@Then("Reviso correcta visualizacion de pantalla Transferir")
	public void revisoCorrectaVisualizacionDePantallaTransferir() {
		System.out.println("Step: Verifico pantalla Accesos utiles");
	    if (Hooks.esAndroid()) {
	    	
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[1]")).isDisplayed());
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[2]")).isDisplayed());
	    	
	    	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Transferir con alias']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Destino']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Ingresá un alias de cuenta y un importe.']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Cancelar']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Continuar']")).isDisplayed());
		
	    }else {
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Transferir con alias']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Esté es un campo tipo Ingrese un alias']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Ingresa un alias de cuenta y un importe.']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Esté es un campo tipo ']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancelar']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-09
	@Then("Verificar el correcto acceso a la Home de Mobile")
	public void verificarElCorrectoAccesoALaHomeDeMobile() throws InterruptedException {
		if (Hooks.esAndroid()) {
			
			if (Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Términos y condiciones ICBC Mobile Banking']")).isDisplayed()) {
				Hooks.getDriver().findElement(By.xpath("(//android.widget.TextView)[2]")).click();
			}
			
			Thread.sleep(4000);
			
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagar con QR')]")).isDisplayed());
	       	
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Transferir')]")).isDisplayed());
	       	
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagar Servicios')]")).isDisplayed());
	       	
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Nuevo Producto')]")).isDisplayed());
	       	
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[contains(@text,'Ocultar saldos')]")).isDisplayed());
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Inversiones')]")).isDisplayed());
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Pagos')]")).isDisplayed());
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Inicio')]")).isDisplayed());
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'MODO')]")).isDisplayed());
	       	assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Más')]")).isDisplayed());
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
	       	
	       	assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Ocultar saldos'])[2]")).isDisplayed());
	       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Inversiones')]")).isDisplayed());
	       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Pagos')]")).isDisplayed());
	       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Inicio')]")).isDisplayed());
	       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'MODO')]")).isDisplayed());
	       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Más')]")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-10 y 11
	@Then("Verificar que se despliegue el mensaje de error")
	public void verificarQueSeDespliegueElMensajeDeError() throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(5000);
//			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Usuario y/o contraseña incorrecta']")).isDisplayed());
//			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Olvide mi clave']")).isDisplayed());	
			
			assertTrue(Hooks.getDriver().findElement(By.xpath(usuarioContraseniaIncorrecta)).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath(olvideMiClaveBtn)).isDisplayed());	
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Usuario y/o contraseña incorrecta']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Olvide mi clave']")).isDisplayed());	
		}
	}
			
	// LoginNuevo-Mobile-12 12_Nuevo Login - Usuario con menos de 8 caracteres
	@Then("Me logueo con el usuario {string} y verifico mensaje de error")
	public void MeLogueoConElUsuarioYVerificoMensajeDeError(String user) {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys(user);
			Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[2]")).click();
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Letras y números, de 8 a 12 caracteres']")).isDisplayed());	
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name = 'Esté es un campo tipo Usuario']")).sendKeys(user);
			assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Letras y números, de 8 a 12 caracteres'])[2]")).isDisplayed());	
		}
		
	}
	
	// LoginNuevo-Mobile-13 013_Nuevo Login - Intento de ingreso sin clave
	@When("Ingreso usuario {string}")
	public void ingresoUsuario(String user) {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[2]")).click();
			Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys(user);
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name = 'Esté es un campo tipo Clave']")).click();		
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name = 'Esté es un campo tipo Usuario']")).sendKeys(user);			
		}
	}
	
	@Then("Verifico falta de password")
	public void verificoFaltaDePassword() {
		
		if (Hooks.esAndroid()) {
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.view.View[@text='Ingresá tu clave']")).isDisplayed());
		}else {
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='La clave debe tener 8 dígitos']")).isDisplayed());	
		}
		
	}
	
	// LoginNuevo-Mobile-14 14_Nuevo Login - Link Tenes problemas para ingresar
	@When("Clickeo en Tenes problemas para ingresar")
	public void clickeoEnTenesProblemasParaIngresar() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='¿Tenés problemas para ingresar?']")).click();
		}else {
			driver.findElement(By.xpath("//XCUIElementTypeButton[@name='¿Tenés problemas para ingresar?']")).click();
		}
	}

	@Then("Reviso correcta visualizacion de pantalla Problemas para ingresar")
	public void revisoCorrectaVisualizacionDePantallaProblemasParaIngresar() {
		if (Hooks.esAndroid()) {
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Si es la primera vez que ingresás, o bloqueaste u olvidaste tu usuario/clave, podés obtenerlos mediante una de estas opciones:']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Generación Online')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Tengo una clave provisoria')]")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[contains(@text,'Generación en cajeros Banelco')]")).isDisplayed());
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Si es la primera vez que ingresás, o bloqueaste u olvidaste tu usuario/clave, podés obtenerlos mediante una de estas opciones:']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Generación Online')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Generación en cajeros Benelco')]")).isDisplayed());
		}
	}
				
	
}

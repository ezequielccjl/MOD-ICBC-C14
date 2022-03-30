package com.icbc.segmento.digital.front.mobile;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginNuevoMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	// LoginNuevo-Mobile-01
	@Then("Verifico campos de pantalla login")
	public void verificoCamposDePantallaLogin() {
		System.out.println("Step: Verifico campos de pantalla login");
	    if (Hooks.esAndroid()) {
			
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='banner']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Ingresar con biometr�a')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Est� es un campo tipo Usuario']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name='Est� es un campo tipo Clave']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Ingresar']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='�Ten�s problemas para ingresar?']")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir')]")).isDisplayed());
		    assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos �tiles')]")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-02
	@When("Clickeo en Ingresar por biometria")
	public void clickeoEnIngresarPorBiometria() {
		driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Ingresar con biometr�a')]")).click();
	}

	@Then("Reviso correcta visualizacion de Ingresar por biometria")
	public void revisoCorrectaVisualizacionDeIngresarPorBiometria() {
		System.out.println("Step: Verifico campos de pantalla biometria");
	    if (Hooks.esAndroid()) {
			
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Ingres� los datos de tu DNI']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Est� es un campo tipo N�mero de DNI']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Est� es un campo tipo N�mero de tr�mite']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='�Qu� es el n�mero de tr�mite?']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancelar']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-03
	@When("Clickeo en Accesos utiles")
	public void clickeoEnAccesosUtiles() {
		driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos �tiles')]")).click();
	}

	@Then("Reviso correcta visualizacion de Accesos utiles")
	public void revisoCorrectaVisualizacionDeAccesosUtiles() {
		System.out.println("Step: Verifico pantalla Accesos utiles");
	    if (Hooks.esAndroid()) {
			
		}else {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Accesos �tiles']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Turnos')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Hacete cliente')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'ICBC Mall')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Beneficios')]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Informacion')]")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-08
	@When("Clickeo en Transferir de Accesos utiles")
	public void clickeoEnTransferirDeAccesosUtiles() {
		driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Accesos �tiles')]")).click();
	}

	@Then("Reviso correcta visualizacion de pantalla Transferir")
	public void revisoCorrectaVisualizacionDePantallaTransferir() {
		System.out.println("Step: Verifico pantalla Accesos utiles");
	    if (Hooks.esAndroid()) {
			
		}else {
			//Para este caso faltar�a clickear en select y verificar que se muestren opciones $ y u$d
			
//			(//XCUIElementTypeOther[@name="main"])[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther[5] (SELECT FLECHITA)
//			(//XCUIElementTypeStaticText[@name="$"])[2]	
//			//XCUIElementTypeStaticText[@name="U$S"]
			
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Transferir con alias']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Est� es un campo tipo Ingrese un alias']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Ingresa un alias de cuenta y un importe.']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Est� es un campo tipo ']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Cancelar']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continuar']")).isDisplayed());
		}
	}
	
	// LoginNuevo-Mobile-09
	@Then("Verificar el correcto acceso a la Home de Mobile")
	public void verificarElCorrectoAccesoALaHomeDeMobile() {
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
       	assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'M�s')]")).isDisplayed());
	}
	
	// LoginNuevo-Mobile-10 y 11
	@Then("Verificar que se despliegue el mensaje de error")
	public void verificarQueSeDespliegueElMensajeDeError() {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Usuario y/o contrase�a incorrecta']")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Olvide mi clave']")).isDisplayed());	
	}
			
	// LoginNuevo-Mobile-12
	@Then("Me logueo con el usuario {string} y verifico mensaje de error")
	public void MeLogueoConElUsuarioYVerificoMensajeDeError(String user) {
		driver.findElement(By.xpath("//XCUIElementTypeTextField[@name = 'Est� es un campo tipo Usuario']")).sendKeys(user);
		assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Letras y n�meros, de 8 a 12 caracteres'])[2]")).isDisplayed());	
	}
	
	// LoginNuevo-Mobile-13
		@Then("Me logueo con el usuario {string} presiono ingresar y verifico mensaje de error")
		public void MeLogueoConElUsuarioPresionoIngresarYVerificoMensajeDeError(String user) {
			assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='La clave debe tener 8 d�gitos']")).isDisplayed());	
		}
				
	
}

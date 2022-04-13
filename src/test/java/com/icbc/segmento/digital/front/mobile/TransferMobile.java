package com.icbc.segmento.digital.front.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TransferMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	String palomitaAgendarIOS = "(//XCUIElementTypeSwitch[@name='Agregar destinatario a mi agenda'])[2]";
	
	//TransferMobile-SinAgregarDestinatario
	@When("Presiona en el boton Transferir")
	public void presionaEnElBotonTransferir() {
		driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name,'Transferir')]")).click();
	}

	@When("Seleccina destino y agrega nuevo destinatario con {string}")
	public void seleccinaDestinoYAgregaNuevoDestinatarioCon(String cbu) {
//		driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Destino'])[5]")).click();
//		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='main'])[1]/XCUIElementTypeOther[10]")).click();
		
		
		
		MobileElement lblDestino = driver.findElementByXPath("(//XCUIElementTypeStaticText[@name='Destino'])[5]");
		int locationXlblDestino = lblDestino.getLocation().getX() + 15;
		int locationYlblDestino = lblDestino.getLocation().getY() + 20;
		new TouchAction(driver).press(PointOption.point(locationXlblDestino, locationYlblDestino)).release().perform();
		
	    driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Nuevo destinatario'])[2]")).click();
	    driver.findElement(By.xpath("(//XCUIElementTypeTextField[@name='Esté es un campo tipo CBU-CVU-Alias'])[2]")).sendKeys(cbu);
	    driver.findElement(By.xpath("(//XCUIElementTypeTextField[@name='Esté es un campo tipo Descripción'])[2]")).sendKeys("PRUEBA TEST");
	    driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='Continuar'])[2]")).click();
	}

	@When("Selecciona {string} {string} {string}")
	public void selecciona(String origen, String monto, String concepto) {
		
		//Seleccionar destino
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@width = 15])[2]")).click();
		//driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='AGENDAR'])[2]")).click();
		driver.findElement(By.xpath("(//XCUIElementTypeTextField[@name='Esté es un campo tipo Monto en $'])[2]")).sendKeys(monto);
		
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"main\"])[1]/XCUIElementTypeOther[32]/XCUIElementTypeOther[5]")).click();
		
		
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Varios\"]")).click();
		
	}

	@When("Presiona continuar ingresa token y confirma transferencia")
	public void presionaContinuarIngresaTokenYConfirmaTransferencia() {
	    
	}

	@Then("Verfica transferencia exitosa")
	public void verficaTransferenciaExitosa() {
	    
	}
	
}

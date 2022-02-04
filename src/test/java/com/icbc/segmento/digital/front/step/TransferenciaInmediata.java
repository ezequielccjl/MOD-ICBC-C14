package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class TransferenciaInmediata {
	
	PageModel pm = new PageModel();

    @Given("^El user \"([^\"]*)\" se loguea con \"([^\"]*)\"$")
    public void elUserSomethingSeLogueaConSomething(String user, String password) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Transferencia Inmediata");
    }

    @When("Presiona en el boton Transferir")
    public void presionaEnElBotonTransferir() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.implicitWait();
        pm.clickElement("//div[contains(text(),'Transferir')]");
    }

    @Then("^Verfica transferencia exitosa$")
    public void verficaTransferenciaExitosa() {
        
    }

    @When("Selecciona {string} {string} {string}")
    public void selecciona(String origen, String monto, String concepto) {
    	pm.esperarElemento("//h2[contains(text(),'Transferencias')]");
    	pm.implicitWait();
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-10')]");
    	pm.jseClickIntercepted("//div[contains(text(),'"+ origen +"')]");
    	
    	//XPath de concepto trae problemas, es dinamico y no pude conseguir algo identificable
    	
		pm.ingresarMontoTransferencia(monto);
		pm.implicitWait();
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-8 ly-drop-frame__input')]");
    	pm.jseClickIntercepted("//span[contains(text(),'" + concepto + "')]");
        
    }
    
    @When("Seleccina destino y agrega nuevo destinatario con {string}")
    public void seleccinaDestinoYAgregaNuevoDestinatarioConCBU(String cbu) {
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-5')]");
    	pm.clickElement("//a[contains(text(), 'Nuevo destinatario')]");
    	pm.ingresarCBUAgenda(cbu);
    	pm.implicitWait();
    	pm.ingresarTexto("//input[contains(@aria-label, 'Esté es un campo tipo Descripción')]", "PRUEBA TESTING AUTOMATICO");
    	pm.jseClickIntercepted("//button[contains(text(), 'Continuar')]");
    }

    @When("Marca palomita para a?adir destinatario")
    public void marcaPalomitaParaAAdirDestinatario() {
        pm.clickElement("//input[contains(@type, 'checkbox')]");
    }

    @And("^Presiona continuar ingresa token y confirma transferencia$")
    public void presionaContinuarIngresaTokenYConfirmaTransferencia() {
    	pm.implicitWait();
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	pm.ingresarTokenTransferencia("111111");
    	pm.clickElement("//button[contains(text(),'Transferir')]");
        
    }
    
    @Then("Verfica transferencia erronea")
    public void verficaTransferenciaErronea() {
        
    }

}

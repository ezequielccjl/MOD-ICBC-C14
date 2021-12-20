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

    @When("^Presiona en la pestania Transferir$")
    public void presionaEnLaPestaniaTransferir() {
        pm.implicitWait();
        pm.jseClickIntercepted("//button[contains(text(),'Transferir')]");
    }

    @Then("^Verfica transferencia exitosa$")
    public void verficaTransferenciaExitosa() {
        
    }

    @And("^Selecciona \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" y presiona continuar$")
    public void seleccionaSomethingSomethingSomethingYPresionaContinuar(String destino, String monto, String concepto) {
    	pm.implicitWait();
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-2')]");
		pm.implicitWait();
		pm.clickElement("//span[contains(text(),'" + destino + "')]");
		pm.implicitWait();
		pm.ingresarMontoTransferencia(monto);
		pm.implicitWait();
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-12')]");
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'" + concepto + "')]");
        
    }

    @And("^Presiona continuar ingresa token y confirma transferencia$")
    public void presionaContinuarIngresaTokenYConfirmaTransferencia() {
    	pm.implicitWait();
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	pm.implicitWait();
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	pm.implicitWait();
    	pm.ingresarTokenTransferencia("11111");
        
    }

}

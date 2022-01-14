package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.BasePage;
import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class ResumenCreditoRefactor {

	PageModel pm = new PageModel();

    @Given("^El \"([^\"]*)\" hace login con \"([^\"]*)\"$")
    public void elSomethingHaceLoginConSomething(String user, String password) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, password);
	    
	    System.out.println("Se ingresa: ResumenCredito");
    }

    @When("^Clickea en pestania mas$")
    public void clickeaEnPestaniaMas() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.implicitWait();
    	pm.clickMas();
    	System.out.println("PRESIONA BOTON MAS-------------");
    }

    @Then("^Verifica su lista de resumenes$")
    public void verificaSuListaDeResumenes() {
        
    }

    @And("^Selecciona Resumenes$")
    public void seleccionaResumenes() {
    	pm.implicitWait();
    	pm.clickResumenes();
    	System.out.println("PRESIONA BOTON RESUMENES-------------");
    }

    @And("^Selecciona Tarjetas$")
    public void seleccionaTarjetas() {
    	pm.implicitWait();
    	pm.clickTarjeta();
    	System.out.println("PRESIONA BOTON TARJETAS-------------");
        
    }

    @And("^Selecciona \"([^\"]*)\"$")
    public void seleccionaSomething(String tarjeta) {
    	
    	pm.implicitWait();
    	pm.clickTipoTarjeta(tarjeta);
    	System.out.println("PRESIONA TIPO DE TARJETA "+ tarjeta +"-------------");
        
    }
    
}
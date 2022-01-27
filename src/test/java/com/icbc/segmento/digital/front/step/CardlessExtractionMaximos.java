package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class CardlessExtractionMaximos {
	
	private String inputNumero = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-flex-layout/div/ly-form-field[2]/div/ly-text-field/div/input";

	PageModel pm = new PageModel();

    @Given("^El \"([^\"]*)\" hace log in con \"([^\"]*)\"$")
    public void elSomethingHaceLogInConSomething(String user, String password) {
    	pm.navigateToFBD();
    	pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Cardless Extraction - Máximos y minimos");
    }

    @When("^Clickea en la pestania mas$")
    public void clickeaEnLaPestaniaMas() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.clickMas();
    }

    @And("^Selecciona opcion Extraccion sin tarjeta$")
    public void seleccionaOpcionExtraccionSinTarjeta() {
    	pm.implicitWait();
    	pm.jseClickIntercepted("//li[contains(text(),'Extracción sin tarjeta')]");
    }

    @And("^Selecciona nueva extraccion sin tarjeta$")
    public void seleccionaNuevaExtraccionSinTarjeta() {
    	pm.implicitWait();
    	pm.clickElement("//a[contains(text(),' Nueva extracción sin tarjeta ')]");
    }

    @And("^Completa \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" segun la cantidad de \"([^\"]*)\"$")
    public void completaSomethingSomethingSomethingSomethingSegunLaCantidadDeSomething(String origen, String monto, String tipo, String numero, String loops) throws InterruptedException {
        
    	for (int i = 0; i < Integer.parseInt(loops) ; i++) {
    		
    		//if (i==0) {
    			pm.implicitWait();
    			pm.escribrirMonto(monto);
            	System.out.println("SE BORRA / MONTO: "+ monto);
            	
            	pm.implicitWait();
            	pm.write(inputNumero, numero);
			//}
        	
    		pm.implicitWait();
        	pm.jseClickIntercepted("//button[contains(text(),'Continuar')]");
        	
        	pm.esperarElemento("//div[contains(text(),'Verificá los datos ingresados')]");
        	
        	pm.jseClickIntercepted("//button[contains(text(),'Continuar')]");
        	
        	pm.implicitWait();
        	pm.write("//input[@maxlength='5']", "11111");
        	
        	pm.implicitWait();
        	pm.clickElement("//button[contains(text(),'Generar')]");
        	
        	Thread.sleep(5000);
        	pm.clickElement("//a[contains(text(),' Nueva extracción sin tarjeta ')]");
        	
        	System.out.println("PRESIONA BOTON NUEVA EXTRACCION-------------");
		}
    	
    }
    
    @Then("^Verifica la orden completada$")
    public void verificaLaOrdenCompletada() {
    	Boolean spanOrdenesDiarias = pm.elementoDisponible("//span[contains(text(),'Superaste la cantidad máxima de órdenes diarias permitidas.')]");
    	assertTrue(spanOrdenesDiarias);
    	
    	if(spanOrdenesDiarias) {
    		System.out.println("CANTIDAD DE VECES ALCANZADA.");
    	}else {
    		System.out.println("TODAVIA NO SE VERIFICO LA CANTIDAD DE VECES");
    	}
    	
    }

}
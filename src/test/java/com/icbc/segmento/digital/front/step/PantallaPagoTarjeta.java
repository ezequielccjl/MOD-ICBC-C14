package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class PantallaPagoTarjeta {
	
	PageModel pm = new PageModel();

    @Given("^El usuario se logea con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String password) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Pago Tarjeta de Crédito");
    }

    @When("^El usuario clickea en pagar \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioClickeaEnPagarSomethingSomething(String tarjeta, String nroTarjeta) {
    	
    	if (tarjeta.equals("Visa")) {
    		pm.implicitWait();
    		pm.jseClickIntercepted("//span[contains(text(),'"+ nroTarjeta +"')]");
    		
    		System.out.println("VISA");
    		
		}else if (tarjeta.equals("Mastercard")) {
			pm.implicitWait();
			pm.jseClickIntercepted("//span[contains(text(),'"+ nroTarjeta +"')]");
			System.out.println("MASTER");
		}
    	
    }
    
    @And("^Clickea en boton pagar$")
    public void clickeaEnBotonPagar() {
        pm.implicitWait();
        pm.clickElement("//button[contains(text(),'Pagar')]");
    }

    @And("^Selecciona \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" y clickea continuar$")
    public void seleccionaSomethingSomethingSomethingYClickeaContinuar(String cuentadebitar, String monedapagar, String importe) throws InterruptedException {
    	pm.implicitWait();
    	//pm.clickElement("//div[contains(@class,'ng-tns-c71-10')]");
    	pm.implicitWait();
    	//pm.jseClickIntercepted("//div[contains(text(),'" + cuentadebitar + "')]");
    	
    	if (monedapagar.equals("DOLAR")) {
			pm.clickElement("//div[contains(@class,'ng-tns-c71-11')]");
			pm.implicitWait();
			pm.jseClickIntercepted("//span[contains(text(),'DOLAR')]");
		}
    	
    	pm.implicitWait();
    	pm.ingresarImportePagoTC(importe);
    	Thread.sleep(2000);
    	System.out.println("Se completa: \nCuenta a debitar: " + cuentadebitar + "\nMoneda a pagar: " + monedapagar + "\nImporte: " + importe);
    	
    }

    @And("^Clickea pagar$")
    public void clickeaPagar() {
    	pm.implicitWait();
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	pm.implicitWait();
    	pm.esperarElemento("//div[contains(text(),'Confirmación de Pago')]");
    	pm.clickElement("//button[contains(text(),'Continuar')]");
    	System.out.println("Click en pagar.");
    }
    
    @Then("^Visualiza comprobante de pago$")
    public void visualizaComprobanteDePago()  {
    	assertTrue(pm.verificarPagoTC());
    	System.out.println("Finalización del test");
    }

}

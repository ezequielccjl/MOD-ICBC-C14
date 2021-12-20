package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

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

import com.icbc.segmento.digital.front.pom.BasePage;
import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class CardlessExtraction {
	
	int montoConst;
	PageModel pm = new PageModel();
	
	private String inputNumero = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-flex-layout/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String inputMonto = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-form-field[2]/div/ly-text-field/div/input";
	

    @Given("^El \"([^\"]*)\" hace log con \"([^\"]*)\"$")
    public void elSomethingHaceLogConSomething(String user, String password) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Extraccion sin Tarjeta");
    }

    @When("^Clickea pestania mas$")
    public void clickeaPestaniaMas() {
    	pm.esperarElemento("//button[contains(text(),'Quiero un nuevo producto')]");
    	pm.implicitWait();
    	pm.clickMas();
    	System.out.println("PRESIONA BOTON MAS-------------");
    }

    @Then("^Verifica orden completada$")
    public void verificaOrdenCompletada() {
    	System.out.println("Se hace verificación");
    	pm.implicitWait();
        Boolean montoSuperiorBool = pm.elementoDisponible("//span[contains(text(),'Superaste el monto máximo permitido.')]");
        System.out.println(montoSuperiorBool);
       	assertTrue(montoSuperiorBool);
       	if(montoSuperiorBool) {
       		System.out.println("VALIDACIÓN MONTO SUPERIOR COMPLETA.");
       	}
		
    }

    @And("^Selecciona Extraccion sin tarjeta$")
    public void seleccionaExtraccionSinTarjeta() {
    	pm.implicitWait();
    	pm.clickCardless();
    	System.out.println("PRESIONA BOTON EXTRACCION-------------");
    }

    @And("^Selecciona nueva extraccion$")
    public void seleccionaNuevaExtraccion() {
    	pm.implicitWait();
    	pm.clickNuevaOrden();
    	System.out.println("PRESIONA BOTON NUEVA EXTRACCION-------------");
    }

    @And("^Completa campos para verificar \"([^\"]*)\"$")
    public void completaCamposParaVerificarSomething(String montoinferior) {
    	pm.implicitWait();
    	pm.escribrirMonto(montoinferior);
    	
    	Boolean verificacion = pm.elementoDisponible("//div[contains(text(),'El monto mínimo permitido es 100')]");
    	assertTrue(verificacion);
    	if(verificacion) {
    		System.out.println("VALIDACIÓN MONTO INFERIOR COMPLETA.");
    	}
    }

    @And("^Completa correctamente \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" y presiona continuar$")
    public void completaCorrectamenteSomethingSomethingSomethingSomethingYPresionaContinuar(String origen, String monto, String tipo, String numero) {
    	
    	montoConst = Integer.parseInt(monto);
    	
    	pm.implicitWait();
    	pm.write(inputMonto, monto);
    	System.out.println("SE BORRA / MONTO: "+ monto);
    	
    	pm.implicitWait();
    	pm.write(inputNumero, numero);
    	
    	pm.implicitWait();
    	WebElement btnContinuar= pm.find("//button[contains(text(),'Continuar')]");
    	btnContinuar.click();
    	
    	pm.esperarElemento("//div[contains(text(),'Verificá los datos ingresados')]");
    	
    	WebElement btnContinuar2 = pm.find("//button[contains(text(),'Continuar')]");
    	btnContinuar2.click();
    	
    	pm.write("//input[@maxlength='5']", "11111");
    	
    	pm.clickElement("//button[contains(text(),'Generar')]");
    	
    }
    
}

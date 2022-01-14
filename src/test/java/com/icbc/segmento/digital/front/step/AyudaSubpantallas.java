package com.icbc.segmento.digital.front.step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class AyudaSubpantallas {
	
	PageModel pm = new PageModel();
	
	WebElement ingresarBtn;
	WebElement atras;
	private int cont = 0;
	
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";

	private String btnAtras = "/html/body/main[1]/div/app-root/ly-app-container/div/app-hiheader/ly-header/header/ly-header-nav/div/ly-icon/span";
	
	@Given("^El usuario hace el Login con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioHaceElLoginConSomethingSomething(String user, String password) {
		pm.navigateToFBD();
	    pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Ayuda Subpantallas");
    }

    @When("^Entra a la pestania mas y selecciona ayuda$")
    public void entraALaPestaniaMasYSeleccionaAyuda() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.implicitWait();
    	pm.clickMas();
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//li[contains(text(),'Ayuda')]");
    }

    @Then("^Verifica que la navegacion haya sido correcta$")
    public void verificaQueLaNavegacinHayaSidoCorrecta() {
    	assertEquals(3, cont);
    }

    @And("^Navega por preguntas frecuentes$")
    public void navegaPorPreguntasFrecuentes() {
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'Preguntas Frecuentes')]");
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//div[contains(text(),'¿Olvidaste tu usuario o tu clave de acceso?')]");
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//div[contains(text(),'comprobante obtengo de mis operaciones?')]");
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//div[contains(text(),'obtener la clave?')]");
    	
    	assertTrue(pm.elementIsDisplayed("//h3[contains(text(), 'Preguntas frecuentes')]"));
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted(btnAtras);
    	
    }

    @And("^Navega por terminos y condiciones$")
    public void navegaPorTerminosYCondiciones() {
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'Terminos y condiciones')]");
    	
    	pm.implicitWait();
    	
    	String bodyText = pm.devolverElemento("body").getText();

    	int count = 0;

    	while (bodyText.contains("Industrial and Commercial Bank of China (Argentina) S.A.")){

    		count++;
    		System.out.println(count);
    	    bodyText = bodyText.substring(bodyText.indexOf("Industrial and Commercial Bank of China (Argentina) S.A.") + "Industrial and Commercial Bank of China (Argentina) S.A.".length());
    	}
    	
    	if(count == 2) {
    		cont++;
    	}
    	System.out.println(count);
    	pm.implicitWait();
    	pm.clickElement(btnAtras);
        
    }

    @And("^Navega por politicas de privacidad$")
    public void navegaPorPoliticasDePrivacidad() {
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'Politicas de privacidad')]");
    	
    	pm.implicitWait();
    	pm.clickElement(btnAtras);
        
    }

    @And("^Navega por seguridad$")
    public void navegaPorSeguridad() {
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'Seguridad')]");
    	
    	pm.implicitWait();
    	pm.clickElement(btnAtras);
        
    }

    @And("^Navega por contacto$")
    public void navegaPorContacto() {
    	
    	pm.implicitWait();
    	pm.jseClickIntercepted("//span[contains(text(),'Contactos')]");
    	
    	pm.implicitWait();
    	
    	WebElement body = pm.driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();

    	if (bodyText.contains("Mesa de ayuda") && bodyText.contains("ICBC Mobile Banking y Access Banking") && bodyText.contains("0810-555-9200") && bodyText.contains("(54-11) 4820-9200") ){
    	    cont++;
    	}
    	
    	System.out.println("cuantas veces: " + cont);
    	
    	pm.implicitWait();
    	pm.clickElement(btnAtras);
        
    }

}



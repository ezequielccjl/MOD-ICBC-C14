package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.PageModel;

public class PantallaPoliticasPrivacidad {
	
	PageModel pm = new PageModel();
	
    @Given("^El usuario se loguea con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String password)  {
    	
		pm.navigateToFBD();
		pm.loginFBD(user, password);
		System.out.println("SE INGRESA A POLITICAS");
        
    }
    
    @When("Presiona la pestania Mas")
    public void presionaLaPestaniaMas() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.clickMas();
    }

    @And("^Selecciona ayuda$")
    public void seleccionaAyuda()  {
    	System.out.println("PRESIONA BOTON AYUDA-------------");
    	pm.implicitWait();
    	pm.jseClickIntercepted("//li[contains(text(),'Ayuda')]");
        
    }

    @And("^Selecciona politicas y privacidad$")
    public void seleccionaPoliticasYPrivacidad()  {
    	System.out.println("PRESIONA BOTON POLITICAS----------------");
    	pm.implicitWait();
    	pm.clickElement("//span[contains(text(),'Politicas de privacidad')]");
        
    }
    
    @Then("^Verifica que se encuentre en politicas y privacidad$")
    public void verificaQueSeEncuentreEnPoliticasYPrivacidad() throws InterruptedException  {
    	// get the text of the body element
    	Thread.sleep(2000);
    	WebElement body = pm.driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();
    	System.out.println(bodyText);

    	// count occurrences of the string
    	int cont = 0;

    	// search for the String within the text
    	while (bodyText.contains("Industrial and Commercial Bank of China (Argentina) S.A.")){

    	    // when match is found, increment the count
    	    cont++;

    	    // continue searching from where you left off
    	    bodyText = bodyText.substring(bodyText.indexOf("Industrial and Commercial Bank of China (Argentina) S.A.") + "Industrial and Commercial Bank of China (Argentina) S.A.".length());
    	}
    	System.out.println("cuantas veces: " + cont);
    	
    	assertEquals(2, cont);
    }

}

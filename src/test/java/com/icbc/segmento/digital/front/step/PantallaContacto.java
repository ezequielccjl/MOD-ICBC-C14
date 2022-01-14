package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.PageModel;

public class PantallaContacto {
	
	PageModel pm = new PageModel();
	
    @Given("^El usuario se logea con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String pass) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, pass);
	    System.out.println("Se ingresa: Pantalla Contacto");
    }

    @When("Presiona en la pestania Mas")
    public void presionaEnLaPestaniaMas() {
    	pm.esperarElemento("//h3[contains(text(),'¡Hola')]");
    	pm.implicitWait();
    	pm.clickMas();
    	System.out.println("PRESIONA BOTON MAS-------------");
    }

    @Then("^Verifica que se encuentre en Contacto$")
    public void verificaQueSeEncuentreEnContacto()  {
    	pm.implicitWait();
    	
    	pm.esperarElemento("//h3[contains(text(),'Teléfonos útiles')]");
    	pm.esperarElemento("//p[contains(text(),'Lunes a viernes de 8 a 20 hs y sábados y domingos de 10 a 16 hs')]");
    	pm.esperarElemento("//a[contains(text(),'0810-555-9200')]");
    	pm.esperarElemento("//a[contains(text(),'(54-11) 4820-9200')]");
    	
    	System.out.println("PRUEBA DE CONTACTO COMPLETADA");
        
    }

    @And("^Selecciona Contacto$")
    public void seleccionaContacto()  {
    	pm.implicitWait();
    	pm.clickContacto();
    	System.out.println("PRESIONA BOTON AYUDA-------------");
    }

}

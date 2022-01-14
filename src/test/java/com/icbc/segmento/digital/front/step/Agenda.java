package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class Agenda {
	PageModel pm = new PageModel();
    
    
    @Given("El usuario {string} {string} se encuentra en la app")
    public void elUsuarioSeEncuentraEnLaApp(String user, String pass) {
    	pm.navigateToFBD();
	    pm.loginFBD(user, pass);
	    System.out.println("Se ingresa: Agenda");
    }

    @When("Se dirige a agenda")
    public void seDirigeAAgenda() {
    	pm.implicitWait();
        pm.jseClickIntercepted("//span[contains(@class, 'icbc-icon-sub-menu')]");
        pm.implicitWait();
        pm.jseClickIntercepted("//li[contains(text(), 'Agenda')]");
    }

    @When("Selecciona crear un nuevo destinatario")
    public void seleccionaCrearUnNuevoDestinatario() {
    	pm.implicitWait();
    	pm.clickElement("//a[contains(text(), 'Nuevo destinatario')]");
    }

    @When("Completa {string} {string} y presiona continuar")
    public void completaYPresionaContinuar(String cvualias, String descripcion) {
    	pm.implicitWait();
    	pm.ingresarCBUAgenda(cvualias);
    	pm.ingresarTexto("//input[contains(@aria-label, 'Esté es un campo tipo Descripción')]", "PRUEBA TESTING AUTOMATICO");
    	pm.jseClickIntercepted("//button[contains(text(), 'Continuar')]");
    	
    	pm.implicitWait();
    	Boolean verificacion = pm.elementoDisponible("//div[contains(text(), 'Verificá los datos ingresados')]");
    	pm.implicitWait();
    	if (verificacion) {
    		pm.jseClickIntercepted("//button[contains(text(), 'Continuar')]");
		}
    	
    }

    @Then("Verifica que se haya agregado correctamente")
    public void verificaQueSeHayaAgregadoCorrectamente() {
    	pm.implicitWait();
    	Boolean verificacionFinal = pm.elementoDisponible("//span[contains(text(), 'Agendaste un nuevo destinatario.')]");
    	pm.implicitWait();
    	assertTrue(verificacionFinal);
    }


}

package com.icbc.segmento.digital.front.step;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	PageModel pm = new PageModel();
	
	@Given("Estoy en la pantalla de Login")
	public void estoyEnLaPantallaDeLogin() {
	    pm.navigateToFBD();
	}
	
	@When("Ingreso usuario {string} y verifico que no se pueda continuar")
	public void ingresoUsuarioYVerificoQueNoSePuedaContinuar(String caracteresEspeciales) {
	    pm.write("//input[contains(@aria-label, 'Esté es un campo tipo Usuario')]", caracteresEspeciales + Keys.TAB);
	    pm.implicitWait();
	    assertTrue(pm.elementoDisponible("//div[contains(text(), 'Letras y números, de 8 a 12 caracteres')]"));
	}


	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
		pm.implicitWait();
		pm.loginFBD(user, password);
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    System.out.println("CIERRA SESION");
	}

	@Then("Verifica {string} de su logueo")
	public void verificaDeSuLogueo(String respuestaEsperada) {
		if (respuestaEsperada.equals("loginCorrecto")) {
    		pm.implicitWait();
    		assertTrue(pm.elementoDisponible("//h3[contains(text(),'¡Hola')]"));
    		
		}else if (respuestaEsperada.equals("loginIncorrecto")) {
			pm.implicitWait();
			assertTrue(pm.elementoDisponible("//span[contains(text(),'No reconocemos esa combinación de usuario y clave.')]"));
		}
	}

}

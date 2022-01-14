package com.icbc.segmento.digital.front.step;

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

	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
		pm.loginFBD(user, password);
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    System.out.println("CIERRA SESION");
	}

}

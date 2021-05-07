package stepDefinitionsFront;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusquedaSteps {

	WebDriver driver;
	  
    @Given("El usuario esta en la pagina de google")
    public void el_usuario_esta_en_la_pagina_de_google() throws InterruptedException, IOException {
    	LauncherSelenium.navegador("Busqueda en google");
    }

    @When("^Ingresa la busqueda$")
    public void ingresa_la_busqueda() {

    	driver.findElement(By.name("q")).sendKeys("Facebook");
    	
    }

    @Then("^valida que la busqueda este ok$")
    public void valida_que_la_busqueda_este_ok() {

    	driver.findElement(By.xpath("//a[contains(text(),'Facebook - Inicia sesión o regístrate')]")).click();	    	
    }

    @And("^hace click en buscar$")
    public void hace_click_en_buscar() {
    	driver.findElement(By.name("btnK")).click();
    }
}

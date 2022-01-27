package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.pom.PageModel;

public class ConsultaAliasCBU {
	
	PageModel pm = new PageModel();
	
    @Given("^El usuario hace el login con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioHaceElLoginConSomethingSomething(String user, String password) {

		pm.navigateToFBD();
		pm.loginFBD(user, password);
	    System.out.println("Se ingresa: Consulta Alias-CBU");
        
    }

    @When("^Ingresa a cbu alias qr$")
    public void ingresaACbuAliasQr() throws InterruptedException {
    	pm.implicitWait();
    	pm.clickElement("//button[contains(text(),'CBU-ALIAS-QR')]");
    }
    
    @Then("Verifica {string} {string}")
    public void verifica(String alias, String cbu) {
    	
    	System.out.println("VERIFICACION DE CBU");
    	
    	pm.implicitWait();
    	Boolean cbuDisp = pm.elementoDisponible("//span[contains(text(), '"+cbu+"')]");
    	
    	assertTrue(cbuDisp);
    	
    }
}

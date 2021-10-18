package com.icbc.segmento.digital.front.step;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions()
public class PagarTarjetaCredito {

	PageModel page = new PageModel();
		
    @Given("^El usuario se logea con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String password, String strArg1, String strArg2) {
        page.navigateToDEV();
        page.ingresarUsuario(user);
        page.ingresarContraseña(password);
    }

    @When("^El usuario clickea en pagar$")
    public void elUsuarioClickeaEnPagar() {
        
    }

    @Then("^Visualiza comprobante de pago$")
    public void visualizaComprobanteDePago() {
        
    }

    @And("^Selecciona \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" y clickea continuar$")
    public void seleccionaSomethingSomethingSomethingYClickeaContinuar(String cuentadebitar, String monedapagar, String importe, String strArg1, String strArg2, String strArg3) {
        
    }

    @And("^Clickea pagar$")
    public void clickeaPagar() {
        
    }

}
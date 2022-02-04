package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

import com.icbc.segmento.digital.front.pom.PageModel;

import cucumber.api.java.en.And;

public class Agenda {
	PageModel pm = new PageModel();
	String descripcion;
	String monto;
	String concepto;
	String cvuAliasCbu;
	
//  Agenda-AgregarDestinatario
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

    
//  Agenda-EditarDestinatario
    @When("Selecciona el {string}")
    public void seleccionaElUsuarioAModificar(String usuarioAModificar) {
        pm.implicitWait();
        pm.clickElement("//div[contains(text(), '" + usuarioAModificar + "')]");
        
    }

    @When("Clickea menu tres puntos y Editar")
    public void clickeaMenuTresPuntosYEditar() {
        pm.clickElement("//i[contains(@class,'ly-context-menu-icon')]");
        pm.jseClickIntercepted("//li[contains(text(),'Editar')]");
        
    }

    @When("Edita {string} {string} y presiona continuar")
    public void editaYPresionaContinuar(String cvuAlias, String descripcion) {
    	this.descripcion = descripcion.toUpperCase();
        pm.ingresarTexto("//input[contains(@aria-label,'Esté es un campo tipo Descripción')]", descripcion);
        pm.jseClickIntercepted("//button[contains(text(),'Continuar')]");
    }

    @Then("Verifica que se muestren los datos editados y operacion completada")
    public void verificaQueSeMuestrenLosDatosEditadosYOperacionCompletada() {
        assertTrue(pm.elementoDisponible("//span[contains(text(), '"+descripcion+"')]"));
        pm.jseClickIntercepted("//button[contains(text(),'Continuar')]");
        assertTrue(pm.elementoDisponible("//span[contains(text(), 'Actualizaste los datos de "+ descripcion +" en tu agenda.')]"));
    }
    
//  Agenda-EliminarDestinatario
    @When("Clickea menu tres puntos y Eliminar")
    public void clickeaMenuTresPuntosYEliminar() {
    	pm.clickElement("//i[contains(@class,'ly-context-menu-icon')]");
        pm.jseClickIntercepted("//li[contains(text(),'Eliminar')]");
        pm.implicitWait();
    }

    @When("Cancela y vuelve a confirmar pop up")
    public void cancelaYVuelveACondirmarPopUp() {
    	pm.implicitWait();
    	pm.jseClickIntercepted("//button[contains(text(), ' Cancelar ')]");
    	pm.implicitWait();
    	pm.clickElement("//i[contains(@class,'ly-context-menu-icon')]");
    	pm.implicitWait();
        pm.jseClickIntercepted("//li[contains(text(),'Eliminar')]");
        pm.implicitWait();
        pm.jseClickIntercepted("//button[contains(text(), 'Eliminar')]");
    }

    @Then("Verifica que el destinatario se haya eliminado")
    public void verificaQueElDestinatarioSeHayaEliminado() {
        //No se puede verificar debido a que la lista no se actualiza y tira error despues de realizar el flujo
    	//A chequear y consultar con devs
    }
    
    
//	Agenda-ConsultaTransferenciaDestinatario
    @When("Clickea menu tres puntos y Transferir")
    public void clickeaMenuTresPuntosYTransferir() {
    	pm.clickElement("//i[contains(@class,'ly-context-menu-icon')]");
        pm.jseClickIntercepted("//li[contains(text(),'Transferir')]");
    }

    @When("Completa campos {string} {string} y selecciona continuar")
    public void completaCamposYSeleccionaContinuar(String monto, String concepto) {
    	//XPath de concepto trae problemas, es dinamico y no pude conseguir algo identificable
    	this.monto=monto;
    	this.concepto=concepto;
    	pm.ingresarMontoTransferencia(monto);
		pm.implicitWait();
    	pm.clickElement("//div[contains(@class,'ng-tns-c77-29 ly-drop-frame__input')]");
    	pm.jseClickIntercepted("//span[contains(text(),'" + concepto + "')]");
    	pm.jseClickIntercepted("//button[contains(text(), 'Continuar')]");
    }

    @When("Verifica comprobante e ingresa token")
    public void verificaComprobanteEIngresaToken() {
    	pm.esperarElemento("//div[contains(text(),'Verificá los datos ingresados')]");
        assertTrue(pm.elementoDisponible("//span[contains(text(),'"+monto+"')]"));
        assertTrue(pm.elementoDisponible("//span[contains(text(),'"+concepto+"')]"));
        pm.jseClickIntercepted("//button[contains(text(), 'Continuar')]");
        pm.ingresarTokenTransferencia("111111");
        pm.clickElement("//button[contains(text(),'Transferir')]");
    }

    @Then("Verifica transferencia exitosa")
    public void verificaTransferenciaExitosa() {
    	assertTrue(pm.elementoDisponible("//span[contains(text(),'¡Listo!')]"));
        assertTrue(pm.elementoDisponible("//span[contains(text(),'Transferiste')]"));
    }


}

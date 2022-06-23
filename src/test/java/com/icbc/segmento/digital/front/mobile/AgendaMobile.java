package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgendaMobile {

	//IOS
	String btnTresPuntosIOS = "(//XCUIElementTypeButton[@name=\"sub-menu\"])[1]";
	String agendaIOS = "//XCUIElementTypeStaticText[@name=\"Agenda\"]";
	String nuevoDestinatarioIOS = "//XCUIElementTypeStaticText[@name=\"Nuevo destinatario\"]";
	String identificacionDeCuentaIOS = "//XCUIElementTypeStaticText[@name=\"Identificación de cuenta\"]";
	String ingresarCBUCVUAliasIOS = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo CBU-CVU-Alias\"]";
	String descripcionAgendaIOS = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Descripción\"]";
	String continuarAgendaIOS = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	String continuarVerificaLosDatosIOS = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]";
	String listoIOS = "//XCUIElementTypeStaticText[@name=\"¡Listo!\"]";
	String agregasteUnNuevoDestinatarioIOS = "//XCUIElementTypeStaticText[@name=\"Agendaste un nuevo destinatario.\"]";
	String tresPuntosAgendaIOS = "(//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name, \"";               
	String tresPuntosAgenda2IOS = "\")]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeButton[@name=\"sub-menu\"])[1]";
	String editarDestinatarioIOS = "//XCUIElementTypeStaticText[@name=\"Editar\"]";
	String eliminarDestinatarioIOS = "//XCUIElementTypeStaticText[@name=\"Eliminar\"]";
	String cancelarEliminacionIOS = "//XCUIElementTypeButton[@name=\"Cancelar\"]";
	String confirmarEliminacionIOS = "//XCUIElementTypeButton[@name=\"Eliminar\"]";
	String popUpEliminacionIOS = "//XCUIElementTypeOther[@name=\"web dialog\"]";
	String eliminasteADeTuAgendaIOS = "//XCUIElementTypeStaticText[contains(@name,\"Eliminaste a\") and contains(@name, \"de tu agenda.\")]";
	String cbucvualiasEditarIOS = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo CBU-CVU-Alias\"]";	
	String descripcionEditarIOS = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Descripción\"]";
	String btnNextIOS = "//XCUIElementTypeButton[@name=\"Next\"]";
	String btnDoneIOS = "//XCUIElementTypeButton[@name=\"Done\"]";
	String actualizasteLosDatosIOS = "//XCUIElementTypeStaticText[contains (@name, \"Actualizaste los datos de\") and contains(@name, \"en tu agenda.\")]";
	String cbucvualiasIOS = "//XCUIElementTypeStaticText[@name=\"";
	String cbucvualias2IOS = "\"]";
	String checkAgregarDestinatarioAMiAgenda = "(//XCUIElementTypeSwitch[@name=\"Agregar destinatario a mi agenda\"])[1]";
	
	//Verificacion Datos Ingresados IOS 
	String verificaLosDatosIngresadosIOS = "//XCUIElementTypeStaticText[@name=\"Verificá los datos ingresados\"]";
	String lblDescripcionIOS = "//XCUIElementTypeStaticText[@name=\"Descripción\"]";
	String descripcionDatoIOS = "//XCUIElementTypeStaticText[@name=\"Nombre\"]/../preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[not (@name = \"Descripción\")]";
	String lblNombreIOS = "//XCUIElementTypeStaticText[@name=\"Nombre\"]";
	String lblCBUIOS = "//XCUIElementTypeStaticText[@name=\"CBU\"]";
	String lblAliasIOS = "//XCUIElementTypeStaticText[@name=\"Alias\"]";
	String lblCuentaIOS = "//XCUIElementTypeStaticText[@name=\"Cuenta\"]";
	String lblBancoIOS = "//XCUIElementTypeStaticText[@name=\"Banco\"]";
	String lblCUITCUILIOS = "//XCUIElementTypeStaticText[@name=\"CUIT/CUIL\"]";
	String lblTitularidadIOS = "//XCUIElementTypeStaticText[@name=\"Titularidad\"]";
	String CBUDatoIOS = "(//XCUIElementTypeOther[@name=\"article\"])[2]/XCUIElementTypeOther[7]/XCUIElementTypeStaticText";
	
	//Detalle Destinatario IOS
	String detalleDeDestinatarioIOS = "//XCUIElementTypeStaticText[@name=\"Detalle de destinatario\"]";
	String nombreIOS = "(//XCUIElementTypeOther[@name=\"main\"])[1]/XCUIElementTypeOther[4]/XCUIElementTypeStaticText";
	String descripcionIOS = "(//XCUIElementTypeOther[@name=\"main\"])[1]/XCUIElementTypeOther[6]/XCUIElementTypeStaticText";
	String lblCVUIOS = "//XCUIElementTypeStaticText[@name=\"CVU\"]";
	String cvuDetalleIOS = "((//XCUIElementTypeOther[@name=\"main\"])[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"CVU\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblEmpresaIOS = "//XCUIElementTypeStaticText[@name=\"Empresa\"]";
	String empresaIOS = "(//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Empresa\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblMonedaIOS = "//XCUIElementTypeStaticText[@name=\"Moneda\"]";
	String monedaIOS = "(//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Moneda\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String cuitcuilIOS = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"CUIT/CUIL\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";
	String tresPuntosDetalleIOS = "//XCUIElementTypeButton[@name=\"sub-menu\"]";
	String transferirAgendaIOS = "//XCUIElementTypeStaticText[@name=\"Transferir\"]";
	String iconoEditarIOS = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Editar\"]/../preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";
	String iconoTransferirIOS = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Transferir\"]/../preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";
	String iconoEliminarIOS = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Eliminar\"]/../preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";
	
	//------------------------------------------------------------------
	
	String btnTresPuntosAndroid = "//android.widget.Button[@text='sub-menu']";
	String agendaAndroid = "//android.view.View[contains(@text,'Agenda')]";
	String nuevoDestinatarioAndroid = "//android.view.View[contains(@text,'Nuevo destinatario')]";
//	String identificacionDeCuentaAndroid = "//XCUIElementTypeStaticText[@name=\"Identificación de cuenta\"]";
	String ingresarCBUCVUAliasAndroid = "(//android.widget.EditText)[1]";
	String descripcionAgendaAndroid = "(//android.widget.EditText)[2]";
	String continuarAgendaAndroid = "//android.widget.Button[@text='Continuar']";
	String continuarVerificaLosDatosAndroid = "//android.widget.Button[@text='Continuar']";
	String listoAndroid = "//android.widget.TextView[@text='¡Listo!']";
	String agregasteUnNuevoDestinatarioAndroid = "//android.widget.TextView[@text='Agendaste un nuevo destinatario.']";
	String tresPuntosAgendaAndroid = "(//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name, \"";               
	String tresPuntosAgenda2Android = "\")]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeButton[@name=\"sub-menu\"])[1]";
	String editarDestinatarioAndroid = "(//android.view.View[contains(@text,'Editar')])[2]";
	String eliminarDestinatarioAndroid = "(//android.view.View[contains(@text,'Eliminar')])[2]";
	String cancelarEliminacionAndroid = "//android.widget.Button[@text='Cancelar']";
	String confirmarEliminacionAndroid = "//android.widget.Button[@text='Eliminar']";
	String popUpEliminacionAndroid = "//XCUIElementTypeOther[@name=\"web dialog\"]";
	String eliminasteADeTuAgendaAndroid = "//XCUIElementTypeStaticText[contains(@name,\"Eliminaste a\") and contains(@name, \"de tu agenda.\")]";
	String cbucvualiasEditarAndroid = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo CBU-CVU-Alias\"]";	
	String descripcionEditarAndroid = "//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Descripción\"]";
	String btnNextAndroid = "//XCUIElementTypeButton[@name=\"Next\"]";
	String btnDoneAndroid = "//XCUIElementTypeButton[@name=\"Done\"]";
	String actualizasteLosDatosAndroid = "//XCUIElementTypeStaticText[contains (@name, \"Actualizaste los datos de\") and contains(@name, \"en tu agenda.\")]";
	String cbucvualiasAndroid = "//android.widget.TextView[@text='";
	String cbucvualias2Android = "']";
	String checkAgregarDestinatarioAMiAgendaAndroid  = "//android.widget.Image";
	
	String buscador = "//android.widget.EditText";
	String transferirAgendaAndroid = "//android.widget.Button[contains(@text,'Transferir')]";
	
	//Verificacion Datos Ingresados Android 
	String verificaLosDatosIngresadosAndroid = "//android.widget.TextView[@text='Verificá los datos ingresados']";
	String lblDescripcionAndroid = "//android.widget.TextView[@text='Descripción']";
	String descripcionDatoAndroid = "";
	String lblNombreAndroid = "//android.widget.TextView[@text='Nombre']";
	String lblCBUAndroid = "//android.widget.TextView[@text='CBU']";
	String lblAliasAndroid = "//android.widget.TextView[@text='Alias']";
	String lblCuentaAndroid = "//android.widget.TextView[@text='Cuenta']";
	String lblBancoAndroid = "//android.widget.TextView[@text='Banco']";
	String lblCUITCUILAndroid = "//android.widget.TextView[@text='CUIT/CUIL']";
	String lblTitularidadAndroid = "//android.widget.TextView[@text='Titularidad']";
	String CBUDatoAndroid = "";
	
	
//AgendaMobile_caso001 - Agregar destinatario desde agenda
	
	@When("Voy a agenda")
	public void irAAgenda() throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(8000);
			Hooks.getDriver().findElement(By.xpath(btnTresPuntosAndroid)).click();
			Hooks.click(agendaAndroid);
		}else {
			Hooks.getDriver().findElement(By.xpath(btnTresPuntosIOS)).click();				
			Hooks.getDriver().findElement(By.xpath(agendaIOS)).click();
		}
	}

	@When("Voy a la opcion Nuevo destinatario")
	public void voyALaOpcionNuevoDestinatario() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioIOS)).click();
		}
	}
	
	@When("Completa {string} {string}")
	public void completarCBUCVUAliasYDescripcion(String cvualias, String descripcion) throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(4000);
			Hooks.getDriver().findElement(By.xpath(ingresarCBUCVUAliasAndroid)).sendKeys(cvualias);
			Hooks.getDriver().findElement(By.xpath(descripcionAgendaAndroid)).sendKeys(descripcion);
//			Hooks.getDriver().findElement(By.xpath(ingresarCBUCVUAliasAndroid)).sendKeys(cvualias);
			
		}else {
			Hooks.getDriver().findElement(By.xpath(ingresarCBUCVUAliasIOS)).sendKeys(cvualias);
			Hooks.getDriver().findElement(By.xpath(descripcionAgendaIOS)).sendKeys(descripcion);
			Hooks.getDriver().findElement(By.xpath(btnDoneIOS)).click();
		}
	}
	
	@When("Presiona continuar y confirma los datos ingresados {string} {string}")
	public void continuarYConfirmarDatos(String cvualias, String descripcion) throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(2000);
			Hooks.getDriver().findElement(By.xpath(continuarAgendaAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(continuarAgendaIOS)).click();
			assertEquals(Hooks.getDriver().findElement(By.xpath(verificaLosDatosIngresadosIOS)).isEnabled(), true);
			if(Hooks.getDriver().findElement(By.xpath(descripcionDatoIOS)).getAttribute("name").equals(descripcion)) {
				System.out.println("La descripcion en la verificacion de datos coincide");
			}else {
				System.out.println("La descripcion en la verificacion de datos NO coincide");				
			}
			if(Hooks.getDriver().findElement(By.xpath(CBUDatoIOS)).getAttribute("name").equals(cvualias)) {
				System.out.println("El cbu/cvu/alias en la verificacion de datos coincide");
			}else {
				System.out.println("El cbu/cvu/alias en la verificacion de datos NO coincide");				
			}
			Hooks.getDriver().findElement(By.xpath(continuarVerificaLosDatosIOS)).click();
		}
	}
	
	@Then("Verifica que se haya agregado el destinatario {string} {string}")
	public void verificarDestinatarioAgregado(String cbucvualias, String descripcion) {
		descripcion.toUpperCase();
		if (Hooks.esAndroid()) {
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoAndroid)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(agregasteUnNuevoDestinatarioAndroid)).isEnabled(), true);
		}else {
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(agregasteUnNuevoDestinatarioIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + cbucvualias + cbucvualias2IOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + descripcion + cbucvualias2IOS)).isEnabled(), true);
		}
	}
	
//AgendaMobile_caso002 - Agregar destinatario desde transferencia
	
	//Steps relacionados a transferencia en su respectiva Clase
	
	@When("Aprieta el check de agregar destinatario a mi agenda")
	public void agregarDestinatarioAMiAgenda() {
		if (Hooks.esAndroid()) {
			Hooks.click(checkAgregarDestinatarioAMiAgendaAndroid);
		}else {
			Hooks.getDriver().findElement(By.xpath(checkAgregarDestinatarioAMiAgenda)).click();
		}
	}
	
	@When("Presiona continuar")
	public void continuarAgenda() {
		if (Hooks.esAndroid()) {
			Hooks.click(continuarAgendaAndroid);
		}else {
			Hooks.getDriver().findElement(By.xpath(continuarAgendaIOS)).click();
		}	
	}
	
//AgendaMobile_caso003 - Editar un edstinatario
	
	@When("Aprieta el boton tres puntos del {string}")
	public void apretarBotonTresPuntosAgenda(String cvucbualias) {
		if (Hooks.esAndroid()) {

		}else {
			System.out.println(tresPuntosAgendaIOS + cvucbualias + tresPuntosAgenda2IOS);
			Hooks.getDriver().findElement(By.xpath(tresPuntosAgendaIOS + cvucbualias + tresPuntosAgenda2IOS)).click();
		}
	}
	
	@When("Aprieta el boton editar")
	public void apretarEditar() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(editarDestinatarioAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(editarDestinatarioIOS)).click();
		}
	}
	
	@When("Edita el campo de cvucbualias con {string} y la descripcion con {string}")
	public void editarDestinatario(String nuevocvucbualias, String descripcion) {
		if (Hooks.esAndroid()) {

		}else {
			Hooks.getDriver().findElement(By.xpath(cbucvualiasEditarIOS)).clear();
			Hooks.getDriver().findElement(By.xpath(cbucvualiasEditarIOS)).sendKeys(nuevocvucbualias);
			Hooks.getDriver().findElement(By.xpath(btnNextIOS)).click();
			Hooks.getDriver().findElement(By.xpath(descripcionEditarIOS)).clear();
			Hooks.getDriver().findElement(By.xpath(descripcionEditarIOS)).sendKeys(descripcion);
			Hooks.getDriver().findElement(By.xpath(btnDoneIOS)).click();
			Hooks.getDriver().findElement(By.xpath(continuarAgendaIOS)).click();
			Hooks.getDriver().findElement(By.xpath(continuarAgendaIOS)).click();
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(actualizasteLosDatosIOS)).isEnabled(), true);
		}
	}
	
	@Then("Verifica la actualizacion de destinatario {string} {string}")
	public void validarActualizacionDestinatario(String nuevocvucbualias, String descripcionEditada) {
		descripcionEditada.toUpperCase();
		if (Hooks.esAndroid()) {

		}else {
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(actualizasteLosDatosIOS)).isEnabled(), true);			
			assertEquals(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + nuevocvucbualias + cbucvualias2IOS)).isEnabled(), true);			
			assertEquals(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + descripcionEditada + cbucvualias2IOS)).isEnabled(), true);			
		}
	}
	
//AgendaMobile_caso004 - VER DETALLE DE DESTINATARIO

	@When("Selecciono el {string}")
	public void seleccionarCBUCVUAlias(String cvucbualias) {
		if (Hooks.esAndroid()) {

		}else {
			Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + cvucbualias + cbucvualias2IOS)).click();
		}
	}
	
	@Then("Valido el detalle {string}")
	public void validarActualizacionDestinatario(String nuevocvucbualias) {
		if (Hooks.esAndroid()) {

		}else {
			assertEquals(Hooks.getDriver().findElement(By.xpath(detalleDeDestinatarioIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblNombreIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(nombreIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(nombreIOS)).getAttribute("name"));
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblDescripcionIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(descripcionIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(descripcionIOS)).getAttribute("name"));
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblCVUIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(cvuDetalleIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(cvuDetalleIOS)).getAttribute("name"));
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblEmpresaIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(empresaIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(empresaIOS)).getAttribute("name"));
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblMonedaIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(monedaIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(monedaIOS)).getAttribute("name"));
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblCUITCUILIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(cuitcuilIOS)).isEnabled(), true);
			System.out.println(Hooks.getDriver().findElement(By.xpath(cuitcuilIOS)).getAttribute("name"));
			
			Hooks.getDriver().findElement(By.xpath(tresPuntosDetalleIOS)).click();
			assertEquals(Hooks.getDriver().findElement(By.xpath(iconoEditarIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(editarDestinatarioIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(iconoTransferirIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(transferirAgendaIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(iconoEliminarIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(eliminarDestinatarioIOS)).isEnabled(), true);
		}
	}
	
//AgendaMobile_caso005 - ELIMINAR DESTINATARIO

	@When("Aprieta el boton eliminar y cancela")
	public void apretarCancelar() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(eliminarDestinatarioAndroid)).click();
			Hooks.getDriver().findElement(By.xpath(cancelarEliminacionAndroid)).click();
			Hooks.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertEquals(Hooks.getDriver().findElement(By.xpath(popUpEliminacionIOS)).isEnabled(), null);
			Hooks.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else {
			Hooks.getDriver().findElement(By.xpath(eliminarDestinatarioIOS)).click();
			Hooks.getDriver().findElement(By.xpath(cancelarEliminacionIOS)).click();
			Hooks.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertEquals(Hooks.getDriver().findElement(By.xpath(popUpEliminacionIOS)).isEnabled(), null);
			Hooks.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@When("Aprieta el boton eliminar y confirma eliminacion")
	public void apretarEliminar() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(eliminarDestinatarioAndroid)).click();
			Hooks.getDriver().findElement(By.xpath(confirmarEliminacionAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(eliminarDestinatarioIOS)).click();
			Hooks.getDriver().findElement(By.xpath(confirmarEliminacionIOS)).click();
		}
	}

	@Then("Valida eliminacion del destinatario {string}{string}")
	public void validarEliminacion(String cbucvualias, String nombreAgendado) {
		nombreAgendado.toUpperCase();
		if (Hooks.esAndroid()) {

		}else {
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(eliminasteADeTuAgendaIOS)).isEnabled(), true);
			Hooks.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertNull(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + cbucvualias + cbucvualias2IOS)));
			assertNull(Hooks.getDriver().findElement(By.xpath(cbucvualiasIOS + nombreAgendado + cbucvualias2IOS)));
		}
	}
}

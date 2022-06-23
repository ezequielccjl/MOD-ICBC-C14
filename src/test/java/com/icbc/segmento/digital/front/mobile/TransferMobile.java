package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TransferMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	//ANDROID
	String transferirAndroid = "//android.widget.Button[contains(@text, \"Transferir\")]";
	String destinoAndroid = "//android.view.View[@text = \"Destino\"]";
	String campoMontoAndroid = "(//android.widget.EditText)[1]";
	String ConceptoAndroid = "//android.view.View[@text = \"Concepto\"]";
	String btnContinuarAndroid = "//android.widget.Button[@text = \"Continuar\"]";
	String btnContinuarVerificacionDatosAndroid = "//android.widget.Button[@text = \"Continuar\"]";
	String campoCodigoAprobacionAndroid = "//android.widget.EditText";
	String btnTransferirAndroid = "//android.widget.Button[@text = \"Transferir\"]";
	
	//Comprobante Transferir Android
	String listoTransferAndroid = "";
	String transferisteAndroid = "";
	String hacerOtraTransferenciaAndroid = "";
	
	//Agenda Transfer ANDROID
	String nuevoDestinatarioAndroid = "//android.view.View[contains(@text, \"Nuevo destinatario\")]";
	String campoCVUCBUAliasAndroid = "(//android.widget.EditText)[1]";
	String campoDescripcionAgendaAndroid = "(//android.widget.EditText)[2]";
	String checkAgregarAAgendaAndroid = "//android.widget.Image";
	String btnContinuarAgendaAndroid = "//android.widget.Button[@text = \"Continuar\"]";
	
	//IOS
	String transferirIOS = "//XCUIElementTypeButton[contains(@name,'Transferir')]";
	String origenIOS = "//XCUIElementTypeStaticText[@name=\"Origen\"]";
	String destinoIOS = "(//XCUIElementTypeStaticText[@name='Destino'])[1]";
	String campoMontoIOS = "(//XCUIElementTypeTextField[@name='Est es un campo tipo Monto en $'])[1]";
	String flechaConceptoIOS = "(//XCUIElementTypeStaticText[@width = 15 and @height = 17])[3]";
	String btnContinuarIOS = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]";
	String btnContinuarVerificacionDatosIOS = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]";
	String campoCodigoAprobacionIOS = "//XCUIElementTypeTextField[@name=\"Est es un campo tipo Cd. aprob.\"]";
	String btnTransferirIOS = "//XCUIElementTypeButton[@name=\"Transferir\"]";

	//Tarjeta Coordenadas IOS
	String lblCoordenadasIOS = "//XCUIElementTypeStaticText[@name=\"Ingres los valores indicados de tu tarjeta de coordenadas en los siguientes campos:\"]";
	String coordenada1IOS = "(//XCUIElementTypeTextField[@name=\"Est es un campo tipo \"])[1]";
	String coordenada2IOS = "(//XCUIElementTypeTextField[@name=\"Est es un campo tipo \"])[2]";
	
	//Agenda Transfer IOS
	String nuevoDestinatarioIOS = "(//XCUIElementTypeStaticText[@name='Nuevo destinatario'])[1]";
	String campoCVUCBUAliasIOS = "(//XCUIElementTypeTextField[@name='Est es un campo tipo CBU-CVU-Alias'])[1]";
	String campoDescripcionAgendaIOS = "(//XCUIElementTypeTextField[@name='Est es un campo tipo Descripcin'])[1]";
	String checkAgregarAAgendaIOS = "(//XCUIElementTypeSwitch[@name=\"Agregar destinatario a mi agenda\"])[1]";
	String btnContinuarAgendaIOS = "(//XCUIElementTypeButton[@name='Continuar'])[1]";

	//Comprobante Transferencia
	String iconoListoTransferenciaIOS = "((//XCUIElementTypeOther[@name=\"main\"])[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Listo!\"]/../preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String listoTransferenciaIOS = "(//XCUIElementTypeStaticText[@name=\"Listo!\"])[1]";
	String transferisteIOS = "(//XCUIElementTypeStaticText[@name=\"Transferiste.\"])[1]";
	String hacerOtraTransferenciaIOS = "(//XCUIElementTypeButton[@name=\"Hacer otra transferencia\"])[1]";
	String comprobanteDeTransferenciaIOS = "(//XCUIElementTypeStaticText[@name=\"Comprobante de transferencia\"])[1]";
	String datosDeOrigenIOS = "(//XCUIElementTypeOther[@name=\"Datos de origen\"])[1]";
	String mensajeCBUInvalido = "//android.view.View";
	String lblNombreOrigenComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Nombre\"])[1]";
	String nombreOrigenComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Nombre\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblCuentaComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Cuenta\"])[1]";
	String cuentaComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Cuenta\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String datosDeDestinoIOS = "(//XCUIElementTypeOther[@name=\"Datos de destino\"])[1]";
	String lblCBUComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"CBU\"])[1]";
	String cbuComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"CBU\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblNombreDestinoComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Nombre\"])[2]";
	String nombreDestinoComprobanteIOS = "((//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Nombre\"])[2]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblCUITCUILComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"CUIT/CUIL\"])[1]";
	String cuitcuilComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"CUIT/CUIL\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String lblBancoComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Banco\"])[1]";
	String bancoComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Banco\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String datosDeLaOperacionIOS = "(//XCUIElementTypeStaticText[@name=\"Datos de la operacin\"])[1]";
	String lblMontoComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Monto\"])[1]";
	String signoComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Monto\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String montoComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Monto\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[2]";
	String decimalesComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Monto\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[3]";
	String lblConceptoComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Concepto\"])[1]";
	String conceptoComprobanteIOS = "(//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Concepto\"]/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	String descripcionFinalComprobanteIOS = "(//XCUIElementTypeStaticText[@name=\"Sujeto a impuestos y comisiones determinadas por tu banco. La transferencia se curso al destino de forma inmediata.\"])[1]";
	String btnCompartirComprobanteIOS = "(//XCUIElementTypeButton[@name=\"Compartir\"])[1]";
	
	
	//TransferMobile-SinAgregarDestinatario
	@When("Presiona en el boton Transferir")
	public void presionaEnElBotonTransferir() throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(4000);
			Hooks.getDriver().findElement(By.xpath(transferirAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(transferirIOS)).click();
		}
	}

	@When("Seleccina destino y agrega nuevo destinatario con {string}")
	public void seleccinaDestinoYAgregaNuevoDestinatarioCon(String cbu) {

		if (Hooks.esAndroid()) {
			MobileElement lblDestino = Hooks.getDriver().findElementByXPath(destinoAndroid);
			int locationXlblDestino = lblDestino.getLocation().getX() + 15;
			int locationYlblDestino = lblDestino.getLocation().getY() + 20;
			new TouchAction(driver).press(PointOption.point(locationXlblDestino, locationYlblDestino)).release().perform();
			
			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioAndroid)).click();
			
			Hooks.getDriver().findElement(By.xpath(campoCVUCBUAliasAndroid)).sendKeys(cbu);
			Hooks.getDriver().findElement(By.xpath(campoDescripcionAgendaAndroid)).sendKeys("PRUEBA TEST");
			
		}else {

			MobileElement lblDestino = Hooks.getDriver().findElementByXPath(destinoIOS);
			int locationXlblDestino = lblDestino.getLocation().getX() + 15;
			int locationYlblDestino = lblDestino.getLocation().getY() + 20;
			new TouchAction(driver).press(PointOption.point(locationXlblDestino, locationYlblDestino)).release().perform();

			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioIOS)).click();
			Hooks.getDriver().findElement(By.xpath(campoCVUCBUAliasIOS)).sendKeys(cbu);
			Hooks.getDriver().findElement(By.xpath(campoDescripcionAgendaIOS)).sendKeys("PRUEBA TEST");
			Hooks.getDriver().findElement(By.xpath(btnContinuarAgendaIOS)).click();
		}
	}

	@When("Selecciona {string} {string} {string}")
	public void selecciona(String origen, String monto, String concepto) throws InterruptedException {
		String origenTransferIOS = "//XCUIElementTypeStaticText[@name=\"" + origen + "\"]";
		String conceptoTransferIOS = "//XCUIElementTypeStaticText[@name=\"" + concepto + "\"]";
		String conceptoTransferAndroid= "//android.widget.ListView/android.view.View[@text = \"" + concepto + "\"]";
		//		(//XCUIElementTypeOther[@name="main"])[1]/XCUIElementTypeOther[7]

		//Seleccionar destino
		//Hooks.getDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name='main'])[1]/XCUIElementTypeOther[7]")).click();
		//Hooks.getDriver().findElement(By.xpath("(//XCUIElementTypeStaticText[@name='AGENDAR'])[2]")).click();
		if (Hooks.esAndroid()) {
			Thread.sleep(2000);
			Hooks.getDriver().findElement(By.xpath(campoMontoAndroid)).sendKeys(monto);		
			Hooks.getDriver().findElement(By.xpath(ConceptoAndroid)).click();
			Hooks.getDriver().findElement(By.xpath(conceptoTransferAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(campoMontoIOS)).sendKeys(monto);		
			Hooks.getDriver().findElement(By.xpath(flechaConceptoIOS)).click();
			Hooks.getDriver().findElement(By.xpath(conceptoTransferIOS)).click();
		}
	}

	@When("Presiona continuar ingresa token y confirma transferencia")
	public void presionaContinuarIngresaTokenYConfirmaTransferencia() throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(2000);
			Hooks.getDriver().findElement(By.xpath(btnContinuarAndroid)).click();
			Thread.sleep(2000);
			Hooks.getDriver().findElement(By.xpath(btnContinuarVerificacionDatosAndroid)).click();
			Hooks.getDriver().findElement(By.xpath(campoCodigoAprobacionAndroid)).sendKeys("111111");		
			Hooks.getDriver().findElement(By.xpath(btnTransferirAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(btnContinuarIOS)).click();
			Hooks.getDriver().findElement(By.xpath(btnContinuarVerificacionDatosIOS)).click();
			Hooks.getDriver().findElement(By.xpath(campoCodigoAprobacionIOS)).sendKeys("11111");		
			Hooks.getDriver().findElement(By.xpath(btnTransferirIOS)).click();
		}
	}

	@Then("Verifica transferencia realizada")
	public void verificaTransferenciaRealizada() throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(5000);
			
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='¡Listo!']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Transferiste.']")).isDisplayed());
			assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Hacer otra transferencia']")).isDisplayed());
		}else {
			assertEquals(Hooks.getDriver().findElement(By.xpath(iconoListoTransferenciaIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(listoTransferenciaIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(transferisteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(hacerOtraTransferenciaIOS)).isEnabled(), true);
			
			assertEquals(Hooks.getDriver().findElement(By.xpath(comprobanteDeTransferenciaIOS)).isEnabled(), true);
			
			assertEquals(Hooks.getDriver().findElement(By.xpath(datosDeOrigenIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblNombreOrigenComprobanteIOS)).isEnabled(), true);			
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblCuentaComprobanteIOS)).isEnabled(), true);
			
			assertEquals(Hooks.getDriver().findElement(By.xpath(datosDeDestinoIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblCBUComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblNombreDestinoComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblCUITCUILComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblBancoComprobanteIOS)).isEnabled(), true);
			
			assertEquals(Hooks.getDriver().findElement(By.xpath(datosDeLaOperacionIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblMontoComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(lblConceptoComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(descripcionFinalComprobanteIOS)).isEnabled(), true);
			assertEquals(Hooks.getDriver().findElement(By.xpath(btnCompartirComprobanteIOS)).isEnabled(), true);
			
			System.out.println("Nombre Origen: " + Hooks.getDriver().findElement(By.xpath(nombreOrigenComprobanteIOS)).getAttribute("name"));
			System.out.println("Cuenta Origen: " + Hooks.getDriver().findElement(By.xpath(cuentaComprobanteIOS)).getAttribute("name"));
			
			System.out.println("CBU Destino: " + Hooks.getDriver().findElement(By.xpath(cbuComprobanteIOS)).getAttribute("name"));
			System.out.println("Nombre Destino: " + Hooks.getDriver().findElement(By.xpath(nombreDestinoComprobanteIOS)).getAttribute("name"));
			System.out.println("CUIT/CUIL Destino: " + Hooks.getDriver().findElement(By.xpath(cuitcuilComprobanteIOS)).getAttribute("name"));
			System.out.println("Banco Destino: " + Hooks.getDriver().findElement(By.xpath(bancoComprobanteIOS)).getAttribute("name"));

			System.out.println("Monto Operacion: " + Hooks.getDriver().findElement(By.xpath(signoComprobanteIOS)).getAttribute("name") + Hooks.getDriver().findElement(By.xpath(montoComprobanteIOS)).getAttribute("name")+ Hooks.getDriver().findElement(By.xpath(decimalesComprobanteIOS)).getAttribute("name"));
			System.out.println("Concepto Operacion: " + Hooks.getDriver().findElement(By.xpath(conceptoComprobanteIOS)).getAttribute("name"));
		}

	}
	
	@Then("Presiona la opcion hacer otra transferencia")
	public void hacerOtraTransferencia() {
		if (Hooks.esAndroid()) {
		}else {
			Hooks.getDriver().findElement(By.xpath(hacerOtraTransferenciaIOS)).click();
		}
	}

	@When("Selecciona destino")
	public void seleccionarDestino() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(destinoAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(destinoIOS)).click();
		}
	}

	@When("Selecciona agregar nuevo destinatario")
	public void seleccionarAgregarNuevoDestinatario() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(nuevoDestinatarioIOS)).click();
		}
	}

	@When("Ingresa cvu-cbu-alias con {string} y la descripcion")
	public void ingresarCVUCBUAliasYDescripcion(String cbu) throws InterruptedException {
		if (Hooks.esAndroid()) {
			Thread.sleep(3000);
			Hooks.getDriver().findElement(By.xpath(campoCVUCBUAliasAndroid)).sendKeys(cbu);
			Hooks.getDriver().findElement(By.xpath(campoDescripcionAgendaAndroid)).sendKeys("PRUEBA TEST");
		}else {
			Hooks.getDriver().findElement(By.xpath(campoCVUCBUAliasIOS)).sendKeys(cbu);
			Hooks.getDriver().findElement(By.xpath(campoDescripcionAgendaIOS)).sendKeys("PRUEBA TEST");
		}
	}

	@When("Presiona el check de agregar destinatario a mi agenda")
	public void apretarCheckAgregarDestinatario() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(checkAgregarAAgendaAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(checkAgregarAAgendaIOS)).click();
		}
	}

	@When("Presiona el boton continuar en agenda")
	public void apretarContinuarEnAgenda() {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(btnContinuarAgendaAndroid)).click();
		}else {
			Hooks.getDriver().findElement(By.xpath(btnContinuarAgendaIOS)).click();
		}
	}
	
	@Then("Verifica transferencia exitosa")
	public void verificaTransferenciaExitosa() throws InterruptedException {
		System.out.println("Verificacionn");
		Thread.sleep(5000);
		
		assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='¡Listo!']")).isDisplayed());
		assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Transferiste.']")).isDisplayed());
		assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Hacer otra transferencia']")).isDisplayed());
		
	}
	
	@Then("Presiona continuar y valida que el cbu-cvu-alias ingresado es invalido")
	public void presionaContinuarYValidaQueElCbuCvuAliasIngresadoEsInvalido() throws InterruptedException {
	    System.out.println("Validacion");
	    Thread.sleep(2000);
		Hooks.getDriver().findElement(By.xpath(btnContinuarAndroid)).click();
		assertTrue(Hooks.getDriver().findElement(By.xpath(mensajeCBUInvalido)).isDisplayed());
		Thread.sleep(2000);
	}
	
	@When("Busco {string}")
	public void busco(String destinatario) throws InterruptedException {
		Thread.sleep(2000);
		Hooks.getDriver().findElement(By.xpath("(//android.widget.EditText)")).sendKeys(destinatario);
	}

	@When("Presiono Editar")
	public void presionoEditar() throws InterruptedException {
		Thread.sleep(3000);
		Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='sub-menu']")).click();
		Hooks.click("(//android.view.View[contains(@text,'Editar')])[2]");
	}
	
}	

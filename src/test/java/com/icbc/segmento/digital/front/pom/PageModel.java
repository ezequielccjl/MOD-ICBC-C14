package com.icbc.segmento.digital.front.pom;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageModel extends BasePage {
	
	private String inputUsuarioXPath = "//input[contains(@aria-label, 'Esté es un campo tipo Usuario')]";
	private String inputContraseñaXPath = "//input[contains(@aria-label, 'Esté es un campo tipo Clave')]";
	private String inputMonto = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "//button[contains(text(),'Ingresar')]";
	private String btnMas = "//span[contains(text(),'Más')]";
	private String btnResumenes = "//li[contains(text(),'Resumenes')]";
	private String btnContacto= "//li[contains(text(),'Contacto')]";
	private String btnTarjeta = "//span[contains(text(),'Tarjetas')]";
	private String btnCardless= "//li[contains(text(),'Extracción sin tarjeta')]";
	private String inputImportePagoTC = "//input[contains(@aria-label,'Esté es un campo tipo Importe a pagar')]";
	private String inputMontoTransferencia= "//input[contains(@aria-label,'Esté es un campo tipo Monto en $')]";
	private String inputTokenTransferencia= "//input[contains(@aria-label,'Esté es un campo tipo Código de seguridad')]";
	private String inputCBUAgenda = "//input[contains(@aria-label, 'Esté es un campo tipo CBU-CVU-Alias')]";
	private String spanPagoTC = "//span[contains(text(),'Listo. Pagaste')]";
	
	private String btnNuevaOrden= "//a[contains(text(),'Nueva extracción sin tarjeta')]";
	
	public PageModel() {
		super(driver);
	}

	public void navigateToFBD() {
		navigateTo("https://mbrfbd.intranet.local/mbr/fbd/shell-mf/#/login");
		
	}
	
	public void navigateToQAT() {
		navigateTo("https://mbrqat.intranet.local/mbr/qat/shell-mf/#/login");
		
	}
	
	public void loginFBD(String user, String password) {
		ingresarUsuario(user);
    	ingresarContraseña(password);
	    clickIngresar();
	}
	
	public void ingresarUsuario(String usuario) {
		write(inputUsuarioXPath, usuario);
	}
	
	public void ingresarContraseña(String contraseña) {
		write(inputContraseñaXPath, contraseña);
	}
	
	public void clickIngresar() {
		clickElement(btnIngresar);
	}
	
	public void clickMas() {
		clickElement(btnMas);
	}
	
	public void clickResumenes() {
		
		jseClickIntercepted(btnResumenes);
	}
	
	public void clickContacto() {
		clickElement(btnContacto);
	}
	
	public void clickTarjeta() {
		clickElement(btnTarjeta);
	}
	
	public void clickCardless() {
		jseClickIntercepted(btnCardless);
	}
	
	public void clickNuevaOrden() {
		clickElement(btnNuevaOrden);
	}
	
	
	public void clickTipoTarjeta(String tarjeta) {
		clickElement("//div[contains(text(),'"+ tarjeta +" Titular')]");
	}
	
	public void esperarElemento(String xpath) {
		WebElement element = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	
	
	public void escribrirMonto(String montoinferior) {
		WebElement input = find(inputMonto);
		input.sendKeys(montoinferior + Keys.TAB);
	}
	
	public Boolean elementoDisponible(String xpath) {
		Boolean bool = find(xpath).isDisplayed();
		return bool;
	}
	
	public void jseClickIntercepted(String xpath) {
		WebElement elemento = find(xpath);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elemento);
		implicitWait();
	}
	
	public void ingresarImportePagoTC(String importe) {
		WebElement elemento = find(inputImportePagoTC);
		elemento.clear();
		elemento.sendKeys(importe + "00");
	}
	
	public void ingresarMontoTransferencia(String monto) {
		WebElement elemento = find(inputMontoTransferencia);
		elemento.clear();
		elemento.sendKeys(monto + "00");
	}
	
	public void ingresarTokenTransferencia(String token) {
		WebElement elemento = find(inputTokenTransferencia);
		elemento.clear();
		elemento.sendKeys(token);
	}
	
	public void ingresarCBUAgenda(String cbu) {
		WebElement elemento = find(inputCBUAgenda);
		elemento.clear();
		elemento.sendKeys(cbu);
	}
	
	public void ingresarTexto(String xpath, String texto) {
		WebElement elemento = find(xpath);
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	public Boolean verificarPagoTC() {
		return elementoDisponible(spanPagoTC);
	}
	
	public WebElement devolverElemento(String xpath) {
		WebElement elemento = find(xpath);
		return elemento;
	}
	
	public Boolean verificarResumenes(String xpath) {
		return elementoDisponible(xpath);
	}
	
	public void clickCompraVenta(String xpath) {
		WebElement elemento = find(xpath);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elemento);
	}
	
	public void aprietoF12() {
		driver.navigate().refresh();
	}
	
}

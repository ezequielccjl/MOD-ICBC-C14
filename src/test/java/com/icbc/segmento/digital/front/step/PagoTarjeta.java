package com.icbc.segmento.digital.front.step;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PagoTarjeta {
	//PageModel page = new PageModel();
	public WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	WebElement ingresarBtn;
	WebElement pagarBtn;
	WebElement liCuentaCorriente;
	WebElement cuentaCorriente;
	WebElement liMonedaWeb;
	WebElement moneda;
	int i = 0;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";
	private String btnPagar = "//*[@id=\"flex_163526211107270629\"]/ly-button[1]/button";
	private String liCuenta = "/html/body/main[1]/div/app-root/ly-app-container/div/app-card-payment-form-cont/ly-layout-container/div/div/app-card-payment-form-data/form/ly-form-field[1]/div/ly-select/div/div/ly-drop-frame/div/div[1]/ly-list-item/li";
	private String liMoneda = "/html/body/main[1]/div/app-root/ly-app-container/div/app-card-payment-form-cont/ly-layout-container/div/div/app-card-payment-form-data/form/ly-form-field[2]/div/ly-select/div/div/ly-drop-frame/div/div[1]";
	
	@Given("El usuario se logea con {string} y {string}")
	public void elUsuarioSeLogeaConY(String user, String pass) {
		
		i++;
			System.out.println(i);

			System.out.println("hola");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			System.out.println("hola2");
			driver = new ChromeDriver(chromeOptions());
			System.out.println("hola3");
			wait = new WebDriverWait(driver, 15);
			System.out.println("hola4");
		
		
		System.out.println("asd");
        driver.get("https://mbrdev.intranet.local/mbr/dev/shell-mf/#/login");
        ingresarUsuario(user);
        ingresarContraseña(pass);
        ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
        ingresarBtn.click();
        System.out.println("se ingresa");
	}

	@When("El usuario clickea en pagar")
	public void elUsuarioClickeaEnPagar() throws InterruptedException {

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		pagarBtn = driver.findElement(By.xpath("//button[contains(text(),'Pagar')]"));
		pagarBtn.click();
		
	}

	@When("Selecciona {string} {string} {string} y clickea continuar")
	public void seleccionaYClickeaContinuar(String cuentaDebitar, String monedaPagar, String importe) throws InterruptedException {
		
		Thread.sleep(3000);
		liCuentaCorriente = driver.findElement(By.xpath(liCuenta));
		liCuentaCorriente.click();
		
		Thread.sleep(1000);
		System.out.println("//div[contains(text(),'" + cuentaDebitar + "')]");
		cuentaCorriente = driver.findElement(By.xpath("//div[contains(text(),'"+ cuentaDebitar +"')]"));
		cuentaCorriente.click();
		
		Thread.sleep(1000);
		liMonedaWeb = driver.findElement(By.xpath(liMoneda));
		liMonedaWeb.click();
		
		Thread.sleep(1000);
		moneda = driver.findElement(By.xpath("//span[contains(text(),'"+monedaPagar+"')]"));
		cuentaCorriente.click();
		
		
	}

	@When("Clickea pagar")
	public void clickeaPagar() {
	}

	@Then("Visualiza comprobante de pago")
	public void visualizaComprobanteDePago() {
	}
	
	private ChromeOptions chromeOptions(){
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", "D:\\");	
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
	    chromeOptions.addArguments("--disable-dev-shm-usage");
	    chromeOptions.addArguments("--ignore-certificate-errors");
	    return chromeOptions;
	}
	
	public void navigateToDEV() {
		navigateTo("www.google.com");
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
	
	public void navigateTo(String url) {
		//driver.get(url);
		driver.manage().window().setSize(new Dimension(320, 774));
	}
	
	public void clickElement(String locator) {
		find(locator).click();
	}
	
	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}
	
	protected WebElement find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

}

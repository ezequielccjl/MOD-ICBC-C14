package com.icbc.segmento.digital.front.step;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class AyudaSubpantallas {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	WebElement atras;
	private int cont = 0;
	
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";

	private String btnAtras = "/html/body/main[1]/div/app-root/ly-app-container/div/app-hiheader/ly-header/header/ly-header-nav/div/ly-icon/span";
	
	@Given("^El usuario hace el Login con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioHaceElLoginConSomethingSomething(String user, String password) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);
	
	    driver.get("https://mobile.ebankingfbd.stdtest-idc.com.ar/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	    ingresarUsuario(user);
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("se ingresa");
        
    }

    @When("^Entra a la pestania mas y selecciona ayuda$")
    public void entraALaPestaniaMasYSeleccionaAyuda() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	WebElement buttonMas = driver.findElement(By.xpath(btnMas));
    	buttonMas.click();
    	System.out.println("PRESIONA BOTON MAS-------------");
    	
    	Thread.sleep(1500);
    	WebElement buttonAyuda = driver.findElement(By.xpath("//li[contains(text(),'Ayuda')]"));
    	buttonAyuda.click();
    	System.out.println("PRESIONA BOTON AYUDA-------------");
        
    }

    @Then("^Verifica que la navegacion haya sido correcta$")
    public void verificaQueLaNavegacinHayaSidoCorrecta() {
    	assertEquals(3, cont);
    }

    @And("^Navega por preguntas frecuentes$")
    public void navegaPorPreguntasFrecuentes() throws InterruptedException {
    	
    	Thread.sleep(1500);
    	WebElement spanPreguntas = driver.findElement(By.xpath("//span[contains(text(),'Preguntas Frecuentes')]"));
    	spanPreguntas.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement divOp1 = driver.findElement(By.xpath("//div[contains(text(),'¿Olvidaste tu usuario o tu clave de acceso?')]"));
    	divOp1.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement divOp2 = driver.findElement(By.xpath("//div[contains(text(),'comprobante obtengo de mis operaciones?')]"));
    	divOp2.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement divOp3 = driver.findElement(By.xpath("//div[contains(text(),'obtener la clave?')]"));
    	divOp3.click();
    	
    	cont++;
    	
    	Thread.sleep(1000);
    	atras = driver.findElement(By.xpath(btnAtras));
    	atras.click();
    	
    }

    @And("^Navega por terminos y condiciones$")
    public void navegaPorTerminosYCondiciones() throws InterruptedException {
    	
    	Thread.sleep(1500);
    	WebElement spanPreguntas = driver.findElement(By.xpath("//span[contains(text(),'Terminos y condiciones')]"));
    	spanPreguntas.click();
    	
    	Thread.sleep(1000);
    	WebElement body = driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();

    	// count occurrences of the string
    	int count = 0;

    	// search for the String within the text
    	while (bodyText.contains("Industrial and Commercial Bank of China (Argentina) S.A.")){

    	    // when match is found, increment the count
    		count++;

    	    // continue searching from where you left off
    	    bodyText = bodyText.substring(bodyText.indexOf("Industrial and Commercial Bank of China (Argentina) S.A.") + "Industrial and Commercial Bank of China (Argentina) S.A.".length());
    	}
    	
    	if(count == 2) {
    		cont++;
    	}
    	
    	Thread.sleep(1000);
    	atras = driver.findElement(By.xpath(btnAtras));
    	atras.click();
        
    }

    @And("^Navega por politicas de privacidad$")
    public void navegaPorPoliticasDePrivacidad() throws InterruptedException {
    	
    	Thread.sleep(1500);
    	WebElement spanPreguntas = driver.findElement(By.xpath("//span[contains(text(),'Politicas de privacidad')]"));
    	spanPreguntas.click();
    	
    	Thread.sleep(1000);
    	atras = driver.findElement(By.xpath(btnAtras));
    	atras.click();
        
    }

    @And("^Navega por seguridad$")
    public void navegaPorSeguridad() throws InterruptedException {
    	
    	Thread.sleep(1500);
    	WebElement spanPreguntas = driver.findElement(By.xpath("//span[contains(text(),'Seguridad')]"));
    	spanPreguntas.click();
    	
    	Thread.sleep(1000);
    	atras = driver.findElement(By.xpath(btnAtras));
    	atras.click();
        
    }

    @And("^Navega por contacto$")
    public void navegaPorContacto() throws InterruptedException {
    	
    	Thread.sleep(1500);
    	WebElement spanPreguntas = driver.findElement(By.xpath("//span[contains(text(),'Contactos')]"));
    	spanPreguntas.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement body = driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();

    	if (bodyText.contains("Mesa de ayuda") && bodyText.contains("ICBC Mobile Banking y Access Banking") && bodyText.contains("0810-555-9200") && bodyText.contains("(54-11) 4820-9200") ){
    	    cont++;
    	}
    	
    	System.out.println("cuantas veces: " + cont);
    	
    	Thread.sleep(1000);
    	atras = driver.findElement(By.xpath(btnAtras));
    	atras.click();
        
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



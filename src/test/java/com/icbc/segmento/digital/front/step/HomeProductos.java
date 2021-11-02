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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class HomeProductos {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	
	private String h1Cuentas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-home/ly-layout-container[1]/div/ly-section/div/ly-block[1]/div/ly-title/div/h1";
	
    @Given("^El usuario \"([^\"]*)\" se loguea con \"([^\"]*)\"$")
    public void elUsuarioSomethingSeLogueaConSomething(String user, String password) {
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mbrdev.intranet.local/mbr/dev/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	    ingresarUsuario(user);
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("Se ingresa");

    }

    @When("^Revisa sus productos$")
    public void revisaSusProductos() throws InterruptedException {
    	Thread.sleep(2000);
    	Boolean isPresent = driver.findElements(By.xpath(h1Cuentas)).size() > 0 ;
    	
    	while (isPresent == false) {
    		Thread.sleep(300);
    		isPresent = driver.findElements(By.xpath(h1Cuentas)).size() > 0 ;
    		System.out.println("Se agregan 300ms");
    		
    		if(isPresent) {
    			System.out.println("CARGARON LOS PRODS");
    		} else {
    			System.out.println("Esperando carga de prods...");
    		}
    		
    	}
        
    }

    @Then("^Verifica que tenga productos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void verificaQueTengaProductosSomethingSomethingSomethingSomethingSomething(String cajaahorropesos, String cuentacorriente, String cajaahorrodolar, String tarjeta1, String tarjeta2) throws InterruptedException {
    	
    	Thread.sleep(2000);
    	
    	WebElement body = driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();

    	// count occurrences of the string
    	int cont = 0;

    	// search for the String within the text
    	if (bodyText.contains(cajaahorropesos) && bodyText.contains(cuentacorriente) && bodyText.contains(cajaahorrodolar) && bodyText.contains(tarjeta1) && bodyText.contains(tarjeta2) ){
    	    cont++;
    	}
    	System.out.println("cuantas veces: " + cont);
    	
    	assertEquals(1, cont);
    }
    
    public void ingresarUsuario(String usuario) {
		write(inputUsuarioXPath, usuario);
	}
	
	public void ingresarContraseña(String contraseña) {
		write(inputContraseñaXPath, contraseña);
	}
	
	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}
	
	protected WebElement find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
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

}

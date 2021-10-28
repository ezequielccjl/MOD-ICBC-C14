package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantallaPoliticasPrivacidad {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";
		
    @Given("^El usuario se loguea con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String password)  {
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
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("SE INGRESA A POLITICAS");
        
    }
    
    @When("Presiona la pestania Mas")
    public void presionaLaPestaniaMas() throws InterruptedException {
    	System.out.println("PRESIONA BOTON MAS-------------");
    	Thread.sleep(3000);
    	WebElement buttonMas = driver.findElement(By.xpath(btnMas));
    	buttonMas.click();
    }

    @Then("^Verifica que se encuentre en politicas y privacidad$")
    public void verificaQueSeEncuentreEnPoliticasYPrivacidad()  {
        
    }

    @And("^Selecciona ayuda$")
    public void seleccionaAyuda() throws InterruptedException  {
    	System.out.println("PRESIONA BOTON AYUDA-------------");
    	Thread.sleep(1500);
    	WebElement buttonAyuda = driver.findElement(By.xpath("//li[contains(text(),'Ayuda')]"));
    	buttonAyuda.click();
        
    }

    @And("^Selecciona politicas y privacidad$")
    public void seleccionaPoliticasYPrivacidad() throws InterruptedException  {
    	System.out.println("PRESIONA BOTON POLITICAS----------------");
    	Thread.sleep(1500);
    	WebElement buttonPoliticas = driver.findElement(By.xpath("//span[contains(text(),'Politicas de privacidad')]"));
    	buttonPoliticas.click();
        
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

package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantallaContacto {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";
	
    @Given("^El usuario se logea con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String pass) {

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

    @When("Presiona en la pestania Mas")
    public void presionaEnLaPestaniaMas() throws InterruptedException {
    	System.out.println("PRESIONA BOTON MAS-------------");
    	Thread.sleep(3000);
    	WebElement buttonMas = driver.findElement(By.xpath(btnMas));
    	buttonMas.click();
        
    }

    @Then("^Verifica que se encuentre en Contacto$")
    public void verificaQueSeEncuentreEnContacto()  {
        
    }

    @And("^Selecciona Contacto$")
    public void seleccionaContacto() throws InterruptedException  {
    	System.out.println("PRESIONA BOTON AYUDA-------------");
    	Thread.sleep(1500);
    	WebElement buttonContacto = driver.findElement(By.xpath("//li[contains(text(),'Contacto')]"));
    	buttonContacto.click();
        
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

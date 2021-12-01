package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PantallaContacto {
	
	//LA SEGUNDA VEZ QUE SE EJECUTA EL DRIVER LOS HOLAS APARECEN
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";
	
    @Given("^El usuario se logea con \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioSeLogeaConSomethingYSomething(String user, String pass) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mobile.ebankingfbd.stdtest-idc.com.ar/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	    ingresarUsuario(user);
	    ingresarContraseña(pass);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("Se ingresa");
    }

    @When("Presiona en la pestania Mas")
    public void presionaEnLaPestaniaMas() throws InterruptedException {
    	System.out.println("PRESIONA BOTON MAS-------------");
    	Thread.sleep(3000);
    	WebElement buttonMas = driver.findElement(By.xpath(btnMas));
    	buttonMas.click();
        
    }

    @Then("^Verifica que se encuentre en Contacto$")
    public void verificaQueSeEncuentreEnContacto() throws InterruptedException  {
    	
    	Thread.sleep(2000);
    	WebElement body = driver.findElement(By.tagName("body"));
    	String bodyText = body.getText();

    	// count occurrences of the string
    	int cont = 0;

    	if (bodyText.contains("Mesa de ayuda") && bodyText.contains("ICBC Mobile Banking y Access Banking") && bodyText.contains("0810-555-9200") && bodyText.contains("(54-11) 4820-9200") ){
    	    cont++;
    	}
    	
    	System.out.println("cuantas veces: " + cont);
    	
    	assertEquals(1, cont);
        
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

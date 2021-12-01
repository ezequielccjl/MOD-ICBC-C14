package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;

public class Login {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;

	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";


    @Given("^El usuario se encuentra en la App$")
    public void elUsuarioSeEncuentraEnLaApp() {
    	System.out.println(System.getProperty("user.home") + "/drivers/chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/drivers/chromedriverNuevo.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mbrfbd.intranet.local/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	   //driver.manage().window().maximize();
        
    }

    @When("^Ingresa su \"([^\"]*)\" y \"([^\"]*)\"$")
    public void ingresaSuSomethingYSomething(String usuario, String contrasenia) {
    	ingresarUsuario(usuario);
	    ingresarContraseña(contrasenia);
    }

    @Then("^Verifica \"([^\"]*)\"$")
    public void verificaSomething(String respuestaesperada) {
    	
        if(respuestaesperada == "LoginOk") {
        	
        	System.out.println("CASO: Se ingresa a Home Productos");
        	
        	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        	boolean btnAddProductPresent = driver.findElement(By.xpath("//button[contains(text(),'Quiero un nuevo producto')]")).isDisplayed();
        	assertTrue(btnAddProductPresent);
        	
        }else if(respuestaesperada == "WrongPass") {
        	
        	System.out.println("CASO: Contraseña inválida");
        	//Usuario y/o clave incorrectos
        	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        	boolean spanWrongPassPresent = driver.findElement(By.xpath("//span[contains(text(),'Usuario y/o clave incorrectos')]")).isDisplayed();
        	assertTrue(spanWrongPassPresent);
        	
        }
        
    }

    @And("^Presiona ingresar$")
    public void presionaIngresar() {
    	
    	ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
        
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

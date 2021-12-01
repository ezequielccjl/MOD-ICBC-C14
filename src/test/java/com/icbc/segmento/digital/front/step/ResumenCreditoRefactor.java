package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;

public class ResumenCreditoRefactor {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;

	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";


    @Given("^El \"([^\"]*)\" hace login con \"([^\"]*)\"$")
    public void elSomethingHaceLoginConSomething(String user, String password) {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/drivers/chromedriver.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mbrfbd.intranet.local/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	   //driver.manage().window().maximize();
	    
	    ingresarUsuario(user);
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("Se ingresa: ResumenCredito");
        
    }

    @When("^Clickea en pestania mas$")
    public void clickeaEnPestaniaMas() {
    	
    	//WebDriverWait wait = new WebDriverWait(driver, 10);
    	WebElement element = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Quiero un nuevo producto')]")));
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	WebElement buttonMas = driver.findElement(By.xpath(btnMas));
    	buttonMas.click();
    	System.out.println("PRESIONA BOTON MAS-------------");
    	
    	
        
    }

    @Then("^Verifica su lista de resumenes$")
    public void verificaSuListaDeResumenes() {
        
    }

    @And("^Selecciona Resumenes$")
    public void seleccionaResumenes() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	WebElement buttonResumenes= driver.findElement(By.xpath("//li[contains(text(),'Resumenes')]"));
    	buttonResumenes.click();
    	System.out.println("PRESIONA BOTON RESUMENES-------------");
    	
        
    }

    @And("^Selecciona Tarjetas$")
    public void seleccionaTarjetas() {
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	WebElement spanTarjetas = driver.findElement(By.xpath("//span[contains(text(),'Tarjetas')]"));
    	spanTarjetas.click();
    	System.out.println("PRESIONA BOTON TARJETAS-------------");
        
    }

    @And("^Selecciona \"([^\"]*)\"$")
    public void seleccionaSomething(String tarjeta) {
    	
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	WebElement tipoTarjeta = driver.findElement(By.xpath("//div[contains(text(),'"+ tarjeta +" Titular')]"));
    	tipoTarjeta.click();
    	System.out.println("PRESIONA TIPO DE TARJETA "+ tarjeta +"-------------");
        
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
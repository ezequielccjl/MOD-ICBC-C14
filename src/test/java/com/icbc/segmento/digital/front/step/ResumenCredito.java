package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class ResumenCredito {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;

	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";

	private String spanResumen = "/html/body/main[1]/div/app-root/ly-app-container/div/app-statement/app-credit-card-statement-cont/ly-layout-container/div/ly-tabs/div/div[2]/ly-tab[1]/div/ly-block[2]/div/ly-list/ul/ly-item/div/div/div/ly-vertical-detail-list/ly-flex-layout/div/ly-vertical-detail[1]/div/ly-vertical-detail-value/span";
	private String resumenBtnXpath  = "/html/body/main[1]/div/app-root/ly-app-container/div/app-home/ly-layout-container[1]/div/ly-section/div/ly-block[2]/div/app-card[1]/ly-card/div/ly-card-footer/div/div[1]/ly-flex-layout/div/ly-button[2]/button";
	
    @Given("^El user \"([^\"]*)\" hace login con \"([^\"]*)\"$")
    public void elUserSomethingHaceLoginConSomething(String user, String password) {
    	
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mobile.ebankingfbd.stdtest-idc.com.ar/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	    
	    ingresarUsuario(user);
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("Se ingresa: ResumenCredito");
    }

    @When("^Se dirige a seccion tarjetas y selecciona su menu$")
    public void seDirigeASeccionTarjetasYSeleccionaSuMenu() throws InterruptedException {
    	
    	Thread.sleep(5000);
		
		
		
		WebElement resumenBtn = driver.findElement(By.xpath("//button[contains(text(),'Resumen')]"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView()", resumenBtn); 
		
		resumenBtn.click();
        
    }

    @Then("^Verifica sus resumenes$")
    public void verificaSusResumenes() {
    	
    	//Thread.sleep(2000);
    	
    	WebElement element = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Resumen')]")));

    	
    	Boolean hayResumen = false;
    	
    	//Storing the text of the heading in a string
    	String resumenText = driver.findElement(By.xpath(spanResumen)).getText();
    	if(resumenText != "" || resumenText != " " || resumenText != null) {
    		hayResumen = true;
    		System.out.println("SE ENCONTRÓ RESUMEN: " + resumenText);
    	}
    	
    	assertTrue(hayResumen);
    	
        
    }

    @And("^Selecciona resumen$")
    public void seleccionaResumen() {
    	
    	//PARA OBTENER ÚLTIMO RESUMEN DENTRO DE UL
    	//driver.findElement(By.xpath("//div[@class='pagination']/ul/li[last()]")).click();
        
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

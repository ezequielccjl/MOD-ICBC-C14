package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultaAliasCBU {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";

    @Given("^El usuario hace el login con \"([^\"]*)\" \"([^\"]*)\"$")
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

    @When("^Ingresa a cbu alias qr$")
    public void ingresaACbuAliasQr() throws InterruptedException {
    	System.out.println("PRESIONA BOTON CBU-------------");
    	Thread.sleep(3000);
    	WebElement buttonMas = driver.findElement(By.xpath("//button[contains(text(),'CBU-ALIAS-QR')]"));
    	buttonMas.click();
        
    }

    @Then("^Verifica su alias$")
    public void verificaSuAlias() throws InterruptedException {
    	System.out.println("VERIFICACION DE ALIAS");
    	
    	Thread.sleep(2000);
    	
    	String bodyText = driver.findElement(By.tagName("body")).getText();
    	//if the word you would like to check is "Book"
    	boolean isWordPresent = bodyText.contains("coronatest21");
    	
    	System.out.println("ESTA LA PALABRA CORONATEST21: " + isWordPresent);
    	assertTrue(bodyText.contains("coronatest21"));
        
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

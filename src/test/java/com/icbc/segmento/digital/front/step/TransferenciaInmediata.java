package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;

public class TransferenciaInmediata {
	
	private String buttonTranferir = "/html/body/main[1]/div/app-root/ly-app-container/div/app-home/ly-layout-container[1]/div/ly-section/div/ly-block[1]/div/app-account[1]/ly-block-layout/div/ly-card/div/ly-card-footer/div/div[1]/ly-flex-layout/div/ly-button[1]/button";
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;
	
	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String inputDestino = "/html/body/main[1]/div/app-root/ly-app-container/div/app-transferences/app-transference/ly-layout-container/div/ly-block/div/ly-tabs/div/div[2]/ly-tab[1]/div/ly-block/div/form/ly-block/div/ly-form-field[2]/div/ly-drop-frame/div/div[1]";
	private String inputMonto = "/html/body/main[1]/div/app-root/ly-app-container/div/app-transferences/app-transference/ly-layout-container/div/ly-block/div/ly-tabs/div/div[2]/ly-tab[1]/div/ly-block/div/form/ly-block/div/ly-form-field[3]/div/ly-text-field/div/input";
	private String inputConcepto = "/html/body/main[1]/div/app-root/ly-app-container/div/app-transferences/app-transference/ly-layout-container/div/ly-block/div/ly-tabs/div/div[2]/ly-tab[1]/div/ly-block/div/form/ly-block/div/ly-form-field[4]/div/ly-select/div/div/ly-drop-frame/div/div[1]";
	
	@Given("^El user \"([^\"]*)\" se loguea con \"([^\"]*)\"$")
    public void elUserSomethingSeLogueaConSomething(String user, String password) {
    	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");	
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);	
	
	    driver.get("https://mobile.ebankingfbd.stdtest-idc.com.ar/mbr/fbd/shell-mf/#/login");
	    driver.manage().window().setSize(new Dimension(250, 800));
	    ingresarUsuario(user);
	    ingresarContraseña(password);
	    ingresarBtn = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));
	    ingresarBtn.click();
	    System.out.println("Se ingresa");
    }

    @When("^Presiona en la pestania Transferir$")
    public void presionaEnLaPestaniaTransferir() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	WebElement buttonTrans= driver.findElement(By.xpath("//button[contains(text(),'Transferir')]"));
    	buttonTrans.click();
        
    }

    @Then("^Verfica que este en pantalla de SMS$")
    public void verficaQueEsteEnPantallaDeSMS() {
        
    }

    @And("^Selecciona \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void seleccionaSomethingSomethingSomething(String destino, String monto, String concepto) throws InterruptedException {
    	
    	Thread.sleep(2000);
    	WebElement inpDestino = driver.findElement(By.xpath(inputDestino));
    	inpDestino.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement des = driver.findElement(By.xpath("//span[contains(text(),'"+ destino +"')]"));
    	des.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement inpMonto = driver.findElement(By.xpath(inputMonto));
    	inpMonto.sendKeys(monto);
    	
    	WebElement inpConcepto = driver.findElement(By.xpath(inputConcepto));
    	inpConcepto.click();
    	
    	Thread.sleep(1000);
    	
    	WebElement spanConcepto= driver.findElement(By.xpath("//span[contains(text(),'"+ concepto +"')]"));
    	spanConcepto.click();
          
    }

    @And("^Presiona continuar$")
    public void presionaContinuar() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	
    	WebElement btnContinuar = driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"));
    	btnContinuar.click();
        
    }

    @And("^Confirma transferencia$")
    public void confirmaTransferencia() throws InterruptedException {
    	
    	Thread.sleep(2000);
    	
    	WebElement btnContinuar = driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"));
    	btnContinuar.click();
        
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

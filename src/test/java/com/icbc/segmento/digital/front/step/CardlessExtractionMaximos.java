package com.icbc.segmento.digital.front.step;

import cucumber.api.PendingException;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class CardlessExtractionMaximos {
	
	public WebDriver driver;
	private WebDriverWait wait;
	WebElement ingresarBtn;

	private String inputUsuarioXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[1]/div/ly-text-field/div/input";
	private String inputContraseñaXPath = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[1]/div/ly-layout-form/div/ly-form-field[2]/div/ly-text-field/div/input";
	private String btnIngresar = "/html/body/main[1]/div/app-root/ly-app-container/div/app-login/ly-layout-container/div/ly-main/div/form/ly-block[2]/div/ly-flex-layout/div/ly-button/button";
	private String btnMas = "/html/body/main[1]/div/app-root/ly-app-container/div/app-footer/ly-footer-bar/div/ly-flex-layout/div/ly-footer-bar-item[5]/button";

	private String selectCajaAhorro = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-form-field[1]/div/ly-select/div/div/ly-drop-frame/div";
	private String inputMonto = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-form-field[2]/div/ly-text-field/div/input";
	private String inputNumero = "/html/body/main[1]/div/app-root/ly-app-container/div/app-cardless-extraction-cont/ly-block/div/app-cardless-extraction/ly-data-block/article/ly-data-block-body/div/ly-block-layout/div/form/ly-flex-layout/div/ly-form-field[2]/div/ly-text-field/div/input";
	
	private String inputCodSMS = "/html/body/div[8]/div[3]/div/div/ly-section/div/form/ly-block/div/ly-flex-layout/div/ly-form-field[2]/div/ly-text-field/div/input";


    @Given("^El \"([^\"]*)\" hace log in con \"([^\"]*)\"$")
    public void elSomethingHaceLogInConSomething(String user, String password) {
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
	    System.out.println("Se ingresa: Cardless Extraction");
    }

    @When("^Clickea en la pestania mas$")
    public void clickeaEnLaPestaniaMas() {
    	//WebDriverWait wait = new WebDriverWait(driver, 10);
    	WebElement element = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Quiero un nuevo producto')]")));
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	WebElement buttonMas = driver.findElement(By.xpath("//span[contains(text(),'Más')]"));
    	buttonMas.click();
    	System.out.println("PRESIONA BOTON MAS-------------");
    }

    @Then("^Verifica la orden completada$")
    public void verificaLaOrdenCompletada() {
        
    }

    @And("^Selecciona opcion Extraccion sin tarjeta$")
    public void seleccionaOpcionExtraccionSinTarjeta() {
    	//Thread.sleep(2000);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	WebElement buttonResumenes= driver.findElement(By.xpath("//li[contains(text(),'Extracción sin tarjeta')]"));
    	buttonResumenes.click();
    	System.out.println("PRESIONA BOTON EXTRACCION-------------");

    }

    @And("^Selecciona nueva extraccion sin tarjeta$")
    public void seleccionaNuevaExtraccionSinTarjeta() {
    	WebElement buttonExtraction= driver.findElement(By.xpath("//a[contains(text(),' Nueva extracción sin tarjeta ')]"));
    	buttonExtraction.click();
    	System.out.println("PRESIONA BOTON NUEVA EXTRACCION-------------");
    }

    @And("^Completa \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" segun la cantidad de \"([^\"]*)\"$")
    public void completaSomethingSomethingSomethingSomethingSegunLaCantidadDeSomething(String origen, String monto, String tipo, String numero, String loops) {
        
    	for (int i = 0; i < Integer.parseInt(loops) ; i++) {
    		
    		if (i==0) {
    			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            	WebElement inputMontoElement= driver.findElement(By.xpath(inputMonto));
            	inputMontoElement.sendKeys(Keys.DELETE);
            	inputMontoElement.sendKeys(monto);
            	System.out.println("SE BORRA / MONTO: "+ monto);
            	
            	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            	WebElement inputNumeroElement= driver.findElement(By.xpath(inputNumero));
            	inputNumeroElement.sendKeys(Keys.DELETE);
            	inputNumeroElement.sendKeys(numero);
			}
        	
        	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        	WebElement btnContinuar= driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"));
        	btnContinuar.click();
        	
        	WebElement element = wait.until(
        	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Verificá los datos ingresados')]")));
        	
        	WebElement btnContinuar2= driver.findElement(By.xpath("//button[contains(text(),'Continuar')]"));
        	btnContinuar2.click();
        	
        	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        	WebElement inpSMS= driver.findElement(By.xpath(inputCodSMS));
        	inpSMS.sendKeys("11111");
        	
        	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        	WebElement btnGenerar= driver.findElement(By.xpath("//button[contains(text(),'Generar')]"));
        	btnGenerar.click();
        	
        	WebElement buttonExtraction= driver.findElement(By.xpath("//a[contains(text(),' Nueva extracción sin tarjeta ')]"));
        	buttonExtraction.click();
        	System.out.println("PRESIONA BOTON NUEVA EXTRACCION-------------");
		}
    	
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
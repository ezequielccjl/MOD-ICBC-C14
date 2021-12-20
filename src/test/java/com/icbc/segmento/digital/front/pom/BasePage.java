package com.icbc.segmento.digital.front.pom;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public static WebDriver driver;
	protected static WebDriverWait wait;
	private static Actions action;
	
	

	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions());
		wait = new WebDriverWait(driver, 15);
	}
	
	private static ChromeOptions chromeOptions(){
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", "D:\\");	
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
	    chromeOptions.addArguments("--disable-dev-shm-usage");
	    chromeOptions.addArguments("--ignore-certificate-errors");
	    return chromeOptions;
	}
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, 50);
	}
		
	public static void navigateTo(String url) {
		driver.get(url);
		driver.manage().window().setSize(new Dimension(250, 800));
		//driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.quit();
	}
	
	public WebElement find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void clickElement(String locator) {
		find(locator).click();
	}
	
	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}

	//para el combobox por valor
	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		Select dropdown = new Select(find(locator));
		dropdown.selectByValue(valueToSelect);
	}

	//para el combobox por index
	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropdown = new Select(find(locator));
		dropdown.selectByIndex(valueToSelect);
	}

	//para el combobox por texto
	public void selectFromDropdownByText(String locator, String valueToSelect) {
		Select dropdown = new Select(find(locator));
		dropdown.selectByVisibleText(valueToSelect);
	}
	
	//pasar el mouse sobre un elemento
	public void hoverOverElement(String locator) {
		action.moveToElement(find(locator));
	}

	//para hacer un doble clic
	public void doubleClick(String locator) {
		action.doubleClick(find(locator));
	}

	//para hacer clic derecho
	public void rightClick(String locator) {
		action.contextClick(find(locator));
	}

	//para guardar un texto de un elemento
	public String textFromElement(String locator) {
		return find(locator).getText();
	}

	//para ver si el boton esta habilitado para ser clickeado
	public boolean elementEnabled(String locator) {
		return find(locator).isEnabled();
	}
	
	//para ver si el elemento esta
	public boolean elementIsDisplayed(String locator) {
		return find(locator).isDisplayed();
	}
	
	public boolean elementIsSelected(String locator) {
		return find(locator).isSelected();
	}
	
	


}
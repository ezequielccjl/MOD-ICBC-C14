package com.icbc.segmento.digital.front.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.icbc.segmento.digital.front.configs.Configs;
import com.icbc.segmento.digital.front.hooks.Hooks;
import com.icbc.segmento.digital.front.pom.PageModelMobile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class LoginMobile {

	String inputUsuario = "(//android.widget.EditText)[1]";
	String inputPass = "(//android.widget.EditText)[2]";
	String btnIngresar = "//android.widget.Button[@text='Ingresar']";
	
	String inputUsuarioIOS = "//XCUIElementTypeTextField[@name = 'Esté es un campo tipo Usuario']";
	String inputPassIOS = "//XCUIElementTypeSecureTextField[@name='Esté es un campo tipo Clave']";
	String btnIngresarIOS = "//XCUIElementTypeButton[@name='Ingresar']";
	//static AppiumDriver<WebElement> driver = Hooks.getDriver();
	//PageModelMobile pm = new PageModelMobile();
	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	
	@Given("El usuario se encuentra en la app ICBC")
	public void elUsuarioSeEncuentraEnLaAppICBC() {
		System.out.println("Ejecucion del caso");
	}

	@Given("Estoy en la pantalla de Login")
	public void estoyEnLaPantallaDeLogin() throws InterruptedException {
		System.out.println("Estoy en la pantalla Login");
		if(Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Aceptar']")).isEnabled()) {
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Aceptar']")).click();
		}else {
			Thread.sleep(2000);
			Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Aceptar']")).click();
		}
		Hooks.getDriver().findElement(By.xpath("//android.widget.Button[@text='Ya tengo usuario y clave']")).click();
		System.out.println("aaaaaa");
		
	}
	
	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
		if (Hooks.esAndroid()) {
//			new TouchAction(Hooks.getDriver()).press(PointOption.point(200, 100)).release().perform();
			Hooks.getDriver().findElement(By.xpath(inputUsuario)).sendKeys(user);
			Hooks.getDriver().findElement(By.xpath(inputPass)).sendKeys(password);
			Hooks.getDriver().findElement(By.xpath(btnIngresar)).click();
		}else {
			
			driver.findElement(By.xpath(inputUsuarioIOS)).sendKeys(user);
			driver.findElement(By.xpath(inputPassIOS)).sendKeys(password);
			driver.findElement(By.xpath(btnIngresarIOS)).click();
			
		}
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    System.out.println("CIERRA SESION");
	}
	
}

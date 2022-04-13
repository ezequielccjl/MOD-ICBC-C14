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
import io.appium.java_client.android.AndroidDriver;

public class LoginMobile {

	String inputUsuario = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.EditText";
	String inputPass = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText";
	String btnIngresar = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button";
	
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

	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
		if (Hooks.esAndroid()) {
			Hooks.getDriver().findElement(By.xpath(inputUsuario)).sendKeys(user);
			Hooks.getDriver().findElement(By.xpath(inputPass)).sendKeys(password);
			Hooks.getDriver().findElement(By.xpath(btnIngresar)).click();
		}else {
			
			driver.findElement(By.xpath(inputUsuarioIOS)).sendKeys(user);
			driver.findElement(By.xpath(inputPassIOS)).sendKeys(password);
			driver.findElement(By.xpath(btnIngresarIOS)).click();
			
		}
		
	}

	@Then("Verifica que se haya logueado correctamente")
	public void verificaQueSeHayaLogueadoCorrectamente() throws InterruptedException {
		System.out.println("SLEEP");
	    Thread.sleep(5000);
	    }
	
	@Given("Estoy en la pantalla de Login")
	public void estoyEnLaPantallaDeLogin() {
		System.out.println("Estoy en la pantalla Login");
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    //System.out.println("CIERRA SESION");
	}
	
}

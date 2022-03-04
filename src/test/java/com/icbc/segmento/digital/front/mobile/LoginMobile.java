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
	//static AppiumDriver<WebElement> driver = Hooks.getDriver();
	//PageModelMobile pm = new PageModelMobile();
	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	@Given("El usuario se encuentra en la app ICBC")
	public void elUsuarioSeEncuentraEnLaAppICBC() {
		//driver.findElement(By.xpath(inputUsuario)).sendKeys("ASDASD");
	}

	@When("Completa {string} {string}presiona ingresar")
	public void completaPresionaIngresar(String user, String password) {
		driver.findElement(By.xpath(inputUsuario)).sendKeys(user);
		driver.findElement(By.xpath(inputPass)).sendKeys(password);
		driver.findElement(By.xpath("//android.widget.Button[@text='Ingresar']")).click();
	}

	@Then("Verifica que se haya logueado correctamente")
	public void verificaQueSeHayaLogueadoCorrectamente() throws InterruptedException {
	    Thread.sleep(15000);}
	
	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
		driver.findElement(By.xpath(inputUsuario)).sendKeys(user);
		driver.findElement(By.xpath(inputPass)).sendKeys(password);
		driver.findElement(By.xpath("//android.widget.Button[@text='Ingresar']")).click();
	}
	
	@Given("Estoy en la pantalla de Login")
	public void estoyEnLaPantallaDeLogin() {
		System.out.println("Estoy en la pantalla Login");
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    System.out.println("CIERRA SESION");
	}
	
}

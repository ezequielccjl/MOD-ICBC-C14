package com.icbc.segmento.digital.front.mobile;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeMobile {
//	MobileElement element = (MobileElement) driver.findElementByAccessibilityId("SomeAccessibilityID");
//	boolean isDisplayed = element.isDisplayed();
		
		static AppiumDriver<MobileElement> driver = Hooks.getDriver();
		String saludo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView";
		String ocultarSaldos = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[2]";
		
		//NUEVA BOTONERA
		///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.widget.Button
		
		
		// NuevaHome-SaludoAlUsuario
		@Then("Reviso que aparezca el saludo al usuario")
		public void revisoQueAparezcaElSaludoAlUsuario() throws InterruptedException {
			//¡Hola Goem!
			Thread.sleep(3000);
			System.out.println("VERIFICACION THEN");
			Boolean apareceSaludo = driver.findElement(By.xpath(saludo)).isDisplayed();
	        System.out.println(apareceSaludo);
	       	assertTrue(apareceSaludo);

		}
		
		// NuevaHome-OcultarSaldos
		@When("Presiono en ocultar saldos")
		public void presionoEnOcultarSaldos() {
			//Ocultar saldos
			driver.findElement(By.xpath(ocultarSaldos)).click();
			//XCUIElementTypeTextField[@name="Esté es un campo tipo Usuario"]
			driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Esté es un campo tipo Usuario\"]")).isDisplayed();
		}
	
		@Then("Valido que el saldo este oculto")
		public void validoQueElSaldoEsteOculto() {
			Boolean apareceSaldoOculto = driver.findElement(By.xpath("***")).isDisplayed();
	        System.out.println(apareceSaldoOculto);
	       	assertTrue(apareceSaldoOculto);
		}

}

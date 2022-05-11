package com.icbc.segmento.digital.front.mobile;

import com.icbc.segmento.digital.front.hooks.Hooks;

import cucumber.api.java.en.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ExtraccionSTMobile {
	
	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	@And("^Selecciona Extraccion sin tarjeta$")
    public void seleccionaExtraccionSinTarjeta() {
    	Hooks.getDriver().findElementByXPath("//android.view.View[contains(@text,'Extracción sin tarjeta')]\"").click();
    }

	@And("^Selecciona nueva extraccion$")
    public void seleccionaNuevaExtraccion() {
		Hooks.getDriver().findElementByXPath("//android.view.View[contains(@text,'Nueva extracción sin tarjeta')]").click();
    }

}

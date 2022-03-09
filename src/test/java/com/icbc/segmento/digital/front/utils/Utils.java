package com.icbc.segmento.digital.front.utils;

import org.openqa.selenium.WebElement;

import com.icbc.segmento.digital.front.hooks.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Utils {

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean existeElemento(String elemento) {
		AppiumDriver<MobileElement> driver = Hooks.getDriver();
		try {
			WebElement existeElemento = driver.findElementByXPath(elemento);
			return existeElemento.isDisplayed();
		}catch(Exception e){
			//System.out.println(e);
			return false;
		}

	}
	


}

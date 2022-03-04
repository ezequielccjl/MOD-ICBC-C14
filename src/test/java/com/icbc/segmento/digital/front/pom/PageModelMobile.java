package com.icbc.segmento.digital.front.pom;

import org.openqa.selenium.WebElement;

import com.icbc.segmento.digital.front.hooks.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageModelMobile {

	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
}

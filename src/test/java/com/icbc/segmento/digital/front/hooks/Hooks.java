package com.icbc.segmento.digital.front.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.icbc.segmento.digital.front.configs.Configs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Hooks {
	
	static AppiumDriver<MobileElement> driver = null;
	
	@Before
	public void setup() {
		
		System.out.println("HOLA MUNDO");
		
		if(Configs.capabilitiesAndroid().getCapability("platformName").equals("Android")) {
			driver = new AndroidDriver<MobileElement>(Configs.kobitonServerUrl(), Configs.capabilitiesAndroid());	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			try {
				//politicasPrivacidad();
			}catch(NoSuchElementException e) {
				//errorDeConexion();
				//politicasPrivacidad();
			}
		}else {
			driver = new IOSDriver<MobileElement>(Configs.kobitonServerUrl(), Configs.capabilitiesAndroid());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//errorDeConexion();
		}
	}
	
	@After
	public void teardown() {
		driver.quit();
		System.out.println("Teardown OK");
	}
	
	public static AppiumDriver<MobileElement> getDriver(){
		return driver;		
	}

	public static Boolean esAndroid() {
		System.out.println(Configs.capabilitiesAndroid().getCapability("platformName").equals("Android"));
		return Configs.capabilitiesAndroid().getCapability("platformName").equals("Android");
	}
	
}

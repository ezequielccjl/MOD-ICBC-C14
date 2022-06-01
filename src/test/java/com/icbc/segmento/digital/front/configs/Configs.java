package com.icbc.segmento.digital.front.configs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Configs {

	//KOBITON
	static String USERNAME = "CE211556";
    static String API_KEY = "16a9f5e2-cae3-4e8b-9526-949e21961065";
    public static final URL kobitonServerUrl(){
        try {
            return new URL("https://" + USERNAME + ":" + API_KEY + "@api.kobiton.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    //APPIUM LOCAL
    public static final URL localServerUrl() {
    	try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    	
    	return null;
    }
    
    
	public static final DesiredCapabilities capabilitiesAndroid() {
		
		//String kobitonServerUrl = "https://CE211556:16a9f5e2-cae3-4e8b-9526-949e21961065@api.kobiton.com/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Prueba Modernizacion");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		capabilities.setCapability("groupId", 2222); // Group: Retail
		capabilities.setCapability("deviceGroup", "KOBITON");
		
//		capabilities.setCapability("deviceName", "Pixel 3a XL");
//		capabilities.setCapability("platformVersion", "12");
//		capabilities.setCapability("platformName", "Android"); 
//		capabilities.setCapability("app", "kobiton-store:v433648");
//		capabilities.setCapability("failIfNoInternet", true);
		
//		capabilities.setCapability("deviceName", "iPhone 8 Plus");
//		capabilities.setCapability("platformVersion", "14.4");
//		capabilities.setCapability("platformName", "iOS"); 
//		capabilities.setCapability("app", "kobiton-store:v360839");
//		capabilities.setCapability("failIfNoInternet", true);
		
		
		capabilities.setCapability("deviceName", "motorola one fusion");
//        capabilities.setCapability("uid", "ZE222DP9FB");
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.icbc.mobile.abroadARG.dev.mf");
        capabilities.setCapability("appActivity", "com.icbc.mobile.abroadARG.dev.mf.MainActivity");
		
		return capabilities;
		
	}
	
	
	
}

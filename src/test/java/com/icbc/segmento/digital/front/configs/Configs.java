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
            return new URL("https://127.0.0.1:4723/wd/hub");
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
//		capabilities.setCapability("app", "kobiton-store:308388");
		capabilities.setCapability("app", "kobiton-store:v354310");
		// The given team is used for finding devices and the created session will be visible for all members within the team.
		capabilities.setCapability("groupId", 2222); // Group: Retail
		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
//		capabilities.setCapability("deviceName", "Google Pixel 6");
//		capabilities.setCapability("platformVersion", "12");
//		capabilities.setCapability("platformName", "Android"); 
		
		capabilities.setCapability("deviceName", "iPhone 8");
		capabilities.setCapability("platformVersion", "14.8");
		capabilities.setCapability("platformName", "iOS"); 
		
		return capabilities;
		
	}
	
	
	
}

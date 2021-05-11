package com.icbc.segmento.digital.front.step;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LauncherSelenium {

    static WebDriver driver;
    static EventFiringWebDriver eventDriver;
    
    public static void navegador(String textToSearch) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com.ar");
     	driver.findElement(By.name("q")).sendKeys(textToSearch);
     	driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }


    public static WebDriver getDriver(){
        return driver;
    }
    
    public static EventFiringWebDriver getEventDriver(){
        return eventDriver;
    }

}

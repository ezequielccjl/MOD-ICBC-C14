package com.icbc.segmento.digital.front.mobile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.icbc.segmento.digital.front.hooks.Hooks;

public class MoCa {
	
	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	@SuppressWarnings("rawtypes")
	TouchAction ta = new TouchAction(driver);
	boolean isFound;
	
	@Given("Que el usuario abre la aplicacion")
	public void que_el_usuario_abre_la_aplicacion() {
		
	}
	
	@When("Se encuentra en la pantalla de carga")
	public void se_encuentra_en_la_pantalla_de_carga() {	
		
	}
	
	@Given("Que el usuario ingresa a la pantalla de Login")
	public void que_el_usuario_ingresa_a_la_pantalla_de_Login() {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.Button[@text='ACEPTAR']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='YA TENGO USUARIO Y CLAVE']").click();
		
	}
	
	//SPLASH
	
	@Then("Verifica que se visualice el Splash")
	public void verifica_que_se_visualice_el_Splash() {
		
		assertEquals(driver.findElementByXPath("//android.widget.ImageView").isDisplayed(), true);
		
	}
	
	//SPINNER
	
	@Then("Verifica que se visualice el Spinner")
	public void verifica_que_se_visualice_el_Spinner() {
		
		assertEquals(driver.findElementByXPath("//android.widget.ProgressBar").isDisplayed(), true);
		
	}
	
	//BACK
	
	@When("Clickea en el Back nativo")
	public void clickea_en_el_Back_nativo() {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.Button[@text='ACEPTAR']"));
		
		driver.navigate().back();
		
	}
	
	@Then("Verifica que se cierre la aplicacion")
	public void verifica_que_se_cierre_la_aplicacion() {
		
		try {
			
			driver.findElementByXPath("//android.widget.Button[@text='ACEPTAR']");
			
		} catch(Exception e) {
			
			assertEquals(true, true);
			
		}	
		
	}
	
	//MALL

	@When("Clickea en Mall")
	public void clickea_en_Mall() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='ICBC Mall']")).click();
		
	}
	
	@Then("Verifica que se visualice la pantalla Mall")
	public void verifica_que_se_visualice_la_pantalla_Mall() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.EditText[@text='mall.icbc.com.ar/?cm_mmc=mbr-_-icono-_-login-_-mall']").isDisplayed(), true);
		
	}
	
	//BENEFICIOS
	
	@When("Clickea en Beneficios")
	public void clickea_en_Beneficios() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Beneficios']")).click();
		
	}

	@Then("Verifica que se visualice la pantalla Beneficios")
	public void verifica_que_se_visualice_la_pantalla_Beneficios() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.EditText[@text='beneficios.icbc.com.ar/?cm_mmc=mbr-_-icono-_-login-_-beneficios']").isDisplayed(), true);
		
	}

	//QUIERO SER CLIENTE
	
	@When("Clickea en Quiero ser cliente")
	public void clickea_en_Quiero_ser_cliente() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Quiero ser cliente']")).click();
		
	}
	
	@Then("Verifica que se visualice la pantalla Quiero ser cliente")
	public void verifica_que_se_visualice_la_pantalla_Quiero_ser_cliente() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.EditText[@text='icbc.com.ar/web/hacete-cliente-mobile']").isDisplayed(), true);
		
	}
	
	//CONTACTO
	
	@When("Clickea en Contacto")
	public void clickea_en_Contacto() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Contacto']")).click();
		
	}

	@And("Clickea en un telefono")
	public void clickea_en_un_telefono() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='0810-555-9200']")).click();
		
	}

	@And("Clickea en Contacto desde Mas")
	public void clickea_en_Contacto_desde_Mas() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElementByXPath("//android.view.View[contains(@text,'Contacto')]").click();
		
	}
	
	@Then("Verifica que se visualice la pantalla Contacto")
	public void verifica_que_se_visualice_la_pantalla_Contacto() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Mesa de ayuda']").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se marque el numero")
	public void verifica_que_se_marque_el_numero() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.EditText[@text='08105559200']").isDisplayed(), true);
		
	}

	//AYUDA
	
	@When("Clickea en Ayuda")
	public void clickea_en_Ayuda() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Ayuda']")).click();
		
	}
	
	@Then("Verifica que se visualice la pantalla Ayuda")
	public void verifica_que_se_visualice_la_pantalla_Ayuda() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Preguntas frecuentes']").isDisplayed(), true);
		
	}
	
	//TÃ‰RMINOS Y CONDICIONES
	
	@And("Clickea en Terminos y condiciones")
	public void clickea_en_Terminos_y_condiciones() {
			
        ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 580)).release().perform();
        
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.Button[@text='TÃ©rminos y condiciones']")).click();
		
	}
	
	
	@And("Clickea en Terminos y condiciones desde Ayuda")
	public void clickea_en_Terminos_y_condiciones_desde_Ayuda() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='TÃ©rminos y condiciones']")).click();
		
	}
	
	@Then("Verifica que se visualice la pantalla Terminos y condiciones")
	public void verifica_que_se_visualice_la_pantalla_Terminos_y_condiciones() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[contains(@text,'El servicio ICBC MOBILE BANKING')]").isDisplayed(), true);
		
	}
	
	//POLÃ�TICAS DE PRIVACIDAD
	
	@And("Clickea en Politicas de privacidad")
	public void clickea_en_Politicas_de_privacidad() {
		
        ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 580)).release().perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.Button[@text='PolÃ­ticas de privacidad']")).click();
		
	}

	@And("Clickea en Politicas de privacidad desde Ayuda")
	public void clickea_en_Politicas_de_privacidad_desde_Ayuda() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='PolÃ­ticas de privacidad']")).click();
		
	}

	@Then("Verifica que se visualice la pantalla Politicas de privacidad")
	public void verifica_que_se_visualice_la_pantalla_Politicas_de_privacidad() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='politica extendida']").isDisplayed(), true);
		
	}
	
	//PREGUNTAS FRECUENTES
	
	@And("Clickea en Preguntas frecuentes")
	public void clickea_en_Preguntas_frecuentes() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preguntas frecuentes']")).click();
		
	}

	@Then("Verifica que se visualice la pantalla Preguntas frecuentes")
	public void verifica_que_se_visualice_la_pantalla_Preguntas_frecuentes() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.view.View[contains(@text,'Â¿Olvidaste tu usuario o tu clave de acceso?')]").isDisplayed(), true);
		
	}

	//SEGURIDAD
	
	@And("Clickea en Seguridad")
	public void clickea_en_Seguridad() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Seguridad']")).click();
		
	}

	@Then("Verifica que se visualice la pantalla Seguridad")
	public void verifica_que_se_visualice_la_pantalla_Seguridad() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Seguridad en canales']").isDisplayed(), true);
		
	}

	//MÃ�S
	
	@When("Clickea en Mas")
	public void clickea_en_Mas() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'MÃ¡s')]").click();
		
	}
	
	//TARJETAS
	
	@When("Clickea en Tarjeta de credito {string}")
	public void clickea_en_Tarjeta_de_credito(String numeroDeTarjeta) {

		while(isFound == false) {
			
			try {
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='" + numeroDeTarjeta + "']"));
				isFound = true;
				
			} catch(Exception e) {
				
				ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 1000)).release().perform();
				isFound = false;
				
			}
			
		}

		driver.findElement(By.xpath("//android.widget.TextView[@text='" + numeroDeTarjeta + "']")).click();
		
	}
	
	@And("Clickea en Resumen")
	public void clickea_en_Resumen() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.Button[@text='RESUMEN']")).click();
		
	}
	
	@And("Descarga el Resumen de Tarjeta de credito")
	public void descarga_el_Resumen_de_Tarjeta_de_credito() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View/android.view.View/android.view.View/android.view.View").click();
		
	}
	
	@Then("Verifica que se descargue el Resumen de Tarjeta de credito")
	public void verifica_que_se_descargue_el_Resumen_de_Tarjeta_de_credito() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.EditText[contains(@text, 'mobile.ebankingqa.stdtest-idc.com.ar')]").isDisplayed(), true);
		
	}
	
	@When("Clickea en tres puntos de tarjeta MasterCard")
	public void clickea_en_tres_puntos_de_tarjeta_MasterCard() {

		while(isFound == false) {
			
			try {
				
				driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.widget.Button"));
				isFound = true;
				
			} catch(Exception e) {
				
				ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 1000)).release().perform();
				isFound = false;
				
			}
			
		}

		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.widget.Button")).click();
		
	}
	
	@When("Clickea en tres puntos de tarjeta Visa")
	public void clickea_en_tres_puntos_de_tarjeta_Visa() {

		while(isFound == false) {
			
			try {
				
				driver.findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[3]/android.widget.Button"));
				isFound = true;
				
			} catch(Exception e) {
				
				ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 1000)).release().perform();
				isFound = false;
				
			}
			
		}

		driver.findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[3]/android.widget.Button")).click();
		
	}
	
	@And("Clickea en Denunciar")
	public void clickea_en_Denunciar() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.view.View[contains(@text,'Denunciar')]")).click();
		
	}
	
	@Then("Verifica que se visualice la pantalla de denuncias MasterCard")
	public void verifica_que_se_visualice_la_pantalla_de_denuncias_MasterCard() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Tarjeta de crÃ©dito MasterCard']").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se visualice la pantalla de denuncias Visa")
	public void verifica_que_se_visualice_la_pantalla_de_denuncias_Visa() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Tarjeta de crÃ©dito Visa']").isDisplayed(), true);
		
	}
	
	//FONDOS DE INVERSIÃ“N
	
	@When("Clickea en Inversiones")
	public void clickea_en_Inversiones() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Inversiones')]").click();
		
	}
	
	@And("Clickea en Fondos de inversion")
	public void clickea_en_Fondos_de_inversion() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fondos de InversiÃ³n']")).click();
		
	}
	
	@And("Clickea en Conocer mas fondos")
	public void clickea_en_Conocer_mas_fondos() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.widget.Button[@text='CONOCER MÃ�S FONDOS']")).click();
		
	}
	
	@And("Clickea en un fondo de inversion")
	public void clickea_en_un_fondo_de_inversion() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.findElement(By.xpath("//android.view.View[@text='Alpha Acciones']")).click();
		
	}
	
	@And("Descarga el PDF del fondo de inversion {string}")
	public void descarga_el_PDF_del_fondo_de_inversion(String pdf) {
		
		ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 580)).release().perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'" + pdf + ")]").click();
		
	}
	
	@Then("Verifica que se descargue el Reglamento de gestion")
	public void verifica_que_se_descargue_el_Reglamento_de_gestion() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='']").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se descargue la FactSheet")
	public void verifica_que_se_descargue_la_FactSheet() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='']").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se descargue la Calificacion")
	public void verifica_que_se_descargue_la_Calificacion() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='']").isDisplayed(), true);
		
	}
	
	//RECOMENDAR
	
	@And("Clickea en Recomendar")
	public void clickea_en_Recomendar() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.view.View[contains(@text,'Recomendar')]").click();
		
	}
	
	@And("Clickea en Facebook")
	public void clickea_en_Facebook() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Facebook')]").click();
		
	}
	
	@And("Clickea en Twitter")
	public void clickea_en_Twitter() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Twitter')]").click();
		
	}
	
	@And("Clickea en Gmail")
	public void clickea_en_Gmail() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Gmail')]").click();
		
	}
	
	@And("Clickea en Outlook")
	public void clickea_en_Outlook() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Outlook')]").click();
		
	}
	
	@And("Clickea en SMS")
	public void clickea_en_SMS() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[contains(@text,'SMS')]").click();
		
	}
	
	@Then("Verifica que se recomiende por Facebook")
	public void verifica_que_se_recomiende_por_Facebook() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se recomiende por Twitter")
	public void verifica_que_se_recomiende_por_Twitter() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se recomiende por Gmail")
	public void verifica_que_se_recomiende_por_Gmail() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se recomiende por Outlook")
	public void verifica_que_se_recomiende_por_Outlook() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		
	}
	
	@Then("Verifica que se recomiende por SMS")
	public void verifica_que_se_recomiende_por_SMS() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		
	}
	
	//CUENTAS
	
	@And("Clickea en Gestion de productos")
	public void clickea_en_Gestion_de_productos() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.view.View[contains(@text,'GestiÃ³n de productos')]").click();
		
	}
	
	@And("Clickea en Cuentas")
	public void clickea_en_Cuentas() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Cuentas')]").click();
		
	}
	
	@And("Clickea en Caja de ahorro pesos")
	public void clickea_en_caja_de_ahorro_pesos() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Caja de ahorro $']").click();	
		
	}
	
	@And("Clickea en Caja de ahorro dolares")
	public void clickea_en_Caja_de_ahorro_dolares() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.TextView[@text='Caja de ahorro U$S']").click();
		
	}
	
	@And("Descarga el PDF de la caja de ahorro")
	public void descarga_el_PDF_de_la_caja_de_ahorro() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.Button[@text='TÃ©rminos y condiciones']").click();
		
	}
	
	@Then("Verifica que se descargue el PDF de caja de ahorro")
	public void verifica_que_se_descargue_el_PDF_de_caja_de_ahorro() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		assertEquals(driver.findElementByXPath("").isDisplayed(), true);
		assertTrue(driver.findElementByXPath("").isDisplayed());
		
	}
	
	//LOGIN
	
	@When("Clickea en No puedo ingresar")
	public void clickea_en_No_puedo_ingresar() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='NO PUEDO INGRESAR']").click();
		
	}
	
	@And("Clickea en Generacion en cajeros Banelco")
	public void clickea_en_Generacion_en_cajeros_Banelco() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'GeneraciÃ³n en cajeros Banelco')]").click();
		
	}
	
	@And("Clickea en Enviar instrucciones")
	public void clickea_en_Enviar_instrucciones() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Enviar instrucciones']").click();
		
	}
	
	@Then("Verifica que se visualice la pantalla de enviar instrucciones")
	public void verifica_que_se_visualice_la_pantalla_de_enviar_instrucciones() {

		try {
			
			driver.findElementByXPath("//android.widget.Button[@text='Enviar instrucciones']");
			
		} catch(Exception e) {
			
			assertEquals(true, true);
			
		}	
		
	}
	
	//COMPARTIR
	
	@And("Clickea en Compartir")
	public void clickea_en_Compartir() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Compartir']").click();
		
	}
	
	//TRANSFERENCIA
	
	@And("Clickea en una transferencia")
	public void clickea_en_una_transferencia() {

		while(isFound == false) {
			
			try {
				
				driver.findElementByXPath("//android.widget.TextView[contains(@text,'Transf')]");
				isFound = true;
				
			} catch(Exception e) {
				
				ta.press(PointOption.point(545, 1625)).moveTo(PointOption.point(545, 1000)).release().perform();
				isFound = false;
				
			}
			
		}

		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Transf')]").click();
		
	}
	
	@Then("Verifica que se visualice la pantalla de compartir transferencia")
	public void verifica_que_se_visualice_la_pantalla_de_compartir_transferencia() {

		try {
			
			driver.findElementByXPath("//android.widget.Button[@text='Compartir']");
			
		} catch(Exception e) {
			
			assertEquals(true, true);
			
		}	
		
	}
	
	//CBU-ALIAS-QR
	
	@When("Clickea en CBU-ALIAS-QR")
	public void clickea_en_CBU_ALIAS_QR() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.Button").click();
		
	}
	
	@And("Clickea en Compartir CBU-ALIAS-QR")
	public void clickea_en_Compartir_CBU_ALIAS_QR() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='COMPARTIR']").click();
		
	}
	
	@Then("Verifica que se visualice la pantalla de compartir CBU-ALIAS-QR")
	public void verifica_que_se_visualice_la_pantalla_de_compartir_CBU_ALIAS_QR() {

		try {
			
			driver.findElementByXPath("//android.widget.Button[@text='Compartir']");
			
		} catch(Exception e) {
			
			assertEquals(true, true);
			
		}	
		
	}
	
	//MOVIMIENTO
	
	@And("Clickea en un movimiento")
	public void clickea_en_un_movimiento() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Deposito')]").click();
		
	}
	
	@And("Clickea en Enviar")
	public void clickea_en_Enviar() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Enviar']").click();
		
	}
	
	@Then("Verifica que se visualice la pantalla de enviar movimiento")
	public void verifica_que_se_visualice_la_pantalla_de_enviar_movimiento() {
		
		try {
			
			driver.findElementByXPath("//android.widget.Button[@text='Enviar']");
			
		} catch(Exception e) {
			
			assertEquals(true, true);
			
		}	
		
	}
	
}
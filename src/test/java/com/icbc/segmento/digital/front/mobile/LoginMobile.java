package com.icbc.segmento.digital.front.mobile;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.icbc.segmento.digital.front.configs.Configs;
import com.icbc.segmento.digital.front.hooks.Hooks;
import com.icbc.segmento.digital.front.pom.PageModelMobile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginMobile {

	String inputUsuario = "(//android.widget.EditText)[1]";
	String inputPass = "(//android.widget.EditText)[2]";
	String btnIngresar = "//android.widget.Button[@text='Ingresar']";
	
	String notNowIOS = "//*[contains(@name, \"Not Now\")]";
	String inputUsuarioIOS = "//XCUIElementTypeTextField[@name = 'Esté es un campo tipo Usuario']";
	String btnNextLoginIOS = "//XCUIElementTypeButton[@name=\"Next\"]";
	String inputPassIOS = "//XCUIElementTypeSecureTextField[@name='Esté es un campo tipo Clave']";
	String btnIngresarIOS = "//XCUIElementTypeButton[@name='Ingresar']";
	String terminosYCondicionesIOS = "//XCUIElementTypeStaticText[@name=\"Términos y condiciones ICBC Mobile Banking\"]";
	String btnAtrasTerminosYCondicionesIOS = "(//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther/XCUIElementTypeStaticText)[1]";
	private static RequestSpecification requestSpec;
	private static Response response;
	//static AppiumDriver<WebElement> driver = Hooks.getDriver();
	//PageModelMobile pm = new PageModelMobile();
	static AppiumDriver<MobileElement> driver = Hooks.getDriver();
	
	
	@Given("El usuario se encuentra en la app ICBC")
	public void elUsuarioSeEncuentraEnLaAppICBC() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Ejecucion del caso");
		
		if (Hooks.esAndroid()) {
			
			WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 10); 
			WebElement btnAceptar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Aceptar']")));
			btnAceptar.click();
			
			click("//android.widget.Button[@text='Ya tengo usuario y clave']");
			
		}		
	}
	
	
	//Login para escenarios de MoCa - Identico al de abajo - Hay que combinar steps
	@Given("Que el usuario se loguea con {string} {string}")
	public void queElUsuarioSeLogueaCon(String username, String password) {
		if (Hooks.esAndroid()) {
			driver.findElement(By.xpath(inputUsuario)).sendKeys(username);
			driver.findElement(By.xpath(inputPass)).sendKeys(password);
			driver.findElement(By.xpath(btnIngresar)).click();
		}else {
			try {
			if(driver.findElement(By.xpath(notNowIOS)).isEnabled()) {
				driver.findElement(By.xpath(notNowIOS)).click();
			}
			}catch(NoSuchElementException e) {					
			}
			
			
			driver.findElement(By.xpath(inputUsuarioIOS)).click();
			driver.findElement(By.xpath(inputUsuarioIOS)).sendKeys(username);
			driver.findElement(By.xpath(btnNextLoginIOS)).click();
			driver.findElement(By.xpath(inputPassIOS)).sendKeys(password);
			driver.findElement(By.xpath(btnIngresarIOS)).click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (Hooks.getDriver().findElement(By.xpath(terminosYCondicionesIOS)).isEnabled()) {
				Hooks.getDriver().findElement(By.xpath(btnAtrasTerminosYCondicionesIOS)).click();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@When("Me logueo con el usuario {string} y la pass {string}")
	public void meLogueoConElUsuarioYLaPass(String user, String password) {
			if (Hooks.esAndroid()) {
				driver.findElement(By.xpath(inputUsuario)).sendKeys(user);
				driver.findElement(By.xpath(inputPass)).sendKeys(password);
				driver.findElement(By.xpath(btnIngresar)).click();
			}else {
				try {
				if(driver.findElement(By.xpath(notNowIOS)).isEnabled()) {
					driver.findElement(By.xpath(notNowIOS)).click();
				}
				}catch(NoSuchElementException e) {					
				}
				driver.findElement(By.xpath(inputUsuarioIOS)).click();
				driver.findElement(By.xpath(inputUsuarioIOS)).sendKeys(user);
				driver.findElement(By.xpath(btnNextLoginIOS)).click();
				driver.findElement(By.xpath(inputPassIOS)).sendKeys(password);
				driver.findElement(By.xpath(btnIngresarIOS)).click();			
			}
	
	}

	@Then("Verifica que se haya logueado correctamente")
	public void verificaQueSeHayaLogueadoCorrectamente() throws InterruptedException {
		assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Hola,')]")).isDisplayed());
	    }
	
	@Given("Estoy en la pantalla de Login")
	public void estoyEnLaPantallaDeLogin() {
		System.out.println("Estoy en la pantalla Login");
	}
	
	@Then("Cierro sesion")
	public void cierroSesion() {
	    System.out.println("CIERRA SESION");
	}
	
	@Then("Verifica login incorrecto")
	public void verificaLoginIncorrecto() {
		Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'Usuario y/o contraseña')]")).click();
//		assertTrue(Hooks.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Usuario y/o contraseña incorrecta.']")));
	}
	
	@When("Ingreso usuario {string} y verifico que no se pueda continuar")
	public void ingresoUsuarioYVerificoQueNoSePuedaContinuar(String caracteresEspeciales) {
		Hooks.getDriver().findElement(By.xpath(inputUsuario)).sendKeys(caracteresEspeciales + Keys.TAB); 
	    assertTrue(Hooks.getDriver().findElement(By.xpath("//div[contains(text(), 'Letras y números, de 8 a 12 caracteres')]")).isDisplayed());
	}
	
	@Then("Blanquea usuario con {string} {string} {string} {string} {string} {string} {string}")
	public void blanqueaUsuarioCon(String tipoDocumento, String numeroDocumento, String genero, String usuario, String clave, String canalOrigen, String requestId) {
		 
			requestSpec = (RequestSpecification) new RequestSpecBuilder()
					.setBaseUri("http://aamr-qat.intranet.local/intranet/usuario/altaUsuarioRetail.rs")
//					.setContentType(ContentType.JSON)
					.setRelaxedHTTPSValidation()
					.build();
		
		String request = "{\r\n" + 
				"\"tipoDocumento\": \""+tipoDocumento+"\",\r\n" + 
				"\"numeroDocumento\": \""+numeroDocumento+"\",\r\n" + 
				"\"genero\": \""+genero+"\",\r\n" + 
				"\"usuario\": \""+usuario+"\",\r\n" + 
				"\"clave\": \""+clave+"\",\r\n" + 
				"\"canalOrigen\": \""+canalOrigen+"\",\r\n" + 
				"\"trace\": {\r\n" + 
				"\"requestId\": \""+requestId+"\"\r\n" + 
				"}\r\n" + 
				"}";
		
				given().
				spec(requestSpec).
				contentType(ContentType.JSON).
				body(request).
			when().
				post().
			then().
		//		body("header.resultCode", equalTo("ok")).
		//		body("data.accounts[0].productType.code", equalTo("01")).
				log().all().
		//		body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
				extract().
				response();
		
	}
	
	@When("Ingresa en Olvide mi usuario o clave")
	public void ingresaEnOlvideMiUsuarioOClave() {
		
	}

	@When("Presiona Generacion Online")
	public void presionaGeneracionOnline() {
		
	}
	
	public void click(String xpath) {
		Hooks.getDriver().findElement(By.xpath(xpath)).click();
	}

	
}

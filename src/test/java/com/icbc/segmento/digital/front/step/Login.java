package com.icbc.segmento.digital.front.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Then;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import com.icbc.segmento.digital.front.pom.PageModel;
import com.icbc.segmento.digital.util.Link;


public class Login {
	
	PageModel pm = new PageModel();
	private static RequestSpecification requestSpec;
	private static Response response;
	
	@Given("El usuario se encuentra en la App")
	public void elUsuarioSeEncuentraEnLaApp() {
	    pm.navigateToFBD();
	}

	@When("Ingresa su {string} y {string} {string}")
	public void ingresaSuY(String user, String contrasenia, String loop) {
	    for (int i = 0; i < Integer.parseInt(loop); i++) {
	    	System.out.println("VUELTA: "+i);
			pm.ingresarUsuario(user);
			pm.ingresarContraseña(contrasenia);
			pm.jseClickIntercepted("//button[contains(text(),'Ingresar')]");
		}
	}

	@Then("Verifica {string}")
	public void verifica(String respuestaEsperada) {
	    Boolean verificacion = pm.elementoDisponible("//span[contains(text(),'"+respuestaEsperada+"')]");
	    
	    assertTrue(verificacion);
	}

	@Then("Blanquea usuario con {string} {string} {string} {string} {string} {string} {string}")
	public void blanqueaUsuarioCon(String tipoDocumento, String numeroDocumento, String genero, String usuario, String clave, String canalOrigen, String requestId) {
		 
			requestSpec = (RequestSpecification) new RequestSpecBuilder()
					.setBaseUri("http://aamr-fbd.intranet.local/intranet/usuario/altaUsuarioRetail.rs")
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


}

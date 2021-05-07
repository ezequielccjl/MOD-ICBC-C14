package stepDefinitionsBack.pfm;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.Link;

public class ListProducts {
	
	Response respuesta;

	@When("^envio el json con tipo de documento, numero y genero$")
	public void envio_el_json_con_los_datos_del_cliente() {
			
		RequestSpecification reqSpec = new RequestSpecBuilder().
		            setBaseUri(Link.LIST_PRODUCTS).
		            setContentType(ContentType.JSON).
		            build();
		
		//ListProductInput
		Object listProductsInput = null;
		
		respuesta =
				
			given().
				relaxedHTTPSValidation().
				spec(reqSpec).
				body(listProductsInput).
			when().
				post().
			then().
				statusCode(200).
				body("data.externalAccount.aliasName", equalTo("gabo123")).
				extract().
				response();
		
	}

	@Then("^recibo los productos correctos del cliente$")
	public void verifica_que_trae_al_cliente_correcto() {
		
		assertEquals(200, respuesta.getStatusCode());
			
	}

}

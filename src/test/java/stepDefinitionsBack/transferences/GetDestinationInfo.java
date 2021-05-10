package stepDefinitionsBack.transferences;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Alias;
import mapeo.Data;
import util.Link;

public class GetDestinationInfo {
	
	Response respuesta;

	@When("^envio el json con los datos del cliente \"([^\"]*)\"$")
	public void envio_el_json_con_los_datos_del_cliente(String arg1) {
			
		RequestSpecification reqSpec = new RequestSpecBuilder().
		            setBaseUri(Link.TRANSFERENCE).
		            setContentType(ContentType.JSON).
		            addHeader("channel", "mbr").
		            build();
		
		Alias alias = new Alias(new Data("gabo123",""));
			
		respuesta =
				
			given().
				relaxedHTTPSValidation().
				spec(reqSpec).
				body(alias).
			when().
				post().
			then().
				statusCode(200).
				body("data.externalAccount.aliasName", equalTo("gabo123")).
				extract().
				response();
		
	}
	
	@Then("^verifica que trae al cliente correcto$")
	public void verifica_que_trae_al_cliente_correcto() {
	
		assertEquals(200, respuesta.getStatusCode());
			
	}

}

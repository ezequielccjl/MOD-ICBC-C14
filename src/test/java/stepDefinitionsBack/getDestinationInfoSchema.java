package stepDefinitionsBack;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import mapeo.Alias;
import mapeo.Data;
import util.link;

public class getDestinationInfoSchema {
	
	@When("^envio el json$")
	public void envio_el_json() {
		
		RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(link.transfer).
	            setContentType(ContentType.JSON).
	            addHeader("channel", "mbr").
	            build();
	
		Alias alias = new Alias(new Data("gabo123",""));
	
		given().
			relaxedHTTPSValidation().
			spec(reqSpec).
			body(alias).
		when().
			post().
		then().
			assertThat().
			body(matchesJsonSchemaInClasspath("schema.json"));
	}

	@Then("^valido el schema$")
	public void valido_el_schema() {

	}

}

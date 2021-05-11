package stepDefinitionsBack.transferences;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.ebanking.retail.model.DestinationInfoInput;
import com.ebanking.retail.model.RequestDestinationInfoInput;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.Link;

public class GetDestinationInfoSchema {
	
	@When("^envio el json$")
	public void envio_el_json() {
		
		RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(Link.TRANSFERENCE).
	            setContentType(ContentType.JSON).
	            addHeader("channel", "mbr").
	            build();
		
		DestinationInfoInput destinationInfoInput = (new DestinationInfoInput()).originDocumentNumber("").destinationAliasCbuCvu("gabo123");
		RequestDestinationInfoInput requestDestinationInfoInput = (new RequestDestinationInfoInput()).data(destinationInfoInput);
	
		given().
			relaxedHTTPSValidation().
			spec(reqSpec).
			body(requestDestinationInfoInput).
		when().
			post().
		then().
			assertThat().
			body(matchesJsonSchemaInClasspath("schemaGetDestinationInfo.json"));
	}

	@Then("^valido el schema$")
	public void valido_el_schema() {
		
	}

}


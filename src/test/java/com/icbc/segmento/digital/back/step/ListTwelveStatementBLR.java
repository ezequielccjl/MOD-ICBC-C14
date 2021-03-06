package com.icbc.segmento.digital.back.step;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Date;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;
import com.icbc.segmento.digital.util.dependency.ListBlrTwelveStatementInput;
import com.icbc.segmento.digital.util.dependency.RequestListBlrTwelveStatementInput;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListTwelveStatementBLR {
	
	private static Response response;

    @Given("^El usuario loguea correctamente con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioLogueaCorrectamenteConSomethingSomethingSomething(String user, String pass, String deviceId) {
        
    	//refactorizar, no hace falta el login, cambiar gherkin
    }

    @When("Hace la consulta con {string} {string} {string} {string} {string} {string} {string} {string}")
    public void haceLaConsultaConSomethingSomethingSomethingSomething(String transactionId, String channel, String cardbrandindicatorcode, String cardproductnumber, String fromdate, String todate, String maxresultsnumber, String resultCode) {
        
    	long fromDate = Long.parseLong(fromdate.replace("-", ""));
    	long toDate = Long.parseLong(todate.replace("-", ""));
    	
    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTTWELVESTATEMENTBLR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	RequestHeader rh = new RequestHeader()
    			.transactionId(transactionId)
    			.channel(channel);
    	
    	ListBlrTwelveStatementInput listTwelveStatementInput = new ListBlrTwelveStatementInput()
    			.cardBrandIndicatorCode(cardbrandindicatorcode)
    			.cardProductNumber(cardproductnumber)
    			.fromDate(new Date(fromDate))
    			.toDate(new Date(toDate))
    			.maxResultsNumber(maxresultsnumber);
    	
    	RequestListBlrTwelveStatementInput request = (RequestListBlrTwelveStatementInput) new RequestListBlrTwelveStatementInput()
    			.data(listTwelveStatementInput)
    			.header(rh);
    	
    	response =		
    			given().
    				spec(requestSpec).
    				contentType(ContentType.JSON).
    				body(request).
    			when().
    				post().
    			then().
    				body("header.resultCode", equalTo(resultCode)).
//    				body("data.accounts[0].productType.code", equalTo("01")).
    				log().all().
//    				body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
    				extract().
    				response();	
    	
    	
    }

    @Then("^Verifico que la response sea correcta$")
    public void verificoQueLaResponseSeaCorrecta() {
		assertEquals("El status code es incorrecto " + response.getStatusCode() , 200, response.getStatusCode());
    }

}

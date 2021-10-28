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
	private static String hzSessionId;

    @Given("^El usuario loguea correctamente con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioLogueaCorrectamenteConSomethingSomethingSomething(String user, String pass, String deviceId) {
        
    	LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
    	
    }

    @When("^Hace la consulta con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (.+) (.+) \"([^\"]*)\"$")
    public void haceLaConsultaConSomethingSomethingSomethingSomething(String transactionId, String cardbrandindicatorcode, String cardproductnumber, Integer fromdate, Integer todate, String maxresultsnumber) {
        
    	long fromDate = fromdate.longValue();
    	long toDate = todate.longValue();
    	
    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTTWELVESTATEMENT)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	RequestHeader rh = new RequestHeader()
    			.transactionId(transactionId);
    	
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
//    				body("header.resultCode", equalTo("ok")).
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

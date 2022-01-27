package com.icbc.segmento.digital.back.step;

import cucumber.api.PendingException;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.Request;
import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelProductCardListDataMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListProductCardMBR {

	private static Response listProductCardResponse;
	private static String hzSessionId;
	
    @Given("^El usuario se loguea correctamente con \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void elUsuarioSeLogueaCorrectamenteConSomethingSomethingSomething(String user, String pass, String deviceId) {
        
    	LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
    	
    }

    @When("^Hace la consulta al servicio con \"([^\"]*)\"$")
    public void haceLaConsultaAlServicioConSomething(String transactionId) {

    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LIST_PRODUCT_CARD_MBR)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		RequestHeader rh = new RequestHeader().transactionId(transactionId);
		Request request = new Request().header(rh);
		
		listProductCardResponse =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					header("Cookie", hzSessionId).
					body(request).
				when().
					post().
				then().
//					body("header.resultCode", equalTo("ok")).
//					body("data.accounts[0].productType.code", equalTo("01")).
					log().all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
    }

    @Then("^Verifico que cargo los productos correctamente$")
    public void verificoQueCargoLosProductosCorrectamente() {
		assertEquals("El status code es incorrecto " + listProductCardResponse.getStatusCode() , 200, listProductCardResponse.getStatusCode());    	
    }

}

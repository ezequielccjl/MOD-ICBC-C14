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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.ebanking.model.RequestHeader;
import com.ebanking.retail.model.ChannelDeleteExtractionInput;
import com.ebanking.retail.model.ChannelProductListInputMbr;
import com.ebanking.retail.model.Filter;
import com.ebanking.retail.model.LoginSessionInput;
import com.ebanking.retail.model.ProductListInput;
import com.ebanking.retail.model.RequestChannelDeleteExtractionInput;
import com.ebanking.retail.model.RequestChannelProductListInputMbr;
import com.ebanking.retail.model.RequestLoginSessionInput;
import com.icbc.segmento.digital.util.Link;
import com.icbc.segmento.digital.util.LoginBE;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListProductsMBR {

	private static String hzSessionId;
	private static Response listProductResponse;
	
	@Given("El usuario se loguea exitosamente con {string} {string} {string}")
	public void elUsuarioSeLogueaExitosamenteCon(String user, String pass, String deviceId) {
		
		LoginBE login = new LoginBE(user, pass, deviceId);
		Response loginResponse = login.getResponse();
		hzSessionId = login.getHzSessionId(loginResponse.asString());
		
		assertEquals("El status code es incorrecto" + loginResponse.getStatusCode() , 200, loginResponse.getStatusCode());
	    
	}

    @When("^Hace la consulta al servicio con (.+) (.+)$")
    public void haceLaConsultaAlServicioCon(String transactionid, String filter)  {
    
    	RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri(Link.LISTPRODUCTS)
//				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
    	
    	List<Filter> listCode = new ArrayList<Filter>();
		listCode.add(new Filter().code("01"));
		listCode.add(new Filter().code("02"));
		listCode.add(new Filter().code("11"));
		listCode.add(new Filter().code("12"));
		listCode.add(new Filter().code("17"));
		listCode.add(new Filter().code("37"));
		listCode.add(new Filter().code("38"));
		listCode.add(new Filter().code("61"));
		listCode.add(new Filter().code("62"));
				
		//ProductListInput productListInput = (new ProductListInput()).filter(listCode);
		
		Header cookieHeader = new Header("Cookie", hzSessionId);
		RequestHeader cookieHeader2 = new RequestHeader().sessionId(hzSessionId);
			
		ChannelProductListInputMbr channelProductListInput = new ChannelProductListInputMbr().filter(listCode);
																 	
		RequestChannelProductListInputMbr requestChannelProductListInput = (RequestChannelProductListInputMbr) (new RequestChannelProductListInputMbr())
				.data(channelProductListInput)
				.header(cookieHeader2);		
		
		listProductResponse =		
				given().
					spec(requestSpec).
					contentType(ContentType.JSON).
					body(requestChannelProductListInput).
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

    @Then("^Verifico que se cargaron los productos correctamente$")
    public void verificoQueSeCargaronLosProductosCorrectamente() {
		assertEquals("El status code es incorrecto " + listProductResponse.getStatusCode() , 200, listProductResponse.getStatusCode());    	
    }
    
}


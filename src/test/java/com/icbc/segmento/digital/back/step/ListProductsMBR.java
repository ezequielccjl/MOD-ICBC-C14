package com.icbc.segmento.digital.back.step;

import cucumber.api.PendingException;
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

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions()
public class ListProductsMBR {

	@Given("El usuario se loguea exitosamente con {string} {string} {string}")
	public void elUsuarioSeLogueaExitosamenteCon(String user, String pass, String deviceId) {
	    
		Response resp;
		RequestSpecification requestSpec;
		requestSpec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri("https://mbrdev.intranet.local/icbc/servlet/Login?klogonUserId=F27308585&klogonPass=prueba01&kdeviceId=")
				//.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
		
		/*LoginSessionInput loginSessionInput = new LoginSessionInput()
				.userName(user)
				.encodedPassword(pass)
				.deviceId(deviceId);
		
		RequestLoginSessionInput request = (new RequestLoginSessionInput())
				.data(loginSessionInput);*/
		
		resp = 
				given().
				relaxedHTTPSValidation().
				spec(requestSpec).
				contentType(ContentType.JSON).
				queryParam("klogonUserId", user).
				queryParam("klogonPass", pass).
				queryParam("kdeviceId", deviceId).
			when().
				post().
			then().
				body("result", equalTo("ok")).
				//body(matchesJsonSchemaInClasspath("schemas/responseGetVirtualCard.json")).
				log().all().
				extract().
				response();
		
		
		assertEquals("El status code es incorrecto" + resp.getStatusCode() , 200, resp.getStatusCode());
	    
	}

    @When("^Hace la consulta al servicio con (.+) (.+)$")
    public void haceLaConsultaAlServicioCon(String transactionid, String filter)  {
    /*
    	List<Filter> listCode = new ArrayList<Filter>();
		listCode.add(new Filter().code("01"));
		listCode.add(new Filter().code("02"));
		listCode.add(new Filter().code("11"));
		listCode.add(new Filter().code("12"));
		listCode.add(new Filter().code("17"));
		listCode.add(new Filter().code("37"));
		listCode.add(new Filter().code("38"));
		listCode.add(new Filter().code("62"));
		
		RequestHeader requestHeader = (new RequestHeader()).channel("mbr").transactionId(transactionid);
		
		ProductListInput productListInput = (new ProductListInput()).filter(listCode);
			
		ChannelProductListInputMbr channelProductListInput = ( (Object) new ChannelProductListInputMbr()).productListInput(productListInput);

																						 	
		RequestChannelProductListInputMbr requestChannelProductListInput = (new RequestChannelProductListInputMbr()).data(channelProductListInput);
		
		
		respuesta =		
				given().
					spec(reqSpec2).
					cookie("JSESSIONID", sesion).
					body(requestChannelProductListInput).
				when().
					post().
				then().
					body("header.resultCode", equalTo("ok")).
					body("data.accounts[0].productType.code", equalTo("01")).
					log().
					all().
//					body(matchesJsonSchemaInClasspath("schemas/schemaListProducts.json")).
					extract().
					response();	
	}
*/
    }

    @Then("^Verifico que se cargaron los productos correctamente$")
    public void verificoQueSeCargaronLosProductosCorrectamente() {

    }
    
}


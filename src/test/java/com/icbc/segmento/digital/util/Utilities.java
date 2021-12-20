package com.icbc.segmento.digital.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.response.Response;

public class Utilities {
	
	public String prettyPrintResponse(Response aResponse){
        String responseBody = "";
        try{
            responseBody = aResponse.prettyPrint();
        }catch(NullPointerException npe){
            responseBody= "The response is null";
        }

        return responseBody;

    }

	public String getStringFromJsonArray(JSONArray aJsonArray, String aKey){
        String valueToReturn = "";

        for (int i = 0; i < aJsonArray.length(); i++) {
            try {
                JSONObject jsonObject = aJsonArray.getJSONObject(i);
                if (jsonObject.has(aKey)) {
                    valueToReturn = jsonObject.getString(aKey);

                }
            } catch (JSONException e) {
                e.printStackTrace();

            }

        }
        return valueToReturn;

    }
	
}

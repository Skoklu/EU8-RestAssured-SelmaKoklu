package com.cydeo.day7;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PutAndPatchRequestDemo extends SpartanTestBase {

    @DisplayName("PUT request to one spartan for update with map")
    @Test
    public void PUTRequest(){

        //just like post request we have different options to send body, we will go with map
        Map<String,Object> putRequestMap = new LinkedHashMap<>();

        putRequestMap.put("name","BruceWayne");
        putRequestMap.put("gender","Male");
        putRequestMap.put("phone",8877441111L);

        given().contentType(ContentType.JSON)  //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id",123)
                .when().put("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with request body that we send


    }

    @DisplayName("PATCH request to one spartan for partial update with map")
    @Test
    public void PATCHRequest(){

        //just like post request we have different options to send body, we will go with map
        Map<String,Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("phone",8811111111L);

        given().contentType(ContentType.JSON)  //hey api I am sending JSON body
                .body(putRequestMap).log().body()
                .and().pathParam("id",123)
                .when().patch("/api/spartans/{id}")
                .then()
                .statusCode(204);

        //send a GET request after update, make sure updated field changed, or the new info matching
        //with request body that we send


    }

    @DisplayName("DELETE one spartan")
    @Test
    public void DELETESpartan(){

        int idToDelete = 123;

        given().pathParam("id",idToDelete)
                .when().delete("/api/spartan/{id}")
                .then().statusCode(204);
        //send a request after you delete make sure you are getting 404

    }
}

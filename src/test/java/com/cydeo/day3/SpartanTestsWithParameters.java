package com.cydeo.day3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;



public class SpartanTestsWithParameters {

    @BeforeAll
    public static void init(){

        //save baseUrl inside this variable so that we don't need to type each http method
        baseURI = "http://54.211.143.220:8000";
    }

    /*
    Given accept type is json
    And ID parameter value is 5
    When user send GET request to /api/spartans/{id}
    Then response status code should be 200
    And response content type: application/json
    And "Blythe" should be in response payload
     */

    @DisplayName("GET request to /api/spartans/{id} with ID 5")
    @Test
    public void test1(){

        given().
                accept(ContentType.JSON)
                        .and()
                            .pathParam("id",5)
                .when()
                .get("/api/spartans/{id}");




    }
}

package com.cydeo.day3;

import org.junit.jupiter.api.BeforeAll;
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
}

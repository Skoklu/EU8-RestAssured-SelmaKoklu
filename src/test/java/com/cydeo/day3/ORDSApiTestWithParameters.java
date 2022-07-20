package com.cydeo.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithParameters {

    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name
    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        baseURI = "http://54.211.143.220:1000/ords/hr";
    }

    /*
    Given accept type json
    And parameters: Q = {"region_id":2}
    When user sends a GET request to "/countries"
    Then status code is 200
    And content type is application/json
    And payload/body should contain "United States of America"
     */

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("United States of America"));

    }



}

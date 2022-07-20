package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {


    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name
    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        RestAssured.baseURI = "http://54.211.143.220:1000/ords/hr";
    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1(){
        Response response = RestAssured.get("/regions");

        //print the status code
        System.out.println(response.statusCode());


    }
   /*
    Given accept type is application/json
    When user sends GET request the /regions/2
    Then response status code must be 200
    and content type equals to application/json format
    and response body contains Americas
     */

    @DisplayName("GET request to /regions/2")
    @Test
    public void test2(){
        Response response =given().accept(ContentType.JSON)
                .when().get("/regions/2");

        //verify status code
        assertEquals(200, response.statusCode());

        //verify content type
        assertEquals("application/json",response.contentType());

        //verify body contains Americas
        response.prettyPrint();
        assertTrue(response.body().asString().contains("Americas"));
    }



}

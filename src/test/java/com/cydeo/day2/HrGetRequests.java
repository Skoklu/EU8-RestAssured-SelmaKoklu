package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    RestAssured.
}

package com.cydeo.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("GET request to /countries with query param")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":2}")
                .log().all()
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());


        assertEquals("application/json",response.header("Content-Type"));


        assertTrue(response.body().asString().contains("United States of America"));

        response.prettyPrint();

    }

    /*
    Send a GET request to employees and get only employees who work as an IT_PROG
     */
    @DisplayName("Get request to /employees with query param")
    @Test
            public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when().get("employees");

        assertEquals(200,response.statusCode());

        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));

        response.prettyPrint();

    }


    //TASK
    //Print each name of IT_PROG

    @Test
    public void test3(){



    }



}

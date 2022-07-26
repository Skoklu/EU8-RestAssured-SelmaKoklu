package com.cydeo.day2;

import com.cydeo.utilities.HRTestBase;
import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests extends HRTestBase {




    @DisplayName("GET request to /regions")
    @Test
    public void test1(){
        Response response =get("/regions");

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

package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {


    //  Given  Accept type application/json
    //  When user send GET request to api/spartans end point
    //Then status code must be 200
    //  And response content type must be application/json
    //  And response body should include spartan result


    String baseUrl ="http://54.211.143.220:8000";
    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                    .get(baseUrl+"/api/spartans");

        //print status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //print response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do api testing then?
        //verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(), "application/json");

    }
}

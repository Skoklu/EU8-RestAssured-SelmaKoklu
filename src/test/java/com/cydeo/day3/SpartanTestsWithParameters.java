package com.cydeo.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

       Response response = given().
                accept(ContentType.JSON)
                        .and()
                            .pathParam("id",5)
                .when()
                .get("/api/spartans/{id}");

       //verify status code
        assertEquals(200,response.statusCode());

        //verify content type
        assertEquals("application/json",response.contentType());

        //verify Blythe is in the json payload
        assertTrue(response.body().asString().contains("Blythe"));


    }
    /*
    Given accept type is json
    And ID parameter value is 500
    When user sends GET request to /api/spartans/{id}
    Then response status code should be 404
    And response content type: application/json
    And "Not Found" message should be in response payload
     */

    @DisplayName("GET request /api/spartans/{id} Negative Test")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .log().all()
                .pathParam("id",500)
                .when()
                .get("/api/spartans/{id}");

        assertEquals(404,response.statusCode());

        assertEquals("application/json", response.contentType());

        assertTrue(response.body().asString().contains("Not Found"));

        //verify status code
        assertEquals(404,response.statusCode());

        //verify content type
        assertEquals("application/json",response.contentType());

        //verify "Not Found" message is in the json payload/body
        assertTrue(response.body().asString().contains("Not Found"));

        response.prettyPrint();
    }

    /*
    Given accept type is Json
    And query parameters value are:
    gender|Female
    nameContains|e
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response Content-type application/json
    And "Female" should be in response payload/body
    And "Jannet" should be in response payload/body
     */

    @DisplayName("GET request to /api/spartans/searc with Query Params")
    @Test
    public void test3(){

        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .queryParam("nameContains","e")
                .queryParam("gender", "Female")
                .when()
                .get("/api/spartans/search");

        //verify status code
        assertEquals(200,response.statusCode());

        //verify content type
        assertEquals("application/json",response.contentType());

        //verify "Female" is in the json payload/body
        assertTrue(response.body().asString().contains("Female"));

        //verify "Janette" is in the json payload/body
        assertTrue(response.body().asString().contains("Janette"));


        response.prettyPrint();


    }





}

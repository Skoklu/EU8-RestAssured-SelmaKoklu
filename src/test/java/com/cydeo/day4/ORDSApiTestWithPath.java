package com.cydeo.day4;

import com.cydeo.utilities.HRTestBase;
import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class ORDSApiTestWithPath extends HRTestBase {

    @DisplayName("GET request to countries with path method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");
        assertEquals(200,response.statusCode());


       // print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));

        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //print first country id
        String firstCountryId = response.path("items[0].country_id");
        System.out.println("firstCountryId = " + firstCountryId);

        //print second country name
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        //print "http://54.211.143.220:1000/ords/hr/countries/CA"
        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

        //print all country name

        List<String> countryName = response.path("items.country_name");
        System.out.println("countryName = " + countryName);

        //assert that all regions ids are equal to 2
        List<Integer> allRegionsId = response.path("items.region_id");
        for (Integer regionsID : allRegionsId) {
            System.out.println("regionsID = " + regionsID);
            assertEquals(2,regionsID);

        }


    }

    @DisplayName("Get request to /employees with query param")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
                .when().get("employees");

        assertEquals(200,response.statusCode());

        assertEquals("application/json",response.header("Content-Type"));

        assertTrue(response.body().asString().contains("IT_PROG"));

        //make sure we have only IT_PROG as a job_id
        List<String> allJobIDs = response.path("items.job_id");
        for (String jobID : allJobIDs) {
            System.out.println("jobID = " + jobID);
            assertEquals("IT_PROG",jobID);
        }

    }



}

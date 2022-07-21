package com.cydeo.day4;

import com.cydeo.utilities.HrTestBase;
import groovy.transform.ASTTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HrTestBase {


    @DisplayName("GET request to countries")
    @Test
    public void test1(){

        Response response = get("/countries");

        //get the second country name with JsonPath


        //to use JsonPath we assign response to JsonPath

        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items[1].country_name");

        System.out.println("secondCountryName = " + secondCountryName);

        //get all country ids

        List<String> allCountryIDs = jsonPath.getList("items.country_id");
        System.out.println("allCountryIDs = " + allCountryIDs);


        //get all country names where their region id is equal to 2

        List<String> countryNameWithRegionID2 = jsonPath.getList("items.findAll {it.region_id==2}.country_name");
        System.out.println("countryNameWithRegionID2 = " + countryNameWithRegionID2);

    }

    @DisplayName("GET request /employees with query param")
    @Test
     public void test2(){

    }

}

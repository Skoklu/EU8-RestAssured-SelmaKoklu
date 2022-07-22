package com.cydeo.day4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class CBTrainingApiWithJsonPath {

    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name
    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        baseURI = "http://api.cybertektraining.com";




    }

    @DisplayName("GET request to individual student")
    @Test
    public void test1(){

        /* -send a get request to student id 23401 as a path parameter and accept header application/json
        -verify status code = 200/ content type  = application/json;charset=UTF-8/ Content-Encoding = gzip
        -Verify date header exist
        -Assert that:
        1. first_name: Vera
        2. batch: 14
        3. section: 12
        4. emailAddress: aaa@gmail.com
        5. company name: Cybertek
        6. state: IL
        7. zipCode: 60606

        using jsonPath


         */
    }
}

package com.cydeo.day2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrGetRequests {


    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name
    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://54.211.143.220:1000/ords/hr";
    }
}

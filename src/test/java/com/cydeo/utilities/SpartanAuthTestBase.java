package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanAuthTestBase {

    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        baseURI = "http://54.211.143.220:7000";



    }
}

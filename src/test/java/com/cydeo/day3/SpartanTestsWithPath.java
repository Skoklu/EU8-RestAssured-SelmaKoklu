package com.cydeo.day3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTestsWithPath {

    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name
    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        baseURI = "http://54.211.143.220:1000/ords/hr";
    }

    @DisplayName("GET one spartan with path method")
    @Test
    public void test1(){

    }


}

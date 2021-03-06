package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {


    //BeforeAll is an annotation equals to @BeforeClass in testNG, we use it with static method name

    @BeforeAll
    public static void init(){

        //Save BaseURI inside this variable so that we don't need to type each http method.
        baseURI = "http://54.211.143.220:8000";

        //get ip address from configurations
        String dbUrl = "jdbc:oracle:thin:@54.211.143.220:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);


    }
    @AfterAll
    public static void tearDown(){
       // DBUtils.destroy();
    }
}

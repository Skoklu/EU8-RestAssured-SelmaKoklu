package com.cydeo.day6;

import com.cydeo.pojo.Employee;
import com.cydeo.pojo.Region;
import com.cydeo.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ORDSPojoGetRequestTest extends HRTestBase {

    @Test
    public void regionTest(){

        JsonPath jsonPath = get("/regions").then().statusCode(200)
                .log().body()
                .extract().jsonPath();

        Region region1 = jsonPath.getObject("items[0]",Region.class);

        System.out.println("region1 = " + region1);

        System.out.println("region1.getRegion_id() = " + region1.getRegionId());
        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());
        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());


    }
    @DisplayName("GET request the /employees and only get couple of values as a POJO class ")
    @Test
    public void employeeGet(){

        Employee employee1 = get("/employees").then().statusCode(200)
                        .extract().jsonPath().getObject("items[0]",Employee.class);
        System.out.println("employee1 = " + employee1);

    }

    /*
    - Send a get request to regions
    - Verify that region ids are  1,2,3,4
    - Verify that regions names Europe, Americas, Asia, Middle east and Africa
    - Verify that count is 4
    - Try to use POJO as much as possible
    - Ignore nonUsed fields
     */
}
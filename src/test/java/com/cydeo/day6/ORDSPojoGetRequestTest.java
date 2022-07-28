package com.cydeo.day6;

import com.cydeo.pojo.Employee;
import com.cydeo.pojo.Region;
import com.cydeo.pojo.Regions;
import com.cydeo.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @DisplayName("GET request the region only some fields test")

    @Test
    public void regionPojoTest(){

        //Send a get request and save everything inside the regions object
        //since we prepare POJO also for the all properties we don't need to use any path

        Regions regions = get("/regions")
                .then().statusCode(200).extract().response().as(Regions.class);

        //verify count is 4
        assertThat(regions.getCount(),is(4));

        //create  an empty List to store values
        List<String> regionNames = new ArrayList<>();
        List<Integer> regionIds = new ArrayList<>();

        //get list of regions out of regions object
        List<Region> items = regions.getItems();

        //loop through each of the region, save their ids and names to empty list that we prepare
        for (Region region : items) {
            regionIds.add(region.getRegionId());
            regionNames.add(region.getRegion_name());
        }
        System.out.println("regionIds = " + regionIds);
        System.out.println("regionNames = " + regionNames);

        //prepare expected result
        List<Integer> expectedRegionId = Arrays.asList(1,2,3,4);
        List<String> expectedRegionNames = Arrays.asList("Europe","Americas","Asia","Middle East and Africa");

        //compare two result
        assertThat(regionIds,is(expectedRegionId));
        assertThat(regionNames,is(expectedRegionNames));
    }


}

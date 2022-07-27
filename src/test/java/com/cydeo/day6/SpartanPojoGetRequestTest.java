package com.cydeo.day6;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;




public class SpartanPojoGetRequestTest extends SpartanTestBase {

    @DisplayName("GET one spartan and convert it to Spartan Object")
    @Test
    public void oneSpartanPojo(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .log().all()
                .extract().response();

        //De serialize --> JSON to POJO(PlainOld Java Object)(Java Custom Class)
        //2 different way to do this
        //1. using as() method
        //We convert JSON response to SPARTAN object with the help of JACKSON
        //as() method uses JACKSON to de serialize (converting JSON to JAVA class)

        Spartan spartan15 = response.as(Spartan.class);

        System.out.println("spartan15 = " + spartan15);
        System.out.println("spartan15.getId() = " + spartan15.getId());
        System.out.println("spartan15.getName() = " + spartan15.getName());
        System.out.println("spartan15.getGender() = " + spartan15.getGender());
        System.out.println("spartan15.getPhone() = " + spartan15.getPhone());


        //second way of deserialize json to java
        //2. using JsonPath to deserialize to custom class
        JsonPath jsonPath = response.jsonPath();

        Spartan s15 = jsonPath.getObject("",Spartan.class);

        System.out.println("s15 = " + s15);
        System.out.println("s15.getId() = " + s15.getId());
        System.out.println("s15.getName() = " + s15.getName());
        System.out.println("s15.getGender() = " + s15.getGender());
        System.out.println("s15.getPhone() = " + s15.getPhone());

    }

    @DisplayName("GET one Spartan from search endpoint result and use POJO")
    @Test
    public void spartanSearchWithPojo(){

        //  /spartans/search?nameContains=a&gender=Male
        // send get request to above endpoint and save first object with type Spartan POJO

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().queryParam("nameContains","a",
                        "gender","Male")
                .when().get("/api/spartans/search")
                .then().statusCode(200)
                .extract().jsonPath();

        //get the first spartan from content list and put inside spartan object

       Spartan s1 = jsonPath.getObject("content[0]",Spartan.class);

        //System.out.println("s1 = " + s1);

    }
}

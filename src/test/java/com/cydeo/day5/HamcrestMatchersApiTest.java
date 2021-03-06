package com.cydeo.day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

      /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 15,
          name is "Mete",
          gender is "Female",
          phone is 1938695106
   */

    @DisplayName("OneSpartan with Hamcrest and Chaining")
    @Test
    public void test1(){

        given().log().all()
                .accept(ContentType.JSON)
                .and().pathParam("id",15)
                .get("http://54.211.143.220:8000/api/spartans/{id}")
        .then()
                .statusCode(200)
                .and().assertThat()
                .contentType("application/json")
                .and()
                .body("id",equalTo(15),
                        "name",is("Meta"),
                        "gender",is("Female"),
                        "phone",is(1938695106))
                .log().all();






    }

    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData(){

        given()
                .accept(ContentType.JSON)
                .pathParam("id",10423)
                .when()
                .get("http://api.cybertektraining.com/teacher/{id}")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("Content-Length",is("236"))
                .and()
                .header("Date",notNullValue())
                .and().assertThat()
                .body("teachers[0].firstName",is("Alexander"))
                .body("teachers[0].lastName", is("Syrup"))
                .body("teachers[0].gender,",equalTo("male"));

    }

    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){

        //verify Alexander,Darleen,Sean inside the all teachers
        given()
                .accept(ContentType.JSON)
                .when()
                .get("http://api.cybertektraining.com/teacher/all")
                .then()
                .statusCode(200)
                .and()
                .body("teachers.firstName",hasItems("Alexander","Darleen","Sean","Jamal"));


    }

    //Create a spartanUtil class
    //Create a static method that returns Map<String, Object>
    //use faker library (add as the dependency)to assign each time different information
    //for name, gender, phone number
    //then use your method for creating spartan as a map, dynamically


}

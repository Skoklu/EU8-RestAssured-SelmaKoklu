package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonIgnoreProperties(value = "id",allowSetters = true)

public class Spartan {

    /*
    {
        "id":15,
        "name":"Meta",
        "gender":"Female",
        phone":1938695106
     */

    //getter setter
    //toString

    private int id;
    private String name;
    private String gender;
    private long phone;


}

package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//These  annotations belong to lambda
@Getter
@Setter
@ToString

public class Region {


//region_id
    //If your json key and variable name not matching, you can map it with jsonProperty
    @JsonProperty("region_id")  //this comes from JACKSON annotation
    private int regionId;


    @JsonProperty("region_name")
    private String region_name;

    @JsonProperty("links")
    private List<Link> links;


}

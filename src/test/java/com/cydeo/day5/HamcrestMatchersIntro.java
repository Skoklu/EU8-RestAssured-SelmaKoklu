package com.cydeo.day5;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {


    @DisplayName("Assertion with numbers")
    @Test
    public void simpleTest1(){


        //actual 5+5
        assertThat(5+5, is(10));
       assertThat(5+5, equalTo(10));
       //Matchers has 2 overloaded version
        //first that accept actual value
        //second that accept another matchers

        //below example is method is accepting another matchers equal is making it easier
        assertThat(5+5,is(equalTo(10)));

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(9))));

        //NUMBER COMPARISON
        //greaterThan
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()
        assertThat(5+5,is(greaterThan(9)));



    }
    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){

        String text = "EU8 is learning Hamcrest";

        //checking for equality is same as numbers
        assertThat(text,is("EU8 is learning Hamcrest"));
        assertThat(text,equalTo("EU8 is learning Hamcrest"));
        assertThat(text,is(equalTo("EU8 is learning Hamcrest")));


        //check if this text starts with EU8
        assertThat(text,startsWith("EU8"));

        //now do it in case insensitive manner
        assertThat(text,startsWithIgnoringCase("eu8"));

        //endsWith
        assertThat(text,endsWith("rest"));

        //check if text contains String learning
        assertThat(text,containsString("learning"));
        assertThat(text, containsStringIgnoringCase("LEARNING"));


        String str = " ";
        //Check if above str is blank
        assertThat(str,blankString());

        //check if trimmed str is empty string
        assertThat(str.trim(),emptyString());

    }

    @Test
    public void testCollection(){
        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        //check size of list
        assertThat(listOfNumbers,hasSize(10));

        //check if this list hasItem 77
        assertThat(listOfNumbers,hasItem(77));

        //check if this list hasItems 77,54,23
        assertThat(listOfNumbers,hasItems(77,54,23));

        //check if all items greater than 0
        assertThat(listOfNumbers,everyItem(greaterThan(0)));


    }

}

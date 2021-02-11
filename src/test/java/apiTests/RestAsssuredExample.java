package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class RestAsssuredExample {


    @Before
    public void setUpBaseURI(){
        RestAssured.baseURI = "";
    }


//    RestAssured.basePath = ""  // base bath is usually varies from test to test or even within the test so it is
//    better to put it into the code;

    @Test
    public void exampleRA(){

    }



}

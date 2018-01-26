package com.example.myapp

import com.jayway.restassured.RestAssured
import org.junit.BeforeClass
import org.junit.Test

class WarantyIT
{

    @BeforeClass
    static void "set up rest assured properties" ()
    {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 8080
        RestAssured.basePath = "/webapi/monitor/"
    }

    @Test
    static void "should add new warranty and return 201" () {

    }
}

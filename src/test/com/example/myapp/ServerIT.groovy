package com.example.myapp

import com.jayway.restassured.RestAssured
import static com.jayway.restassured.RestAssured.when
import org.junit.BeforeClass
import org.junit.Test

class ServerIT {

    @BeforeClass
    static void "set up rest assured properties" ()
    {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 8080
        RestAssured.basePath = "/myapp/api/computer/"
    }

    @Test
    void "resource should return status 200" ()
    {
        when()
                .get("test").
                then()
        .statusCode(200)
    }
}

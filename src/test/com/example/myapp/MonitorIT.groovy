package com.example.myapp

import com.example.myapp.entites.Monitor
import com.google.gson.GsonBuilder
import com.jayway.restassured.RestAssured
import com.jayway.restassured.response.Response
import org.junit.BeforeClass
import org.junit.Test
import static com.jayway.restassured.RestAssured.given
import static com.jayway.restassured.RestAssured.when

class MonitorIT
{
    static String MODEL = "BENQ"
    static int DIAGONAL = 21

    @BeforeClass
    static void "set up rest assured properties" ()
    {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 8080
        RestAssured.basePath = "/webapi/monitor/"
    }

    @Test
    void "should add monitor and return status 200" ()
    {
        def gson = new GsonBuilder().create()
        given()
            .contentType("application/json")
            .body(gson.toJson(new Monitor(MODEL, DIAGONAL)))
        .when()
            .post("add")
        .then()
            .statusCode(200)
    }

    @Test
    void "should return monitor name and diagonal" ()
    {
        given().
            pathParam(id, 1)
        when()
                .get("{id}")
                .then("{id}").
                statusCode(200)
    }
}

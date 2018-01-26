package com.example.myapp

import com.example.myapp.entites.Computer
import com.google.gson.GsonBuilder
import com.jayway.restassured.RestAssured
import com.jayway.restassured.http.ContentType
import org.junit.BeforeClass
import org.junit.Test

import static com.jayway.restassured.RestAssured.given
import static com.jayway.restassured.RestAssured.when

class ComputerIT {

    String COMPUTER_MODEL = "Kabby"
    String CPU = "Ryzen 7"
    String GPU = "GTX 1080Ti"
    int RAM = 16
    int HDD = 1
    double PRICE = 2999
    int AMOUNT = 1

    @BeforeClass
    static void "set up rest assured properties" ()
    {
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = 8080
        RestAssured.basePath = "/webapi/computer/"
    }

    @Test
    void "should add computer and return status 201" ()
    {
        def gson = new GsonBuilder().create()
        given()
            .contentType(ContentType.JSON)
            .body(gson.toJson(new Computer(COMPUTER_MODEL, RAM, CPU, HDD, GPU,PRICE,AMOUNT)))
        when()
            .post("add").
        then()
            .statusCode(201)
    }
}

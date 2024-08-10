package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.URI;

public class Reqs {
    String url;
    Response response;
    public Reqs(){
        url = "https://reqres.in/";
    }
    public Response GET(String endpoint){
        RestAssured.baseURI = url;
        response = RestAssured.given().get(endpoint);
        return response;
    }

    public Response POST(String endpoint, Object obj){
        RestAssured.baseURI = url;
        response = RestAssured.given().body(String.valueOf(obj)).post(endpoint);
        return response;
    }

    public Response PUT(String endpoint, Object obj){
        RestAssured.baseURI = url;
        response = RestAssured.given().body(String.valueOf(obj)).put(endpoint);
        return response;
    }

    public Response DELETE(String endpoint){
        RestAssured.baseURI = url;
        response = RestAssured.given().delete(endpoint);
        return response;
    }
}

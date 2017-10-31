package tests;

import beans.Scheme;
import core.CorporaApi;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.List;

import static core.Constants.API_URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestGetAndPost {

    //GET
    @Test
    public void getTest(){
        RestAssured
                .given()
                    .log().everything()
                .get(API_URI)
                    .prettyPeek()
                .then().specification(CorporaApi.successResponse());
    }

    //POST
    @Test
    public void postTest(){
        RestAssured
                .given()
                    .log().everything()
                .post(API_URI)
                    .prettyPeek()
                .then()
                    .contentType("text/html")
                    .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

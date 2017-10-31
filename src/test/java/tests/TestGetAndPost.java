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
        System.out.println("================================");
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
        System.out.println("================================");
    }



    @Test
    public void validateCorporaAsAnObject(){
        List<Scheme> answers = CorporaApi.getCorporaAnswers(
                CorporaApi.with()
                .callApi());
        assertThat(answers.size(), lessThan(6 ));
        assertThat(answers.size(), equalTo(5));
        assertThat(answers.size(), greaterThan(0));

        assertThat(answers.get(0).size, equalTo(3));
        assertThat(answers.get(0).id, equalTo("basic_wf_corp_6"));

        assertThat(answers.get(4).size, equalTo(1));
        assertThat(answers.get(4).id, equalTo("ValidAdditionalEmbeddedTags"));

    }
}

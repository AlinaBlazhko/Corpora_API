import beans.Scheme;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import com.sun.xml.internal.ws.server.sei.MessageFiller;
import core.CorporaApi;
import io.restassured.RestAssured;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class TestGetAndPost {

    //GET
    @Test
    public void getTest(){
        RestAssured
                .given()
                    .log().everything()
                .get("http://10.6.223.76:8000/api/corpora")
                    .prettyPeek()
                .then().specification(CorporaApi.successResponse());
    }

    @Test
    public void validateCorporaAsAnObject(){
        List<Scheme> answers = CorporaApi.getCorporaAnswers(
                CorporaApi.with()
                .callApi());
        assertThat(answers.size(), lessThanOrEqualTo(6 ));
        //assertThat(answers.get(0).size, equalTo(1));
    }
}

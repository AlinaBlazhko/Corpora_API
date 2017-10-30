package core;

import beans.Scheme;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;
import java.util.List;

import static core.Constants.API_URI;
import static org.hamcrest.Matchers.lessThan;

public class CorporaApi {

    private CorporaApi(){}

    public static class ApiBuilderCorpora{
        CorporaApi corporaApi;

        private ApiBuilderCorpora(CorporaApi getCorporaApi){
            corporaApi = getCorporaApi;
        }
        public Response callApi(){
            return RestAssured.with()
                    .log().all()
                    .get(API_URI).prettyPeek();
        }
    }

    public static ResponseSpecification successResponse(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static List<Scheme> getCorporaAnswers(Response response) {

        String responseStr = response.print();
        int beginIndex = responseStr.indexOf("{", 2);
        int endIndex = responseStr.lastIndexOf("]");
        String jsonStr = "[" + responseStr.substring(beginIndex, endIndex) + "]";
        Type listType = new TypeToken<List<Scheme>>() {
        }.getType();
        List<Scheme> list = new Gson().fromJson(jsonStr, listType);
        return list;

    }

    public static ApiBuilderCorpora with(){
        CorporaApi api = new CorporaApi();
        return new ApiBuilderCorpora(api);
    }
}

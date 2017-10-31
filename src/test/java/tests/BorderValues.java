package tests;

import beans.Scheme;
import core.CorporaApi;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BorderValues {

    @Test
    public void leftBorder() {
        List<Scheme> answers = CorporaApi.getCorporaAnswers(
                CorporaApi.with()
                        .callApi());
        assertThat(answers.size(), greaterThan(0));
    }

    @Test
    public void rightBorder() {
        List<Scheme> answers = CorporaApi.getCorporaAnswers(
                CorporaApi.with()
                        .callApi());
        assertThat(answers.size(), equalTo(5));
    }

}



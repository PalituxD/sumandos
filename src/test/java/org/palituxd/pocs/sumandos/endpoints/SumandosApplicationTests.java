package org.palituxd.pocs.sumandos.endpoints;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SumandosApplicationTests {

    private static final String EVALUATION_PATH_RESULT = "$.result";
    private static final String EVALUATION_PATH_REASON_CODE = "$.reason.code";

    @Autowired
    private MockMvc mvc;

    @Value("${url.addition}")
    private String ADDITION_URL;

    @Value("${messages.bad-number-format.code}")
    private String BAD_NUMBER_FORMAT_CODE;

    private String number1;
    private String number2;

    private ResultActions resultActions;

    @Test
    public void testAddOperationOkExpectedResult() throws Exception {
        final String num1 = "2", num2 = "5";
        final int expectedResult = 7;
        givenNumbers(num1, num2);
        whenPerformAdditionOperation();
        thenOkExpectedResult(expectedResult);
    }

    @Test
    public void testAddOperationBadExpectedResult() throws Exception {
        final String num1 = "2", num2 = "5";
        final int expectedResult = 9;
        givenNumbers(num1, num2);
        whenPerformAdditionOperation();
        thenBadExpectedResult(expectedResult);
    }

    @Test
    public void testAddOperationBadFormatNumber() throws Exception {
        final String num1 = "2", num2 = "A";
        givenNumbers(num1, num2);
        whenPerformAdditionOperation();
        thenBadNumberFormat();
    }

    private void givenNumbers(String number1, String number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    private void whenPerformAdditionOperation() throws Exception {
        final String url = ADDITION_URL + "/" + number1 + "/" + number2;
        resultActions = mvc.perform(MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void thenOkExpectedResult(int expectedResult) throws Exception {
        resultActions.andExpect(MockMvcResultMatchers.jsonPath(EVALUATION_PATH_RESULT,
                CoreMatchers.is(expectedResult)));
    }

    private void thenBadExpectedResult(int expectedResult) throws Exception {
        resultActions.andExpect(MockMvcResultMatchers.jsonPath(EVALUATION_PATH_RESULT,
                CoreMatchers.not(expectedResult)));
    }

    private void thenBadNumberFormat() throws Exception {
        resultActions.andExpect(MockMvcResultMatchers.jsonPath(EVALUATION_PATH_REASON_CODE,
                CoreMatchers.equalTo(BAD_NUMBER_FORMAT_CODE)));
    }
}

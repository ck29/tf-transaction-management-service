package com.assignment.tf.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.tf.controller.request.TransactionRequest;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

public class TransactionControllerIntegrationTest extends AbstractControllerIntegrationTest{

  @Test
  public void test_TransactionWhenAccountIsNotAvailble() throws Exception {
    TransactionRequest request = new TransactionRequest("aRecepitent",
        "aSender", new BigDecimal(500), "test_message");

    //Expecting 404 error as sender and receiver are not available in account db.
    MvcResult result = performPost("/new", request)
        .andExpect(status().is4xxClientError())
        .andReturn();
  }

}

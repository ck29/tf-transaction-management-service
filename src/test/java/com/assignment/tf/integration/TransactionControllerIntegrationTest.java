package com.assignment.tf.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.tf.client.AccountServiceClient;
import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.response.TransactionResponse;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransactionControllerIntegrationTest extends AbstractControllerIntegrationTest{

  @MockBean
  private AccountServiceClient accountServiceClient;

  @Test
  public void testTransaction() throws Exception {
    TransactionRequest request = new TransactionRequest().setRecipientAccount("NL04ABNA0169208646")
        .setSenderAccount("NL32ABNA0159232856")
        .setAmount(new BigDecimal(500))
        .setTransactionMessage("test_message");

    when(accountServiceClient.credit(any(),any())).thenReturn(new TransactionResponse("trx1","NL04ABNA0169208646","success" , new BigDecimal("500")));
    when(accountServiceClient.debit(any(),any())).thenReturn(new TransactionResponse("trx2","NL32ABNA0159232856","success" , new BigDecimal("500")));

    MvcResult result = performPost("/transactions", request)
        .andExpect(status().is2xxSuccessful())
        .andReturn();

    verify(accountServiceClient, times(1)).debit("NL32ABNA0159232856", new BigDecimal("500"));
    verify(accountServiceClient, times(1)).credit("NL04ABNA0169208646",new BigDecimal("500"));
  }

}

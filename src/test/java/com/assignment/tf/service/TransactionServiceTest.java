package com.assignment.tf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.assignment.tf.client.AccountServiceInterface;
import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.exception.AccountNotFoundException;
import com.assignment.tf.repository.TransactionRepositoryService;
import com.assignment.tf.repository.entities.TransactionEntity;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

  @InjectMocks
  private TransactionService transactionService;

  @Mock
  private AccountServiceInterface client;
  @Mock
  private TransactionRepositoryService repositoryService;

  @Test
  void performTransactionWithValidDetails_returnsSuccessResponse(){
    TransactionRequest transactionRequest= createMockTransactionRequest();

    when(client.debit(any(),any()))
        .thenReturn(mockTransactionResponse());
    when(repositoryService.saveTransaction(any(),any()))
        .thenReturn(new TransactionEntity());

    when(client.credit(any(),any()))
        .thenReturn(mockTransactionResponse());

    when(repositoryService.saveTransaction(any(),any()))
        .thenReturn(new TransactionEntity());

    TransactionResponse response = transactionService.transact(transactionRequest);
    assertEquals(response.status(), "success");


  }

  @Test
  void whenSenderAccountNotFound_throwException(){
    TransactionRequest transactionRequest= createMockTransactionRequest();

    when(client.debit(any(),any()))
        .thenThrow(AccountNotFoundException.class);

    assertThrows(AccountNotFoundException.class, () -> transactionService
        .transact(transactionRequest));

  }

  @Test
  void whenCreditFails_throwExceptionAfterRollback(){
    TransactionRequest transactionRequest= createMockTransactionRequest();

    when(client.debit(any(),any()))
        .thenReturn(mockTransactionResponse());
    when(repositoryService.saveTransaction(any(),any()))
        .thenReturn(new TransactionEntity());

    when(client.credit(any(),any()))
        .thenThrow(AccountNotFoundException.class);

    assertThrows(AccountNotFoundException.class, () -> transactionService
        .transact(transactionRequest));
    verify(client, times(2)).credit(any(),any());


  }

  private TransactionRequest createMockTransactionRequest() {
    return new TransactionRequest("aRecipient",
        "aSender",
        new BigDecimal("1000"),
        "test_messgae");
  }

  private TransactionResponse mockTransactionResponse(){
    return new TransactionResponse("aAccountId", "success", new BigDecimal("200"));
  }
}

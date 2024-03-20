package com.assignment.tf.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.request.TransactionType;
import com.assignment.tf.repository.entities.TransactionEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryServiceTest {
  @InjectMocks
  private TransactionRepositoryService transactionRepositoryService;

  @Mock
  private TransactionRepository repository;

  @Test
  void getAllTransactions_returnAllEntities() {
    when(repository.findBySender(any())).thenReturn(Optional.of(List.of(new TransactionEntity().setSender("adSender"))));

    List<TransactionEntity> entities =  transactionRepositoryService.getAllTransactions("aSender");
    assertEquals(entities.size(),1);

  }
  @Test
  void getAllTransactions_returnNull() {
    when(repository.findBySender(any())).thenReturn(Optional.empty());

    List<TransactionEntity> entities =  transactionRepositoryService.getAllTransactions("aSender");
    assertEquals(entities.size(),0);

  }


  private TransactionRequest createMockTransactionRequest() {
    return new TransactionRequest("aRecipient",
        "aSender",
        new BigDecimal("1000"),
        "test_messgae");
  }
}
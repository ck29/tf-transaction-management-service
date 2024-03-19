package com.assignment.tf.service;

import com.assignment.tf.client.AccountServiceInterface;
import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.request.TransactionStatus;
import com.assignment.tf.controller.request.TransactionType;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.exception.AccountNotFoundException;
import com.assignment.tf.exception.InsufficientFundException;
import com.assignment.tf.mapper.TransactionMapper;
import com.assignment.tf.repository.TransactionRepositoryService;
import com.assignment.tf.repository.entities.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final AccountServiceInterface client;
  private final TransactionRepositoryService repositoryService;

  public TransactionResponse transact(TransactionRequest transactionRequest) {
    TransactionEntity entity = null;

    client.debit(transactionRequest.senderAccount(), transactionRequest.amount());
    repositoryService.saveTransaction(transactionRequest, TransactionType.DEBIT);

    try {
      client.credit(transactionRequest.recipientAccount(), transactionRequest.amount());
      entity = repositoryService.saveTransaction(transactionRequest, TransactionType.CREDIT);

    } catch (AccountNotFoundException | InsufficientFundException e) {

      client.credit(transactionRequest.senderAccount(), transactionRequest.amount());
      repositoryService.saveTransaction(transactionRequest, TransactionType.CREDIT);
      throw e;
    }

    return TransactionMapper.mapTransactionResponse(entity, TransactionStatus.SUCCESS);
  }



}

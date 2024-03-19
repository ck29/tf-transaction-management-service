package com.assignment.tf.service;

import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionClient client;

  public TransactionResponse transact(TransactionRequest transactionRequest) {

  }



}

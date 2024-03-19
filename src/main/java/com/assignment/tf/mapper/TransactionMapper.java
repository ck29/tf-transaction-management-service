package com.assignment.tf.mapper;

import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.request.TransactionStatus;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.repository.entities.TransactionEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

  public static TransactionResponse mapTransactionResponse(TransactionEntity entity, TransactionStatus status){
    return new TransactionResponse(entity.getRecipient(), status.getValue(), entity.getAmount());

  }

  public static TransactionResponse mapTransactionResponse(TransactionRequest request, TransactionStatus status){
    return new TransactionResponse(request.recipientAccount(), status.getValue(), request.amount());

  }
}

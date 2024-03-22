package com.assignment.tf.mapper;

import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.request.TransactionStatus;
import com.assignment.tf.controller.response.Transaction;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.repository.entities.TransactionEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

  public static TransactionResponse mapTransactionResponse(TransactionEntity entity, TransactionStatus status){
    return new TransactionResponse(entity.getTransactionId(), entity.getAccount(), status.getValue(), entity.getAmount());

  }


  public static List<Transaction> mapToTransactions(List<TransactionEntity> entities){
    return entities.stream()
        .map(entity -> new Transaction(entity.getTransactionId(),
            entity.getAccount(),
            entity.getTransactionMessage(),
            entity.getAmount(),
            entity.getType(),
            entity.getCreatedTimestamp()
        ))
        .collect(Collectors.toList());
  }
}

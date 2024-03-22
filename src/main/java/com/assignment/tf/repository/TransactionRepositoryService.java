package com.assignment.tf.repository;

import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.request.TransactionType;
import com.assignment.tf.repository.entities.TransactionEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionRepositoryService {

  private final TransactionRepository repository;

  public List<TransactionEntity> getAllTransactions(String senderid) {
    return repository.findAllByAccount(senderid);
  }

  public TransactionEntity saveTransaction(TransactionRequest request, TransactionType type) {
    return repository.save(new TransactionEntity()
        .setTransactionMessage(request.getTransactionMessage())
        .setAccount(TransactionType.CREDIT.getValue().equals(type.getValue()) ?
               request.getRecipientAccount():
                request.getSenderAccount())
        .setAmount(request.getAmount())
        .setType(type.getValue()));
  }


}

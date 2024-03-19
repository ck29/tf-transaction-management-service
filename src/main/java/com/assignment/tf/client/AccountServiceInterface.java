package com.assignment.tf.client;

import com.assignment.tf.controller.response.BalanceResponse;
import com.assignment.tf.controller.response.TransactionResponse;
import java.math.BigDecimal;

public interface AccountServiceInterface {

  TransactionResponse credit(String accountId, BigDecimal amount);
  TransactionResponse debit(String accountId, BigDecimal amount);

}

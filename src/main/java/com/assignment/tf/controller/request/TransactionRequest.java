package com.assignment.tf.controller.request;

import java.math.BigDecimal;

public record TransactionRequest(String recipientAccount, String senderAccount, BigDecimal amount, String transactionMessage){

}

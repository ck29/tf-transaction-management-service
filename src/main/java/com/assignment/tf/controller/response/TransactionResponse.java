package com.assignment.tf.controller.response;


import java.math.BigDecimal;

public record TransactionResponse(String transactionId, String account, String status, BigDecimal lastTransactionAmount) {

}

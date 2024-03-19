package com.assignment.tf.controller.response;


import java.math.BigDecimal;

public record TransactionResponse(String accountId, String status, BigDecimal lastTransactionAmount) {

}

package com.assignment.tf.controller.response;

import java.math.BigDecimal;

public record TransactionResponse(String recipientAccountId, String status, BigDecimal amount) {

}

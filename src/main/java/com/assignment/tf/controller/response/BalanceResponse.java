package com.assignment.tf.controller.response;

import java.math.BigDecimal;

public record BalanceResponse(String accountId, BigDecimal lastTransactionAmount) {

}

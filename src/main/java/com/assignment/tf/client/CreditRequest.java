package com.assignment.tf.client;

import java.math.BigDecimal;

public record CreditRequest(String accountId, BigDecimal amount) {

}

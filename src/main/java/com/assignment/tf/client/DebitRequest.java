package com.assignment.tf.client;

import java.math.BigDecimal;

public record DebitRequest(String accountId, BigDecimal amount) {

}

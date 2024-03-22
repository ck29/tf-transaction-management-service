package com.assignment.tf.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String transactionId, String account, String transactionMessage, BigDecimal amount, String type, LocalDateTime timestamp) {
}

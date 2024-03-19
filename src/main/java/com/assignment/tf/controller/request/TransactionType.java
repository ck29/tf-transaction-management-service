package com.assignment.tf.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionType {
  CREDIT("credit"), DEBIT("debit");

  @Getter
  private final String value;
}

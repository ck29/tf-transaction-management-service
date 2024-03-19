package com.assignment.tf.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionStatus {
  SUCCESS("success"),
  FAILED("failed");

  @Getter
  private final String value;

}

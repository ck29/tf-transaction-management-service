package com.assignment.tf.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Entity
@Accessors(chain = true)
@Table(name = "transaction")
public class TransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String transactionId;

  @Column(name = "sender", nullable = false)
  private String sender;

  @Column(name="recipient", nullable = false)
  private String recipient;

  @Column(name="transaction-message", nullable = false)
  private String transactionMessage;

  @Column(name="amount", nullable = false)
  private BigDecimal amount;

  @Column(name="type", nullable = false)
  private String type;

}


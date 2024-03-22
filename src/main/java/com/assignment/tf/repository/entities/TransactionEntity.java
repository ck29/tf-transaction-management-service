package com.assignment.tf.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "transaction")
public class TransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String transactionId;

  @Column(name = "account", nullable = false)
  private String account;

  @Column(name="transaction-message", nullable = false)
  private String transactionMessage;

  @Column(name="amount", nullable = false)
  private BigDecimal amount;

  @Column(name="type", nullable = false)
  private String type;

  @CreationTimestamp
  @Column(name="created_timestamp", nullable = false)
  private LocalDateTime createdTimestamp;

}


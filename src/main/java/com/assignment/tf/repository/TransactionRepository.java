package com.assignment.tf.repository;

import com.assignment.tf.repository.entities.TransactionEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {

  Optional<List<TransactionEntity>> findBySender(String senderId);

}

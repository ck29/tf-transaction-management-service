package com.assignment.tf.controller.request;

import com.assignment.tf.controller.validator.Iban;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TransactionRequest{
  @Iban
  @Schema(requiredMode = RequiredMode.REQUIRED, example = "NL66ABNA0112234968")
  private String recipientAccount;

  @Iban
  @Schema(requiredMode = RequiredMode.REQUIRED, example = "NL66ABNA0112234928")
  private String senderAccount;

  @DecimalMin(value = "0.0", inclusive = false)
  @Schema(requiredMode = RequiredMode.REQUIRED, example = "2000.00")
  private BigDecimal amount;

  @NotNull
  private String transactionMessage;


}

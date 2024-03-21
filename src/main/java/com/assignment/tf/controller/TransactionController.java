package com.assignment.tf.controller;


import com.assignment.swagger.SwaggerResources;
import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.response.Transaction;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name= SwaggerResources.TRANSACTION_CONTROLLER)
@RequestMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

  private final TransactionService transactionService;

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "202", description = "Accepted"),
  })
  @Operation(
      summary = "create new transaction."
  )
  @ResponseStatus(HttpStatus.ACCEPTED)
  public TransactionResponse createTransaction(@Valid @RequestBody final TransactionRequest transactionRequest){
    log.info("New transaction request received.");
    return transactionService.transact(transactionRequest);
  }

  @GetMapping("/{iban}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Ok"),
  })
  @Operation(
      summary = "Get all transactions."
  )
  public List<Transaction> getTransaction(@PathVariable("iban") String iban){
    log.info("Showing all transactions for {}", iban);
    return transactionService.getTransactions(iban);
  }
}

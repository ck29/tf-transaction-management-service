package com.assignment.tf.controller;


import com.assignment.swagger.SwaggerResources;
import com.assignment.tf.controller.request.TransactionRequest;
import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name= SwaggerResources.TRANSACTION_CONTROLLER)
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

  private final TransactionService transactionService;

  @PostMapping("/new")
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
}

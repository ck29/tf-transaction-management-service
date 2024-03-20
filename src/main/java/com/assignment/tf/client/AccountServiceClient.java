package com.assignment.tf.client;

import com.assignment.tf.controller.response.TransactionResponse;
import com.assignment.tf.exception.AccountNotFoundException;
import com.assignment.tf.exception.InsufficientFundException;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class AccountServiceClient implements AccountServiceInterface {

  private final RestTemplate restTemplate;

  @Value("${account.credit.endpoint}")
  private String creditEndpoint;

  @Value("${account.debit.endpoint}")
  private String debitEndpoint;

  @Override
  public TransactionResponse credit(String accountId, BigDecimal amount) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("content-type", "application/json");

    HttpEntity<CreditRequest> httpEntity = new HttpEntity<>(
        new CreditRequest(accountId, amount),
        headers);
    ResponseEntity<TransactionResponse> response = null;
    try {
      response = restTemplate.exchange(creditEndpoint,
          HttpMethod.PUT, httpEntity, TransactionResponse.class);
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(404))) {
        throw new AccountNotFoundException();
      } else {
        throw e;
      }
    }
    return response.getBody();
  }

  @Override
  public TransactionResponse debit(String accountId, BigDecimal amount) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("content-type", "application/json");

    HttpEntity<CreditRequest> httpEntity = new HttpEntity<>(
        new CreditRequest(accountId, amount),
        headers);
    ResponseEntity<TransactionResponse> response = null;
    try {
      response = restTemplate.exchange(debitEndpoint, HttpMethod.PUT, httpEntity,
          TransactionResponse.class);
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(400))) {
        throw new InsufficientFundException();

      } else if (e.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(404))) {
        throw new AccountNotFoundException();
      } else {
        throw e;
      }
    }

    return response.getBody();
  }
}

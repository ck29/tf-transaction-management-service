package com.assignment.tf.util;

import java.security.SecureRandom;
import org.iban4j.CountryCode;

import org.iban4j.Iban;
import org.iban4j.IbanFormatException;
import org.iban4j.IbanUtil;
import org.iban4j.InvalidCheckDigitException;
import org.iban4j.UnsupportedCountryException;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {
  private final static int MAX_BOUND = 99999999;
  private final static int MIN_BOUND = 10000000;

  public static String createIban(){
    return new Iban.Builder()
        .countryCode(CountryCode.NL)
        .bankCode("ABNA0")
        .accountNumber(createAccountNumber())
        .build().toString();
  }

  public static String createAccountNumber() {
    return String.valueOf(new SecureRandom()
        .nextInt(MAX_BOUND - MIN_BOUND + 1) + MAX_BOUND);
  }

  public static boolean isValidIban(String iban){
    try {
      IbanUtil.validate(iban);
      return true;
    } catch (IbanFormatException | InvalidCheckDigitException | UnsupportedCountryException e) {
      return false;
    }
  }
}
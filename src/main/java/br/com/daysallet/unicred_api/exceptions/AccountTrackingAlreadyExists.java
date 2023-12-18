package br.com.daysallet.unicred_api.exceptions;

public class AccountTrackingAlreadyExists extends RuntimeException {
  public AccountTrackingAlreadyExists() {
    super("Account tracking already exists");
  }
}

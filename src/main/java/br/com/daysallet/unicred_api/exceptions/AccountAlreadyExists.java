package br.com.daysallet.unicred_api.exceptions;

public class AccountAlreadyExists extends RuntimeException {
  public AccountAlreadyExists() {
    super("Account already exists");
  }
}

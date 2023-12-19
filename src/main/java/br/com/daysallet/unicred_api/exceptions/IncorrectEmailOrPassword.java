package br.com.daysallet.unicred_api.exceptions;

public class IncorrectEmailOrPassword extends RuntimeException {
  public IncorrectEmailOrPassword() {
    super("Incorrect email or password.");
  }
}

package br.com.daysallet.unicred_api.exceptions;

public class ClientAlreadyExists extends RuntimeException {
  public ClientAlreadyExists() {
    super("Client already exists");
  }
}

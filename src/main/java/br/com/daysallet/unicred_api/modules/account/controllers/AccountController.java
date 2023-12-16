package br.com.daysallet.unicred_api.modules.account.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import br.com.daysallet.unicred_api.modules.account.useCases.CreateAccountUseCase;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private CreateAccountUseCase createAccountUseCase;
  
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody AccountEntity accountEntity) {
    try{
      var result = this.createAccountUseCase.execute(accountEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
  
}

package br.com.daysallet.unicred_api.modules.account.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import br.com.daysallet.unicred_api.modules.account.dto.CreateAccountDTO;
import br.com.daysallet.unicred_api.modules.account.useCases.AccessAccountUseCase;
import br.com.daysallet.unicred_api.modules.account.useCases.CreateAccountUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private CreateAccountUseCase createAccountUseCase;

  @Autowired
  private AccessAccountUseCase accessAccountUseCase;
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateAccountDTO createAccountDTO) {
    var accountEntity = AccountEntity.builder().clientId(createAccountDTO.getClientId()).build();

    try{
      var result = this.createAccountUseCase.execute(accountEntity);

      return ResponseEntity.ok().body(result);
    } catch (Exception err) {

      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
  
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/")
  public ResponseEntity<Object> get(HttpServletRequest request) {
    var clientId = request.getAttribute("client_id");
    try {
      var account = this.accessAccountUseCase.execute(UUID.fromString(clientId.toString()));
      return ResponseEntity.ok().body(account);
    } catch (Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
}

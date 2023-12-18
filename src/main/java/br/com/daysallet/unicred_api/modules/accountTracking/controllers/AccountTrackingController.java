package br.com.daysallet.unicred_api.modules.accountTracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingEntity;
import br.com.daysallet.unicred_api.modules.accountTracking.useCases.CreateAccountTrackingUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account-tracking")
public class AccountTrackingController {

  @Autowired
  private CreateAccountTrackingUseCase createAccountTrackingUseCase;
  
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody AccountTrackingEntity accountTrackingEntity){
    try {
      var result = this.createAccountTrackingUseCase.execute(accountTrackingEntity);
      return ResponseEntity.ok().body(result);
    }catch(Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
}

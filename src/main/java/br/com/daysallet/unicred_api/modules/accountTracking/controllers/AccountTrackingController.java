package br.com.daysallet.unicred_api.modules.accountTracking.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingEntity;
import br.com.daysallet.unicred_api.modules.accountTracking.useCases.CreateAccountTrackingUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account-tracking")
public class AccountTrackingController {

  @Autowired
  private CreateAccountTrackingUseCase createAccountTrackingUseCase;
  
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody AccountTrackingEntity accountTrackingEntity, HttpServletRequest request){
    var accountId = request.getAttribute("account_id");
    accountTrackingEntity.setAccountId(UUID.fromString(accountId.toString()));

    try {
      var result = this.createAccountTrackingUseCase.execute(accountTrackingEntity);

      return ResponseEntity.ok().body(result);
    }catch(Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
}
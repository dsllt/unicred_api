package br.com.daysallet.unicred_api.modules.accountTracking.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingEntity;
import br.com.daysallet.unicred_api.modules.accountTracking.dto.CreateAccountTrackingDTO;
import br.com.daysallet.unicred_api.modules.accountTracking.useCases.AccessAccountTrackingUseCase;
import br.com.daysallet.unicred_api.modules.accountTracking.useCases.CreateAccountTrackingUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account-tracking")
public class AccountTrackingController {

  @Autowired
  private CreateAccountTrackingUseCase createAccountTrackingUseCase;

  @Autowired
  private AccessAccountTrackingUseCase accessAccountTrackingUseCase;
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateAccountTrackingDTO createAccountTrackingDTO) {
    var accountTrackingEntity = AccountTrackingEntity.builder()
      .accountId(createAccountTrackingDTO.getAccountId())
      .status(createAccountTrackingDTO.getStatus())
      .date(createAccountTrackingDTO.getDate())
      .build();

    try {
      var result = this.createAccountTrackingUseCase.execute(accountTrackingEntity);

      return ResponseEntity.ok().body(result);
    }catch(Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/")
  public ResponseEntity<Object> get(HttpServletRequest request) {
    var accountId = request.getAttribute("account_id");

    try{
      var accountTracking = this.accessAccountTrackingUseCase.execute(UUID.fromString(accountId.toString()));

      return ResponseEntity.ok().body(accountTracking);
    } catch(Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
}
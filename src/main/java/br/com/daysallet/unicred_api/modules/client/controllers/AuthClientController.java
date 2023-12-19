package br.com.daysallet.unicred_api.modules.client.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.client.dto.AuthClientDTO;
import br.com.daysallet.unicred_api.modules.client.useCases.AuthClientUseCase;

@RestController
@RequestMapping("/auth")
public class AuthClientController {
  
  @Autowired
  private AuthClientUseCase authClientUseCase;

  @PostMapping("/client")
  public ResponseEntity<Object> create(@RequestBody AuthClientDTO authClientDTO) {
    try {
      var result = this.authClientUseCase.execute(authClientDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}
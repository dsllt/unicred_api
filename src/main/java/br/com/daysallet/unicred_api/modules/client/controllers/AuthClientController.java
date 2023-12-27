package br.com.daysallet.unicred_api.modules.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.client.dto.AuthClientDTO;
import br.com.daysallet.unicred_api.modules.client.useCases.AuthClientUseCase;

@RestController
@RequestMapping("/client")
public class AuthClientController {
  
  @Autowired
  private AuthClientUseCase authClientUseCase;

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/auth")
  public ResponseEntity<Object> create(@RequestBody AuthClientDTO authClientDTO) {

    try {
      var token = this.authClientUseCase.execute(authClientDTO);

      return ResponseEntity.ok().body(token);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}

package br.com.daysallet.unicred_api.modules.client.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.client.ClientEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
  
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity){
    try {
      return ResponseEntity.ok().body(clientEntity);
    } catch (Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }
}

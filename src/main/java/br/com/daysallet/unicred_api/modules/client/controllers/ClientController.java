package br.com.daysallet.unicred_api.modules.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daysallet.unicred_api.modules.client.ClientEntity;
import br.com.daysallet.unicred_api.modules.client.dto.UpdateClientDTO;
import br.com.daysallet.unicred_api.modules.client.useCases.CreateClientUseCase;
import br.com.daysallet.unicred_api.modules.client.useCases.UpdateClientUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@Transactional
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private CreateClientUseCase createClientUseCase;

  @Autowired
  private UpdateClientUseCase updateClientUseCase;
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity){
    try {
      var result = this.createClientUseCase.execute(clientEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }

  @PutMapping("/")
  @Transactional
  public void update(@Valid @RequestBody UpdateClientDTO updateClientDTO){
    this.updateClientUseCase.execute(updateClientDTO, updateClientDTO.getId());
  }
}

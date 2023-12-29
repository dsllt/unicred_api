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
import br.com.daysallet.unicred_api.modules.client.dto.CreateClientResponseDTO;
import br.com.daysallet.unicred_api.modules.client.useCases.CreateClientUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@Transactional
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private CreateClientUseCase createClientUseCase;
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity){
    try {
      var result = this.createClientUseCase.execute(clientEntity);

      var createClientResponse = CreateClientResponseDTO.builder()
        .id(result.getId())
        .name(result.getName())
        .cnpj(result.getCnpj())
        .phone(result.getPhone())
        .email(result.getEmail())
        .address(result.getAddress())
        .createdAt(result.getCreatedAt())
        .build();

      return ResponseEntity.ok().body(createClientResponse);
    } catch (Exception err) {
      return ResponseEntity.badRequest().body(err.getMessage());
    }
  }

  // @PutMapping("/")
  // @Transactional
  // public void update(@Valid @RequestBody UpdateClientDTO updateClientDTO){
  //   this.updateClientUseCase.execute(updateClientDTO, updateClientDTO.getId());
  // }
}

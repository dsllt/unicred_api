package br.com.daysallet.unicred_api.modules.client.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.exceptions.ClientAlreadyExists;
import br.com.daysallet.unicred_api.modules.client.ClientEntity;
import br.com.daysallet.unicred_api.modules.client.ClientRepository;

@Service
public class CreateClientUseCase {

  @Autowired
  private ClientRepository clientRepository;
  
  public ClientEntity execute(ClientEntity clientEntity){
    this.clientRepository.findByIdOrCnpj(clientEntity.getId(), clientEntity.getCnpj()).ifPresent((client) -> {
      throw new ClientAlreadyExists();
    });

    return this.clientRepository.save(clientEntity);
  }
}
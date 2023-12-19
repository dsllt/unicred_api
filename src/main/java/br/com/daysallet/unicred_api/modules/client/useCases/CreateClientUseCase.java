package br.com.daysallet.unicred_api.modules.client.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.exceptions.ClientAlreadyExists;
import br.com.daysallet.unicred_api.modules.client.ClientEntity;
import br.com.daysallet.unicred_api.modules.client.ClientRepository;

@Service
public class CreateClientUseCase {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  public ClientEntity execute(ClientEntity clientEntity){
    this.clientRepository.findByEmailOrCnpj(clientEntity.getEmail(), clientEntity.getCnpj()).ifPresent((client) -> {
      throw new ClientAlreadyExists();
    });

    var password = passwordEncoder.encode(clientEntity.getPassword());
    clientEntity.setPassword(password);

    return this.clientRepository.save(clientEntity);
  }
}
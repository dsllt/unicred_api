package br.com.daysallet.unicred_api.modules.account.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.modules.account.AccountRepository;
import br.com.daysallet.unicred_api.modules.account.dto.AccessAccountDTO;
import br.com.daysallet.unicred_api.modules.client.ClientRepository;

@Service
public class AccessAccountUseCase {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private AccountRepository accountRepository;
  
  public AccessAccountDTO execute(UUID clientId) throws UsernameNotFoundException {
    var client = this.clientRepository.findById(clientId).orElseThrow(() -> {
      throw new UsernameNotFoundException("Usuário não encontrado");
    });

    var account = this.accountRepository.findByClientId(clientId).orElseThrow(() -> {
      throw new UsernameNotFoundException("Conta não encontrada");
    });

    var accountDTO = AccessAccountDTO.builder()
      .clientId(client.getId())
      .name(client.getName())
      .cnpj(client.getCnpj())
      .phone(client.getPhone())
      .email(client.getEmail())
      .address(client.getAddress())
      .accountId(account.getId())
      .requestDate(account.getRequestDate())
      .approvalDate(account.getApprovalDate())
      .build();

    return accountDTO;
    
  }
}

package br.com.daysallet.unicred_api.modules.account.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.exceptions.AccountAlreadyExists;
import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import br.com.daysallet.unicred_api.modules.account.AccountRepository;
import br.com.daysallet.unicred_api.modules.account.dto.CreateAccountResponseDTO;
@Service
public class CreateAccountUseCase {

  @Autowired
  private AccountRepository accountRepository;
  
  public CreateAccountResponseDTO execute(AccountEntity accountEntity){
    this.accountRepository.findByClientId(accountEntity.getClientId()).ifPresent((account) -> {
    throw new AccountAlreadyExists();
  });

  this.accountRepository.save(accountEntity);

  var createAccountTrackingResponse = CreateAccountResponseDTO.builder()
      .id(accountEntity.getId())
      .clientId(accountEntity.getClientId())
      .requestDate(accountEntity.getRequestDate())
      .approvalDate(accountEntity.getApprovalDate())
      .build();

    return createAccountTrackingResponse;
  }
}

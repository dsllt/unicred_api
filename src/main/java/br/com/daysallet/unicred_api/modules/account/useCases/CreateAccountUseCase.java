package br.com.daysallet.unicred_api.modules.account.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.exceptions.AccountAlreadyExists;
import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import br.com.daysallet.unicred_api.modules.account.AccountRepository;

@Service
public class CreateAccountUseCase {

  @Autowired
  private AccountRepository accountRepository;
  
  public AccountEntity execute(AccountEntity accountEntity){
    this.accountRepository.findByIdOrClientId(accountEntity.getId(), accountEntity.getClientId()).ifPresent((account) -> {
    throw new AccountAlreadyExists();
  });

    return this.accountRepository.save(accountEntity);
  }
}

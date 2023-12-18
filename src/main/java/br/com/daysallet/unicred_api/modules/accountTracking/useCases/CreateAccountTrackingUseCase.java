package br.com.daysallet.unicred_api.modules.accountTracking.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.exceptions.AccountTrackingAlreadyExists;
import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingEntity;
import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingRepository;

@Service
public class CreateAccountTrackingUseCase {

  @Autowired
  private AccountTrackingRepository accountTrackingRepository;
  
  public AccountTrackingEntity execute(AccountTrackingEntity accountTrackingEntity){
    this.accountTrackingRepository.findByIdOrAccountId(accountTrackingEntity.getId(), accountTrackingEntity.getAccountId()).ifPresent((account) -> {
      throw new AccountTrackingAlreadyExists();
    });;
    return this.accountTrackingRepository.save(accountTrackingEntity);
  }
}

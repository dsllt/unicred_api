package br.com.daysallet.unicred_api.modules.accountTracking.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingEntity;
import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingRepository;
import br.com.daysallet.unicred_api.modules.accountTracking.dto.CreateAccountTrackingResponseDTO;

@Service
public class CreateAccountTrackingUseCase {

  @Autowired
  private AccountTrackingRepository accountTrackingRepository;
  
  public CreateAccountTrackingResponseDTO execute(AccountTrackingEntity accountTrackingEntity){    
    this.accountTrackingRepository.save(accountTrackingEntity);

    var createAccountTrackingResponse = CreateAccountTrackingResponseDTO.builder()
      .id(accountTrackingEntity.getId())
      .accountId(accountTrackingEntity.getAccountId())
      .updateDate(accountTrackingEntity.getDate())
      .status(accountTrackingEntity.getStatus())
      .build();

    return createAccountTrackingResponse;
  }
}

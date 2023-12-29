package br.com.daysallet.unicred_api.modules.accountTracking.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingRepository;
import br.com.daysallet.unicred_api.modules.accountTracking.dto.AccessAccountTrackingDTO;

@Service
public class AccessAccountTrackingUseCase {

  @Autowired
  private AccountTrackingRepository accountTrackingRepository;
  
  public AccessAccountTrackingDTO execute(UUID accountId) {
    var accountTracking = this.accountTrackingRepository.findByAccountId(accountId).orElseThrow(() -> {
      throw new UsernameNotFoundException("Conta não encontrada.");
    });

    var accountTrackingDTO = AccessAccountTrackingDTO.builder()
      .accountId(accountTracking.getId())
      .status(accountTracking.getStatus())
      .updateDate(accountTracking.getDate())
      .build();

    return accountTrackingDTO;
  }
}

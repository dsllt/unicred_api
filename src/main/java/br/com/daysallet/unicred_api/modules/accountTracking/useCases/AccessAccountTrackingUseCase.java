package br.com.daysallet.unicred_api.modules.accountTracking.useCases;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingRepository;
import br.com.daysallet.unicred_api.modules.accountTracking.dto.AccessAccountTrackingDTO;

@Service
public class AccessAccountTrackingUseCase {

  @Autowired
  private AccountTrackingRepository accountTrackingRepository;
  
  public ArrayList<AccessAccountTrackingDTO> execute(UUID accountId) {
    var accountTracking = this.accountTrackingRepository.findAllByAccountId(accountId);

    var accountTrackingDTOList =  new ArrayList<AccessAccountTrackingDTO>();

    accountTracking.forEach((account) -> {
      var accountTrackingDTO = AccessAccountTrackingDTO.builder()
      .accountId(account.getId())
      .status(account.getStatus())
      .date(account.getDate())
      .build();

      accountTrackingDTOList.add(accountTrackingDTO);
    });

    return accountTrackingDTOList;
  }
}

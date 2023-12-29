package br.com.daysallet.unicred_api.modules.accountTracking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import br.com.daysallet.unicred_api.modules.accountTracking.Status;
import lombok.Data;

@Data
public class CreateAccountTrackingDTO {
  UUID accountId;
  Status status;

  @UpdateTimestamp
  private LocalDateTime date;
}

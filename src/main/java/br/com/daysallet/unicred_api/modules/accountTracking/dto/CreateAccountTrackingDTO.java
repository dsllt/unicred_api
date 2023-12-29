package br.com.daysallet.unicred_api.modules.accountTracking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class CreateAccountTrackingDTO {
  UUID accountId;
  String status;

  @UpdateTimestamp
  private LocalDateTime date;
}

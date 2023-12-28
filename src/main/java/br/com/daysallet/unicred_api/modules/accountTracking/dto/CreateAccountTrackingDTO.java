package br.com.daysallet.unicred_api.modules.accountTracking.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateAccountTrackingDTO {
  private UUID accountId;
  private String status;
}

package br.com.daysallet.unicred_api.modules.account.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponseDTO {
  private UUID clientId;
  private UUID id;
  private LocalDateTime requestDate;
  private LocalDateTime approvalDate;
}
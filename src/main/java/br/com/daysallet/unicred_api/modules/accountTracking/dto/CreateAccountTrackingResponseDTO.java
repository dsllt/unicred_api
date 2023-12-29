package br.com.daysallet.unicred_api.modules.accountTracking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.daysallet.unicred_api.modules.accountTracking.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountTrackingResponseDTO {
  private UUID id;
  private UUID accountId;
  private LocalDateTime date;
  private Status status;
}

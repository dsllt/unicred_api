package br.com.daysallet.unicred_api.modules.account.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.daysallet.unicred_api.modules.client.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessAccountDTO {
  private UUID clientId;
  private String name;
  private String cnpj;
  private String phone;
  private String email;
  private Address address;

  private UUID accountId;
  private LocalDateTime requestDate;
  private LocalDateTime approvalDate;
}

package br.com.daysallet.unicred_api.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthClientResponseDTO {
  private String access_token;
  private Long expires_in;
}

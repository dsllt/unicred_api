package br.com.daysallet.unicred_api.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthClientDTO {
  private String email;
  private String password;
}

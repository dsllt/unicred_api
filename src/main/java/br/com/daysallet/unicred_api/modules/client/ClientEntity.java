package br.com.daysallet.unicred_api.modules.client;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "client")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  private String name;
  
  @NotBlank
  @Length(min = 14, max = 14, message = "O CNPJ deve conter 14 caracteres")
  private String cnpj;
  
  private String phone;

  @NotBlank
  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;

  @Embedded
  private Address address;

  @Length(min = 4, message = "A senha deve conter no mínimo 4 caracteres")
  private String password;

  @CreationTimestamp
  private LocalDateTime  createdAt;


}

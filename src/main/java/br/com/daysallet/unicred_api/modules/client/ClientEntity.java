package br.com.daysallet.unicred_api.modules.client;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

  @Email(message = "O campo [email] deve conter um e-mail válido")
  private String email;
  
  private String address;
  private String cep;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  private String username;

  @Length(min = 8, max = 20, message = "A senha deve conter entre (8) e (20) caracteres")
  private String password;

  @CreationTimestamp
  private LocalDateTime  createdAt;


}

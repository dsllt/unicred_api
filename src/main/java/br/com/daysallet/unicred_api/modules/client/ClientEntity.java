package br.com.daysallet.unicred_api.modules.client;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "client")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToMany()
  @JoinColumn(name = "account_id")
  private ClientEntity clientEntity;

  @Column(name = "account_id")
  private UUID accountId;

  private String name;
  private String cnpj;
  private String phone;
  private String email;
  private String address;
  private String cep;
  private String username;
  private String password;

  @CreationTimestamp
  private LocalDateTime  createdAt;


}

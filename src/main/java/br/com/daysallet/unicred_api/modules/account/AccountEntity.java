package br.com.daysallet.unicred_api.modules.account;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.daysallet.unicred_api.modules.client.ClientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "account")
public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @ManyToOne()
  @JoinColumn(name = "client_id")
  private ClientEntity clientEntity;

  @Column(name = "client_id")
  private UUID clientId;

  @Column(name = "request_id")
  private UUID requestId;

  @CreationTimestamp
  private LocalDateTime requestDate;
  private LocalDateTime approvalDate;
}
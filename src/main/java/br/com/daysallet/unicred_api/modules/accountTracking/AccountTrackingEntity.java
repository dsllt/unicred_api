package br.com.daysallet.unicred_api.modules.accountTracking;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "account_tracking")
public class AccountTrackingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne()
  @JoinColumn(name = "account_id")
  private AccountEntity accountEntity;

  @Column(name = "account_id")
  private UUID accountId;
  private LocalDateTime updateDate;
  private String status;
}
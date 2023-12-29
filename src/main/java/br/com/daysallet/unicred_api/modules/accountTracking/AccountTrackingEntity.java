package br.com.daysallet.unicred_api.modules.accountTracking;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import br.com.daysallet.unicred_api.modules.account.AccountEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "account_tracking")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTrackingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", insertable = false, updatable = false)
  private AccountEntity accountEntity;

  @Column(name = "account_id", nullable = false)
  private UUID accountId;

  @UpdateTimestamp
  private LocalDateTime date;

  private String status;
}
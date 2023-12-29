package br.com.daysallet.unicred_api.modules.accountTracking;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccountTrackingStatus {
  String status;
  LocalDateTime date;
}

package br.com.daysallet.unicred_api.modules.accountTracking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTrackingRepository extends JpaRepository<AccountTrackingEntity, UUID>{
  Optional<AccountTrackingEntity> findByAccountId(UUID accountId);
  List<AccountTrackingEntity> findAllByAccountId(UUID accountId);
}

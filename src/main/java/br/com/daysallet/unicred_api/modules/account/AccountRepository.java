package br.com.daysallet.unicred_api.modules.account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
  Optional<AccountEntity> findByClientId(UUID clientId);
}

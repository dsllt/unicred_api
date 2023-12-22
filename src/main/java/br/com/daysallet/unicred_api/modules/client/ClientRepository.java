package br.com.daysallet.unicred_api.modules.client;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID>{
  Optional<ClientEntity> findByEmailOrCnpj(String email, String cnpj);
  Optional<ClientEntity> findByEmail(String email);
  Optional<ClientEntity> findById(UUID clientId);
}

package br.com.daysallet.unicred_api.modules.client.useCases;

import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.daysallet.unicred_api.exceptions.IncorrectEmailOrPassword;
import br.com.daysallet.unicred_api.modules.client.ClientRepository;
import br.com.daysallet.unicred_api.modules.client.dto.AuthClientDTO;
import br.com.daysallet.unicred_api.modules.client.dto.AuthClientResponseDTO;

@Service
public class AuthClientUseCase {
  
  @Value("${security.token.secret}")
  private String secretKey;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthClientResponseDTO execute(AuthClientDTO authClientDTO) throws AuthenticationException{
    var client = this.clientRepository.findByEmail(authClientDTO.getEmail()).orElseThrow(
      () -> {
        throw new IncorrectEmailOrPassword();
      }
    );

    var passwordMatches = this.passwordEncoder.matches(authClientDTO.getPassword(), client.getPassword());

    if(!passwordMatches) {
      throw new IncorrectEmailOrPassword();
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    var expiresIn = Instant.now().plus(Duration.ofHours(2));
    var token = JWT.create()
      .withExpiresAt(expiresIn)
      .withSubject(client.getId().toString())
      .sign(algorithm);

    var authCandidateResponse = AuthClientResponseDTO.builder()
      .access_token(token)
      .expires_in(expiresIn.toEpochMilli())
      .build();

    return authCandidateResponse;
  }
}

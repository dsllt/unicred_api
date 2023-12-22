package br.com.daysallet.unicred_api.security;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.daysallet.unicred_api.modules.account.useCases.AccessAccountUseCase;
import br.com.daysallet.unicred_api.services.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private JWTProvider jwtProvider;

  @Autowired
  private AccessAccountUseCase accessAccountUseCase;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
        SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        if(header != null) {
          var token = this.jwtProvider.validateToken(header);
          if(token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
          }
          request.setAttribute("client_id", token.getSubject());

          var account = this.accessAccountUseCase.execute(UUID.fromString(token.getSubject().toString()));
          var accountId = account.getAccountId();
          request.setAttribute("account_id", accountId);

          UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(token.getSubject(), null, Collections.emptyList());
          SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
  }
  

}

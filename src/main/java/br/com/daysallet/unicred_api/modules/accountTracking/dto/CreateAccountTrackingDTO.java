package br.com.daysallet.unicred_api.modules.accountTracking.dto;

import java.util.UUID;

import br.com.daysallet.unicred_api.modules.accountTracking.AccountTrackingStatus;


public record CreateAccountTrackingDTO(UUID accountId, AccountTrackingStatus[] status) {}

package br.com.daysallet.unicred_api.modules.client;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
  String street;
  String building;
  String sub_building;
  String neighborhood;
  String city;
  String state;
  String country;
  String zip_code;
}
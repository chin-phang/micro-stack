package com.example.demo.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfileDto extends  BaseDto {

  private String firstName;

  private String lastName;

  private String email;

  private String mobilePhone;

  private String addressLine1;

  private String addressLine2;

  private String city;

  private String state;

  private String postalCode;

  private String country;

  private Long accountId;
}

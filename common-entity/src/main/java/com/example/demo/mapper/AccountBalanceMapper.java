package com.example.demo.mapper;

import com.example.demo.dto.AccountBalanceDto;
import com.example.demo.entity.AccountBalance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountBalanceMapper {

  @Mapping(target = "accountId", source = "account.id")
  AccountBalanceDto toDto(AccountBalance entity);

  @Mapping(target = "id", ignore = true)
  AccountBalance toEntity(AccountBalanceDto dto);
}

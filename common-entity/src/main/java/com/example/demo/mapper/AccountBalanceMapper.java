package com.example.demo.mapper;

import com.example.demo.dto.AccountBalanceDto;
import com.example.demo.entity.AccountBalance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountBalanceMapper {

  AccountBalanceDto toDto(AccountBalance entity);

  AccountBalance toEntity(AccountBalanceDto dto);
}

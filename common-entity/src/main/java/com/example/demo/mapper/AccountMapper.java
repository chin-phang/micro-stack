package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    uses = { UserMapper.class },
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {

  @Mapping(target = "userId", source = "user.id")
  AccountDto toDto(Account entity);

  @Mapping(target = "id", ignore = true)
  Account toEntity(AccountDto dto);
}

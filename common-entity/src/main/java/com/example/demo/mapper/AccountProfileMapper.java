package com.example.demo.mapper;

import com.example.demo.dto.AccountProfileDto;
import com.example.demo.entity.AccountProfile;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountProfileMapper {

  @Mapping(target = "accountId", source = "account.id")
  AccountProfileDto toDto(AccountProfile entity);

  @Mapping(target = "id", ignore = true)
  AccountProfile toEntity(AccountProfileDto dto);
}

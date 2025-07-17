package com.example.demo.mapper;

import com.example.demo.dto.AccountProfileDto;
import com.example.demo.entity.AccountProfile;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountProfileMapper {

  AccountProfileDto toDto(AccountProfile entity);

  AccountProfile toEntity(AccountProfileDto dto);
}

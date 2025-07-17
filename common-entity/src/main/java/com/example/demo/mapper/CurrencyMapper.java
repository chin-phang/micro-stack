package com.example.demo.mapper;

import com.example.demo.dto.CurrencyDto;
import com.example.demo.entity.Currency;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CurrencyMapper {

  CurrencyDto toDto(Currency entity);

  @Mapping(target = "id", ignore = true)
  Currency toEntity(CurrencyDto dto);
}

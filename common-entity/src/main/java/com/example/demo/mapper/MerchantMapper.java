package com.example.demo.mapper;

import com.example.demo.dto.MerchantDto;
import com.example.demo.entity.Merchant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MerchantMapper {

  MerchantDto toDto(Merchant entity);

  Merchant toEntity(MerchantDto dto);
}

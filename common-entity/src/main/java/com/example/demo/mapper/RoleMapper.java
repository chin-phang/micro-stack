package com.example.demo.mapper;

import com.example.demo.dto.RoleDto;
import com.example.demo.entity.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {

  RoleDto toDto(Role entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "users", ignore = true)
  Role toEntity(RoleDto dto);
}

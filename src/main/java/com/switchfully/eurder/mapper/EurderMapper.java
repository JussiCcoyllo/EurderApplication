package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Mapper
public interface EurderMapper {

    EurderMapper INSTANCE = Mappers.getMapper(EurderMapper.class);

    EurderDto eurderToEurderDto(Eurder eurder);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "itemGroups", source = "createEurderDtoList")
    Eurder createEurderDtoToEurder(CreateEurderDto createEurderDto);

    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "itemGroups", source = "reEurderDtoList")
    void updateEurderDtoToEurder(ReEurderDto reEurderDto, @MappingTarget Eurder eurder);

    List<EurderDto> eurdersToEurderDtos(List<Eurder> eurders);

    @Mapping(target = "createEurderDtoList", source = "itemGroups")
    CreateEurderDto eurderToCreateEurderDto(Eurder eurder);

    List<ReEurderDto> eurdersToReEurderDtos(List<Eurder> eurders);


}

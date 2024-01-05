package com.switchfully.eurder.mapper;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Mapper
public interface EurderMapper {
    @Autowired
    private ItemGroupMapper itemGroupMapper;

}

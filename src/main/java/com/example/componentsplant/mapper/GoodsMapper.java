package com.example.componentsplant.mapper;

import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.entity.GoodsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring")
public interface GoodsMapper {

    @Mappings({
            @Mapping(target = "id", source = "source.goodsID")
    })
    GoodsEntity sourceToDestination(GoodsDTO source);

    @Mappings({
            @Mapping(target = "goodsID", source = "destination.id")
    })
    GoodsDTO destinationToSource (GoodsEntity destination);
}

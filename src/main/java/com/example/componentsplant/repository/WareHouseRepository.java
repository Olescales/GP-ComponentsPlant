package com.example.componentsplant.repository;

import com.example.componentsplant.entity.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouseEntity, Long> {

    WareHouseEntity getWareHouseEntityByGoodsEntity_Id (Long goodsID);

}

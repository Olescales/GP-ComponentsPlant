package com.example.componentsplant.repository;

import com.example.componentsplant.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity,Long> {

    GoodsEntity getGoodsEntityById (Long goodsID);
}

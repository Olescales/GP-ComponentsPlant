package com.example.componentsplant.repository;

import com.example.componentsplant.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long> {

    GoodsEntity getGoodsEntityById(Long goodsID);

    List<GoodsEntity> getGoodsEntitiesByType (String type);


    /*@Query (value = "SELECT goods.netcost, goods.releasecost, booking_item.quantity " +
            "FROM goods JOIN booking_item ON goods.id = booking_item.goods_id " +
            "WHERE goods.type = ?1 AND booking_item.booking_id IN (SELECT id FROM booking WHERE orderdate = ?2)", nativeQuery = true)
    List<GoodsEntity> findByComplexQuery (String type, LocalDate localdate);*/
}

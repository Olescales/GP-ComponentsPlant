package com.example.componentsplant.repository;


import com.example.componentsplant.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    Optional<OrderEntity> findAllByClientID(Long id);
}

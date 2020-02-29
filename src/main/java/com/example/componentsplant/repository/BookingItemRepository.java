package com.example.componentsplant.repository;

import com.example.componentsplant.entity.BookingItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingItemRepository extends JpaRepository<BookingItemEntity,Long> {

    List<BookingItemRepository> findByBookingEntity_Id (Long id);

}

package com.example.componentsplant.repository;


import com.example.componentsplant.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    List<BookingEntity> findBookingEntitiesByClient_Id (Long id);

    List<BookingEntity> findBookingEntitiesByCondition (String condition);

    BookingEntity findBookingEntityById (Long id);


}

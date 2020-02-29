package com.example.componentsplant.repository;


import com.example.componentsplant.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    List<BookingEntity> findBookingEntitiesByClient_Id (Long id);

    List<BookingEntity> findBookingEntitiesByCondition (String condition);

    BookingEntity findBookingEntityById (Long id);

    @Query(value = "SELECT SUM(booking.sum) FROM booking WHERE booking.orderdate = ?1", nativeQuery = true)
    Double findSumByOrderdate (LocalDate orderdate);
}
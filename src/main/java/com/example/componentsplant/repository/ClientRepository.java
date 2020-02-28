package com.example.componentsplant.repository;

import com.example.componentsplant.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity getClientEntityById (Long id);
}

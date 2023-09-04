package com.example.tata.database.repositories;

import com.example.tata.database.entities.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, UUID> {
}

package com.example.tata.database.repositories;

import com.example.tata.database.entities.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, UUID> {
    @Query("SELECT er FROM ExchangeRateEntity er " +
            "WHERE er.originCurrency.code = :originCurrencyCode " +
            "AND er.destinationCurrency.code = :destinationCurrencyCode")
    Optional<ExchangeRateEntity> findOptionalExchangeRateByCurrencyCodes(
            @Param("originCurrencyCode") String originCurrencyCode,
            @Param("destinationCurrencyCode") String destinationCurrencyCode
    );
}

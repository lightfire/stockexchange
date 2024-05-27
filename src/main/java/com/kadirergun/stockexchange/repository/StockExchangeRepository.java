package com.kadirergun.stockexchange.repository;

import com.kadirergun.stockexchange.model.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
    StockExchange findByName(String name);
}
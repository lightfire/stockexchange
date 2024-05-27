package com.kadirergun.stockexchange.repository;

import com.kadirergun.stockexchange.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
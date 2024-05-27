package com.kadirergun.stockexchange.service;

import com.kadirergun.stockexchange.exception.ResourceNotFoundException;
import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    /**
     * Saves a stock to the repository.
     *
     * @param stock the stock to be saved
     * @return the saved stock
     */
    @Transactional
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    /**
     * Deletes a stock by its ID.
     *
     * @param stockId the ID of the stock to be deleted
     */
    @Transactional
    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }

    /**
     * Updates the price of a stock.
     *
     * @param stockId the ID of the stock to be updated
     * @param newPrice the new price of the stock
     * @return the updated stock
     */
    @Transactional
    public Stock updateStockPrice(Long stockId, BigDecimal newPrice) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        stock.setCurrentPrice(newPrice);
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        return stockRepository.save(stock);
    }
}
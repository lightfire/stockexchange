package com.kadirergun.stockexchange.controller;

import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * Creates a new stock.
     *
     * @param stock the stock to be created
     * @return the created stock
     */
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    /**
     * Updates the price of a stock.
     *
     * @param id the ID of the stock to be updated
     * @param price the new price of the stock
     * @return the updated stock
     */
    @PutMapping
    public Stock updateStockPrice(@RequestParam Long id, @RequestParam BigDecimal price) {
        return stockService.updateStockPrice(id, price);
    }

    /**
     * Deletes a stock by its ID.
     *
     * @param id the ID of the stock to be deleted
     */
    @DeleteMapping
    public void deleteStock(@RequestParam Long id) {
        stockService.deleteStock(id);
    }
}

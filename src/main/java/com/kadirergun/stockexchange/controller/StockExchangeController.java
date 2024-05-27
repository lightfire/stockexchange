package com.kadirergun.stockexchange.controller;

import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.model.StockExchange;
import com.kadirergun.stockexchange.service.StockExchangeService;
import com.kadirergun.stockexchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock-exchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @Autowired
    private StockService stockService;

    /**
     * Retrieves a stock exchange by its name along with all its stocks.
     *
     * @param name the name of the stock exchange
     * @return the stock exchange with the given name
     */
    @GetMapping("/{name}")
    public StockExchange getStockExchange(@PathVariable String name) {
        return stockExchangeService.getStockExchangeByName(name);
    }

    /**
     * Adds a stock to a stock exchange.
     *
     * @param name the name of the stock exchange
     * @param stock the stock to be added
     */
    @PostMapping("/{name}")
    public void addStockToExchange(@PathVariable String name, @RequestBody Stock stock) {
        stockService.saveStock(stock);
        stockExchangeService.addStockToExchange(name, stock);
    }

    /**
     * Removes a stock from a stock exchange.
     *
     * @param name the name of the stock exchange
     * @param stock the stock to be removed
     */
    @DeleteMapping("/{name}")
    public void removeStockFromExchange(@PathVariable String name, @RequestBody Stock stock) {
        stockExchangeService.removeStockFromExchange(name, stock);
    }
}


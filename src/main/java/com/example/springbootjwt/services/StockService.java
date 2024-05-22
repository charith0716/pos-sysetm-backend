package com.example.springbootjwt.services;


import com.example.springbootjwt.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock saveStock(Stock stock);
    Stock updateStock(Long id, Stock stock);
    void deleteStock(Long id);
    Optional<Stock> getStockById(Long id);
    List<Stock> getAllStocks();
}

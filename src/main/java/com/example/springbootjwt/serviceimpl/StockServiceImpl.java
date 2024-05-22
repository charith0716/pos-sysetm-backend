package com.example.springbootjwt.serviceimpl;

import com.example.springbootjwt.entities.Stock;
import com.example.springbootjwt.repo.StockRepository;
import com.example.springbootjwt.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Optional<Stock> existingStock = stockRepository.findById(id);
        if (existingStock.isPresent()) {
            Stock updatedStock = existingStock.get();
            updatedStock.setQuantity(stock.getQuantity());
            updatedStock.setCostPrice(stock.getCostPrice());
            return stockRepository.save(updatedStock);
        } else {
            // Handle case where stock is not found
            return null;
        }
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}


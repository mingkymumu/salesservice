package com.noer.salesservice.service;

import com.noer.salesservice.domain.Sales;
import com.noer.salesservice.exception.SalesException;
import com.noer.salesservice.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    private SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public Sales saveSalesTransaction(Sales sales) {
        return salesRepository.save(sales);
    }

    public List<Sales> getAllSales(){
        return salesRepository.findAll();
    }

    public Optional<Sales> getSalesById(Long id){
        return salesRepository.findById(id);
    }

    public void deleteSales(Long id){
        Sales sales = salesRepository.findById(id).orElseThrow(()-> new SalesException("Sales transaction not found"));
        salesRepository.delete(sales);
    }
}


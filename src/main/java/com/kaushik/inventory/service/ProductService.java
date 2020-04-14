package com.kaushik.inventory.service;

import com.kaushik.inventory.entity.Product;
import com.kaushik.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public void saveOrUpdate(Product category){
        if (category.getDescription().equals("")){
            category.setDescription("---");
        }
        repository.save(category);
    }

    public Iterable<Product> getAllData(){
        return repository.findAll();
    }

    public Optional<Product> getData(Long id){
        return repository.findById(id);
    }

    public void deleteData(Long id){
        repository.deleteById(id);
    }
}

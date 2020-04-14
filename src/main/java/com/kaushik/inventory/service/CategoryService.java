package com.kaushik.inventory.service;

import com.kaushik.inventory.entity.Category;
import com.kaushik.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public void saveOrUpdate(Category category){
        if (category.getDescription().equals("")){
            category.setDescription("---");
        }
        repository.save(category);
    }

    public Iterable<Category> getAllData(){
        return repository.findAll();
    }

    public Optional<Category> getData(Long id){
        return repository.findById(id);
    }

    public void deleteData(Long id){
        repository.deleteById(id);
    }
}

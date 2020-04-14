package com.kaushik.inventory.controller;

import com.kaushik.inventory.entity.Category;
import com.kaushik.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("categories", service.getAllData());
        return "category/index";
    }

    @GetMapping("add")
    public String add(){
        return "category/add";
    }

    @PostMapping("/save")
    public String save(@Valid Category category){
        service.saveOrUpdate(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteData(id);
        return "redirect:/category";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("category", service.getData(id));
        return "category/update";
    }
}

package com.kaushik.inventory.controller;

import com.kaushik.inventory.entity.Product;
import com.kaushik.inventory.service.CategoryService;
import com.kaushik.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("products", service.getAllData());
        return "product/index";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("categories", categoryService.getAllData());
        return "product/add";
    }

    @PostMapping("/save")
    public String save(@Valid Product product){
        service.saveOrUpdate(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteData(id);
        return "redirect:/product";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("product", service.getData(id));
        model.addAttribute("categories", categoryService.getAllData());
        return "product/update";
    }
}

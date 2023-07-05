package com.bimba.bimba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimba.bimba.models.entities.Product;
import com.bimba.bimba.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@Valid @RequestBody Product product, Errors errors){

        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()) {
                System.err.println(error.getDefaultMessage());
            }
            throw new RuntimeException("Validation Error");
        }
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") long id){
        return productService.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") long id){
        productService.removedOne(id);
    }
}

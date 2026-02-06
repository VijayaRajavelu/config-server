package com.vj.product_crud.controller;

import com.vj.product_crud.entity.Product;
import com.vj.product_crud.service.ProductService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


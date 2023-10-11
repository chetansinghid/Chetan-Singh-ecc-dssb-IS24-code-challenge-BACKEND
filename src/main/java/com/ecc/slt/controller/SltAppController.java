package com.ecc.slt.controller;

import com.ecc.slt.model.Product;
import com.ecc.slt.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
@CrossOrigin(originPatterns = "http://localhost:4200", maxAge = 3600)
public class SltAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SltAppController.class);
    @Autowired
    private ProductService service;

    @GetMapping(path = "/all", name = "GET/ALL")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping(path = "/add", name = "POST/ADD")
    public ResponseEntity<Product> saveToDB(@RequestBody @Validated Product product) {
        return ResponseEntity.ok(service.saveProduct(product));
    }

}

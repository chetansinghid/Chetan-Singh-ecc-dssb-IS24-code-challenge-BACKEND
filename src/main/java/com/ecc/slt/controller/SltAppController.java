package com.ecc.slt.controller;

import com.ecc.slt.model.Product;
import com.ecc.slt.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
@CrossOrigin(maxAge = 3600)
public class SltAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SltAppController.class);
    @Autowired
    private ProductService service;

    @GetMapping(path = "/all", name = "GET/ALL")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }
}

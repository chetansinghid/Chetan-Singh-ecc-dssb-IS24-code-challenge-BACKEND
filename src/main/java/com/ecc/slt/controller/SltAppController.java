package com.ecc.slt.controller;

import com.ecc.slt.model.Product;
import com.ecc.slt.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/{number}", name = "GET/ID")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "number") int pNumber) {
        Optional<Product> productOptional = service.getProductByProductNumber(pNumber);
        if(productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping(path = "/update/{number}", name = "PATCH/ID")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "number") int pNumber, @RequestBody @Validated Product updatedProduct) {
        Optional<Product> product = service.getProductByProductNumber(pNumber);
        if(product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setPName(updatedProduct.getPName());
            existingProduct.setScrumMaster(updatedProduct.getScrumMaster());
            existingProduct.setPOwner(updatedProduct.getPOwner());
            existingProduct.setPDevelopers(updatedProduct.getPDevelopers());
            existingProduct.setPMethodology(updatedProduct.getPMethodology());
            existingProduct.setGithubLink(updatedProduct.getGithubLink());

            return ResponseEntity.ok(service.updateProduct(existingProduct));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

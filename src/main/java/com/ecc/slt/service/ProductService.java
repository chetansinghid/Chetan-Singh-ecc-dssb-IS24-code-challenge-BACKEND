package com.ecc.slt.service;

import com.ecc.slt.model.Product;
import com.ecc.slt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private Function<Product, Product> formatPDevelopersWithParenthesis = (Product p) -> {
        p.setPDevelopers("[ " + p.getPDevelopers() + " ]");
        return p;
    };

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(formatPDevelopersWithParenthesis).collect(Collectors.toList());
    }

}

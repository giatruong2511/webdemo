/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.service.impl;

import com.nvt.pojo.Product;
import com.nvt.repository.ProductRepository;
import com.nvt.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
   
    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        return this.productRepository.getProducts(params, page);
    }

    @Override
    public long countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public List<Object[]> getHotProduct(int num) {
        return this.productRepository.getHotProduct(num);
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return this.productRepository.addProduct(product);
    }

    @Override
    public List<Object[]> countProdsByCate() {
        return this.productRepository.countProdsByCate();
    }

    @Override
    public List<Object[]> revenueStats() {
        return this.productRepository.revenueStats();
    }
    
}

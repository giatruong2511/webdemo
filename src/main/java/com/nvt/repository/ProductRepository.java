/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.repository;

import com.nvt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params, int page);
    long countProduct();
    Product getProductById (int productId);
    List<Object[]> getHotProduct(int num);
    boolean deleteProduct(int id);
    boolean addProduct(Product product);
    List<Object[]> countProdsByCate();
    List<Object[]> revenueStats();
    
}


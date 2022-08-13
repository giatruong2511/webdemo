/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.controllers;

import com.nvt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author DELL
 */
//@Controller
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//    @GetMapping("/products/{productId}")
//    public String detail(Model model, @PathVariable(name = "productId") int id){
//        model.addAttribute("product", this.productService.getProductById(id));
//        
//        return "product-detail";
//    }
//}

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products/{productId}")
    public String detail(Model model, @PathVariable(name = "productId") int id) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "product-detail";
    }
    
}
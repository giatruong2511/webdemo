/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.controllers;

import com.nvt.pojo.Cart;
import com.nvt.service.CategoryService;
import com.nvt.service.ProductService;
import com.nvt.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void CateAttr(Model model, HttpSession session){
        model.addAttribute("categories",  this.categoryService.getCategories());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
        
    }
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model, 
            @RequestParam Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("categories",  this.categoryService.getCategories());
        model.addAttribute("products", this.productService.getProducts(params, page));
        model.addAttribute("counter", this.productService.countProduct());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        model.addAttribute("hotProducts", this.productService.getHotProduct(6));
        return "index";
    }
}


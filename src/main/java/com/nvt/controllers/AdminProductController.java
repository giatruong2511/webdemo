/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nvt.pojo.Product;
import com.nvt.service.ProductService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping("/products")
    public String add(Model model, @ModelAttribute(value = "product") @Valid Product p,
            BindingResult r) {
        if (r.hasErrors()) {
            return "products";
        }
        if (p.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.productService.addProduct(p) == true) {
            return "redirect:/";
        }
        model.addAttribute("errMsg", "He thong da xay ra loi! Vui long quay lai sau!");
        return "products";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("catStats", this.productService.countProdsByCate());
        model.addAttribute("revenueStats", this.productService.revenueStats());
        return "stats";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.controllers;

import com.nvt.pojo.Cart;
import com.nvt.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiCartController {
    @PostMapping("/cart")
    public int addToCart(HttpSession session, @RequestBody Cart params){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if(cart == null)
        {
            cart = new HashMap<>();
        }
        int productId = params.getId();
        if (cart.containsKey(productId) == true) { // sp da co trong gio
            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else { // sp chua co trong gio
            cart.put(productId, params);
        }
        
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    @PutMapping("/cart")
    public int updateCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if(cart == null)
        {
            cart = new HashMap<>();
        }
        
        int productId = params.getId();
        if (cart.containsKey(productId) == true) { // sp da co trong gio
            Cart c = cart.get(productId);
            c.setQuantity(params.getQuantity());
        }
        session.setAttribute("cart", cart);
        
        return Utils.countCart(cart);
    }
    @DeleteMapping("/cart/{productId}")
    public int deleteCart(
            @PathVariable(value="productId") Integer productId,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if (cart != null) {
            if (cart.containsKey(productId) == true) {
                cart.remove(productId);
                
                session.setAttribute("cart", cart);
            }
        }
        return Utils.countCart(cart);
    }
}


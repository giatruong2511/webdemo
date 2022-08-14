/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.utils;

import com.nvt.pojo.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Utils {
    
    public static int count(Map<Integer, Cart> cart) {
        int q = 0;
        
        if (cart != null) {
            for (Cart c: cart.values()) {
                q += c.getQuantity();
            }
        }        
        return q;       
    }
    
    public static Map<String, Long> countCart(Map<Integer, Cart> cart) {
        Long q = 0L;
        Long s = 0L;
        if (cart != null) {
            for (Cart c : cart.values()) {
                q += c.getQuantity();
                s += c.getQuantity() * c.getPrice();
            }
        }
        Map<String, Long> results = new HashMap<>();
        results.put("counter", q);
        results.put("amount", s);
        return results;
    }

    
}

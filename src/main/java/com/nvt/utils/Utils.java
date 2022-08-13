/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvt.utils;

import com.nvt.pojo.Cart;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart) {
        int q = 0;
        
        if (cart != null) {
            for (Cart c: cart.values()) {
                q += c.getQuantity();
            }
        }        
        return q;       
    }
}
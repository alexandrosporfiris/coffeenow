/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.service;

import com.ateamforce.coffeenow.model.OrderProduct;

/**
 *
 * @author alexa
 */
public interface OrderProductService {
    
    void addOrderProduct(OrderProduct orderProduct);
    
    void deleteOrderProduct(OrderProduct orderProduct);
    
}

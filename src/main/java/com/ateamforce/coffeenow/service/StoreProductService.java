/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.service;

import com.ateamforce.coffeenow.model.StoreProduct;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface StoreProductService {
    
    void addStoreProduct(StoreProduct storeProduct);
    
    void deleteStoreProduct(StoreProduct storeProduct);
    
    List<StoreProduct> findAllByStoreId(int storeId);
}

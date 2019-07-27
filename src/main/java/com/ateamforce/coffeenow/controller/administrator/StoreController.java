/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.controller.administrator;


import com.ateamforce.coffeenow.model.Store;
import com.ateamforce.coffeenow.model.StoreMedia;
import com.ateamforce.coffeenow.model.StoreProduct;
import com.ateamforce.coffeenow.service.ProductService;
import com.ateamforce.coffeenow.service.StoreMediaService;
import com.ateamforce.coffeenow.service.StorePaymentTypeService;
import com.ateamforce.coffeenow.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/store/dashboard")
public class StoreController {
    
    @Autowired
    StorePaymentTypeService storePaymentTypeService;
    
    @Autowired
    StoreMediaService storeMediaService;
    
    @Autowired
    StoreProductService storeProductService;
    
    @Autowired
    ProductService productService;

    // DASHBOARD
    @RequestMapping
    public String store_dashboard(ModelMap modelmap) {
        
        // add variable to indicate active sidebar menu
        modelmap.addAttribute("dashboardIsActive", "active");
        
        return "back_store/dashboard/index";
    }
    
    // PROFILE page of store. Includes forms for payment types/ profile details / store media
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String store_dashboard_profile(
            @SessionAttribute(name = "currentUser") Store currentUser, 
            ModelMap modelmap, 
            @ModelAttribute("storeMedia") StoreMedia storeMedia
    ) {

        // add store payment types
        modelmap.addAttribute("paytypes", storePaymentTypeService.findAllByStoreId(currentUser.getId()));
        
        // add store media
        // modelmap.addAttribute("allMedia", storeMediaService.findAllByStoreId(currentUser.getId()));
        
        return "back_store/dashboard/profile";
    }
    
    // PRODUCTS
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String store_dashboard_products(
            @SessionAttribute(name = "currentUser") Store currentUser, 
            ModelMap modelmap, 
            @ModelAttribute("newStoreProduct") StoreProduct newStoreProduct
    ) {

        // add store products
        modelmap.addAttribute("storeProducts", storeProductService.findAllByStoreId(currentUser.getId()));
        
        // add products
        modelmap.addAttribute("products", productService.getAllProducts());

        // add variable to indicate active sidebar menu
        modelmap.addAttribute("productsIsActive", "active");
        
        return "back_store/dashboard/products";
    }
    
}

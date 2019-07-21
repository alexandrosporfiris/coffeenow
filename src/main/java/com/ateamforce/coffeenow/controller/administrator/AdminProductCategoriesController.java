/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.controller.administrator;

import com.ateamforce.coffeenow.model.ProductCategory;
import com.ateamforce.coffeenow.service.ExtraService;
import com.ateamforce.coffeenow.service.ProductCategoryService;
import com.ateamforce.coffeenow.service.ProductService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexa
 */
@Controller
@RequestMapping("/administrator/dashboard/productcategories")
public class AdminProductCategoriesController {

    @Autowired
    ProductCategoryService productCategoryService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    ExtraService extraService;

    // INSERT/UPDATE a product category
    @PostMapping
    public String admin_dashboard_productCategories_addProductCategory(
            ModelMap modelmap, 
            @ModelAttribute("productCategory") @Valid ProductCategory productCategory, 
            BindingResult result
    ) throws IOException {
        
        if (result.hasErrors()) {
            modelmap.addAttribute("productcategories", productCategoryService.getAllProductCategories());
            modelmap.addAttribute("products", productService.getAllProducts());
            modelmap.addAttribute("extras", extraService.getAllExtras());
            modelmap.addAttribute("productcategoriesIsActive", "active");
            return "back_admin/dashboard/product_categories";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        productCategoryService.addProductCategory(productCategory);

        return "redirect:/administrator/dashboard/productcategories";
    }

    // DELETE a product category by id
    @GetMapping("/delete/{productCategoryId}")
    public String admin_dashboard_productCategories_deleteProductCategory(@PathVariable int productCategoryId) {
        productCategoryService.deleteProductCategoryById(productCategoryId);
        return "redirect:/administrator/dashboard/productcategories";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.model.repository;

import com.ateamforce.coffeenow.model.ExtrasCategoryProductsCategory;
import com.ateamforce.coffeenow.model.ExtrasCategoryProductsCategoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexa
 */ 
@Repository
public interface ExtrasCategoryProductsCategoryRepository extends JpaRepository<ExtrasCategoryProductsCategory
        ,ExtrasCategoryProductsCategoryPK>{
    
}

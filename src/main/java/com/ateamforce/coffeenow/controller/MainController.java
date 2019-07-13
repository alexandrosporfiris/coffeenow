package com.ateamforce.coffeenow.controller;

import com.ateamforce.coffeenow.model.Administrator;
import com.ateamforce.coffeenow.model.AppRole;
import com.ateamforce.coffeenow.service.impl.AppUserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    // Home Page
    @RequestMapping
    public String home(Model model) {
        return "front/index";
    }

    // Administrator Backend Login Page
    @RequestMapping("/administrator")
    public String admin_login() {
        return "back_admin/index";
    }

    // Store Backend Login Page
    @RequestMapping("/store")
    public String store_login() {
        return "back_store/index";
    }

    // TODO : Move this to the store controller, when it is created (like in AdministratorController)
    @RequestMapping("/store/dashboard")
    public String store_dashboard() {
        return "back_store/dashboard/index";
    }

}

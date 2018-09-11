/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;


import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;
   
    @GetMapping
    public String index(Model model) {
        long id=1;
        return "auth/register";
    }
     @PostMapping
    public String index(@ModelAttribute("User") User user) {
        Set<Role> role=new HashSet<>();
        long id=1;
        role.add(new Role(id,"Admin"));
        user.setRoles(role);
        user.setStatus(true);
        userService.save(user);
        return "redirect:admin/roles";
    }

}

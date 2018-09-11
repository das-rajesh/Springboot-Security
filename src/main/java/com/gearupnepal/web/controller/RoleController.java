/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.repository.RoleRepository;
import com.gearupnepal.web.service.RoleService;
import java.awt.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        roleService.save(new Role(id, "Admin"));
        roleService.save(new Role(id+1, "Manager"));
        roleService.save(new Role(id+2, "User"));
        model.addAttribute("roles", roleService.getAll());
        return "admin/roles/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/roles/add";
    }

    @PostMapping(value = "/save")
    public String add(Role role) {
        roleService.save(role);
        return "redirect:/admin/roles";
    }
}

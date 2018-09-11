/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Setting;
import com.gearupnepal.web.entity.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

   
    @GetMapping
    @ResponseBody
    public String index(Model model) {
        long id=1;
        return "<h1>Home Controller</h1>";
    }

}

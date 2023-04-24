package com.cebem.RickAndMorty.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/rickandmorty/allTemplates")

    public String charactersTemplates(Model modelo){
        
        return "rickandmortyall";
       }

}

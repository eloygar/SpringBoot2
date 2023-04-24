package com.cebem.RickAndMorty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cebem.RickAndMorty.models.CharactersModel;
import com.cebem.RickAndMorty.services.RickAndMortyService;

@Controller
public class WebController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @RequestMapping("/rickandmorty/allTemplates")
    public String charactersTemplates(Model modelo) {

        CharactersModel charactersModel = rickAndMortyService.getAllCharacter();

        modelo.addAttribute("creator", "creado por Eloy");
        modelo.addAttribute("characters", charactersModel.results);

        return "rickandmortyall";
    }

}

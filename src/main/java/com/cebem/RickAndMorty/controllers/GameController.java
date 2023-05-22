package com.cebem.RickAndMorty.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebem.RickAndMorty.models.GameModel;
import com.cebem.RickAndMorty.services.GameService;

@Controller
public class GameController {
    @Autowired
    GameService GameService;

    @RequestMapping("/Games")
    public String Games() {
        ArrayList<GameModel> Games = GameService.getAllGames();
        String html = "";
        for (GameModel meme : Games) {
            html += meme.getDescription();
            html += "<hr/>";
        }
        return html;

    }

    @RequestMapping("/Games")
    public String Games(Model model) {
        ArrayList<GameModel> Games = GameService.getAllGames();
        model.addAttribute("misGames", Games);

        return "GameList";

    }

    @PostMapping("/Games")
    public String GamesAdd(@RequestParam Map<String, String> body) {
        String description = body.get("description");
        String categoria = body.get("categoria");
        String autor = body.get("autor");
        GameModel nuevoGames = new GameModel();
        nuevoGames.setDescription(description);
        nuevoGames.setCategory(categoria);
        nuevoGames.setAuthor(autor);
        GameService.CreateGames(nuevoGames);
        return "GameOK";

    }

    @RequestMapping("/Games")
    public String GamesAddForm() {

        return "memeAddForm";

    }
}

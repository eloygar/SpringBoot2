package com.cebem.RickAndMorty.controllers;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebem.RickAndMorty.models.MemeModel;
import com.cebem.RickAndMorty.services.MemesServices;

@Controller
public class MemeController {
    @Autowired
    MemesServices memesServices;

    @RequestMapping("/memes")
    public String memes() {
        ArrayList<MemeModel> memes = memesServices.getAllMemes();
        String html = "";
        for (MemeModel meme : memes) {
            html += meme.getDescription();
            html += "<img src>" + meme.getUrl() + "'>'";
            html += "<hr/>";
        }
        return html;

    }

    @RequestMapping("/memes")
    public String memes(Model model) {
        ArrayList<MemeModel> memes = memesServices.getAllMemes();
        model.addAttribute("misMemes", memes);

        return "memeList";

    }

    @PostMapping("/memes")
    public String memesAdd(@RequestParam Map<String, String> body) {
        String description = body.get("description");
        String url = body.get("url");
        String categoria = body.get("categoria");
        String autor = body.get("autor");

        MemeModel nuevoMeme = new MemeModel();
        nuevoMeme.setDescription(description);
        nuevoMeme.setUrl(url);
        nuevoMeme.setCategory(categoria);
        nuevoMeme.setAuthor(autor);

        memesServices.CreateMeme(nuevoMeme);
        return "memeOK";

    }

    @RequestMapping("/memes")
    public String memesAddForm() {

        return "memeAddForm";

    }

}

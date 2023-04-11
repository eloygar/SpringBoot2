package com.cebem.RickAndMorty.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class RickController {
    @GetMapping("/")
    public String saluda() {
        return "bienvenido a mi api rest de RickAndMorty";
    }

    @GetMapping("/random")
    public String random() {
        // si le concatenas una cadenqa vacia se convierte en una cadena
        return Math.round(Math.random() * 10) + "";
    }

    @GetMapping("/palindrome/{word}")
    public boolean palindrome(@PathVariable String word) {
        // es un palindromo
        StringBuilder sb = new StringBuilder(word);
        String invertWord = sb.reverse().toString();
        return invertWord.equalsIgnoreCase(word);
    }

}

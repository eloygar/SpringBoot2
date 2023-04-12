package com.cebem.RickAndMorty.controllers;

import java.text.MessageFormat;

import org.apache.el.util.MessageFactory;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.RickAndMorty.utils.Utils;

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
        // // es un palindromo
        // StringBuilder sb = new StringBuilder(word);
        return Utils.isPalindrome(word);
    }

    @GetMapping("/add")
    // http://localhost:8080/add?n1=2&n2=5
    public String add(@RequestParam String n1, @RequestParam String n2) {
        // // es un palindromo
        // StringBuilder sb = new StringBuilder(word);
        float s = Float.parseFloat(n1) + Float.parseFloat(n2);
        Object params[] = { n1, n2, s };
        return MessageFormat.format("la suma de {0} mas {1} es igual a {2}", params);
    }
    //guardar en el disco duro
    // @PostMapping("saveOnDisc")
    // public String saveOnDisck(){

    // }


}

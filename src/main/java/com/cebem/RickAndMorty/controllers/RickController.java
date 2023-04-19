package com.cebem.RickAndMorty.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.el.util.MessageFactory;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.RickAndMorty.utils.Utils;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*")
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
    // guardar en el disco duro

    @PostMapping("/saveOnDisk")
    public String saveOnDisk(@RequestParam Map<String, String> body) {
        String name = body.get("name");
        String price = body.get("price");
        String info = name + "" + price + "/n";

        try {
            Utils.writeOnDisk("datos.txt", info);
        } catch (IOException e) {
            return "Error al intentar escribir en el fichero";
        }

        return "Gracias por enviar el formulario, los datos se han guardado en el servidor";

    }

    @DeleteMapping("/removeFile")
    public String removeFile() {
        boolean result = Utils.remove("datos.txt");
        return result ? "borrado corecto" : "borrado incorrecto";

    }

    @GetMapping("/mayor")
    public String mayor(@RequestParam String num1, @RequestParam String num2, @RequestParam String num3) {
        try {
            float numero1 = Float.parseFloat(num1);
            float numero2 = Float.parseFloat(num2);
            float numero3 = Float.parseFloat(num3);

            // Comparar los números para encontrar el mayor
            float mayor = numero1;
            if (numero2 > mayor) {
                mayor = numero2;
            }
            if (numero3 > mayor) {
                mayor = numero3;
            }

            return "El mayor número es: " + mayor;

        } catch (NumberFormatException e) {
            return "ERROR: Alguno de los elementos no es un número válido";
        }
    }

    @GetMapping("/capitalizar")
    public String capitalizar(@RequestParam String frase) {
        String[] palabras = frase.split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                String primeraLetra = palabra.substring(0, 1).toUpperCase();
                String restoPalabra = palabra.substring(1).toLowerCase();
                resultado.append(primeraLetra).append(restoPalabra).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    @GetMapping("/info")
    public String obtenerInformacion() {
        try {
            String informacion = Utils.readFromDisk("datos.txt");
            return informacion;
        } catch (IOException e) {
            return "Error al intentar leer el archivo";
        }
    }

    @DeleteMapping("/emptyFile")
    public String emptyFile() {
        try {
            Utils.emptyFile("datos.txt");
        } catch (IOException e) {
            return "Error al intentar vaciar el fichero";
        }
        return "El fichero ha sido vaciado correctamente";
    }

    @RequestMapping("/vaciarFile")
    public String vaciarFile() {
        try {
            Utils.writeOnDisk("datos.txt", "");
        } catch (IOException e) {
            return "Error al intentar vaciar el fichero";
        }
        return "El fichero ha sido vaciado correctamente";
    }

    @GetMapping("/randomColors")
    public String[] randomColors() {
        String[] coloresBasicos = { "negro", "azul", "marrón", "gris", "verde", "naranja", "rosa", "púrpura", "rojo",
                "blanco", "amarillo" };
        String[] coloresAleatorios = new String[3];

        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int indiceAleatorio;
            do {
                indiceAleatorio = random.nextInt(coloresBasicos.length);
            } while (contains(coloresAleatorios, coloresBasicos[indiceAleatorio]));

            coloresAleatorios[i] = coloresBasicos[indiceAleatorio];
        }

        return coloresAleatorios;
    }

    private boolean contains(String[] array, String value) {
        for (String item : array) {
            if (item != null && item.equals(value)) {
                return true;
            }
        }
        return false;
    }

}

package com.cebem.RickAndMorty.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Utils {
    public static boolean isPalindrome( String word){
        StringBuilder sb = new StringBuilder(word);
        return word.equalsIgnoreCase(sb.reverse().toString());
    }

    
    public static void writeOnDisk(String fileName, String info) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            fw.write(info);
            ;
        } finally {
            if (fw != null)
                fw.close();
        }

    }

    public static boolean remove(String filename) {
        File f = new File(filename);
        boolean result = f.delete();
        return result;

    }
    public static String readFromDisk(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName)); 
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line); 
            }
        } finally {
            if (br != null) {
                br.close(); 
            }
        }
        return sb.toString();
    }
    public static float maxOfElements(float ...numeros){
        if(numeros==null||numeros.length==0){
            throw new NumberFormatException();
        }
        float elMayor =numeros[0];
        
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i]>elMayor)elMayor=numeros[i];
        }
        return elMayor;
    }

    public static void emptyFile(String archivoPath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(archivoPath));
        writer.print("");
        writer.close();
    }
    public static int getRandomValue(int max){
        return (int) Math.floor(Math.random() * max);
    }

}

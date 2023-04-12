package com.cebem.RickAndMorty.utils;

import java.io.File;
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
}

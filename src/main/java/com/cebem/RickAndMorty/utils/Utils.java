package com.cebem.RickAndMorty.utils;

public class Utils {
    public static boolean isPalindrome( String word){
        StringBuilder sb = new StringBuilder(word);
        return word.equalsIgnoreCase(sb.reverse().toString());
    }
}

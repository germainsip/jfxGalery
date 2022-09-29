package fr.tomoetek.jfxgalery.tools;

import java.util.regex.Pattern;

public class Verification {
    final static Pattern texte = Pattern.compile("\\p{IsAlphabetic}*$");
    final static Pattern num = Pattern.compile("\\d*$");

    public static boolean verifTexte(String champ){
        return texte.matcher(champ).matches()&(!champ.equals(""));
    }

    public static boolean verifNum(String champ){
        return num.matcher(champ).matches()&(!champ.equals(""));
    }
}



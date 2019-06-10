package com.opckev.JeuxEtMode.Utils;

import java.util.Scanner;

public class ControlUtils {
    //Permet le control de la taille et de la réponse donnée par le joueur
    //Retour d'exception en cas de lettre dans le nombre
    public static int test(int solution[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez rentrer un chiffre");

        boolean taille = false;
        boolean chiffres = false;
        boolean tb;
        String a;

        do {
            a = sc.next();
            if (a.length() == solution.length) {
                taille = true;
            } else {
                System.out.println("Vous devez choisir un nombre avec de "+solution.length+" chiffres");
            }
            try {
                Integer.parseInt(a);
                chiffres = true;
            } catch (NumberFormatException e) {
                System.out.println("Attention vous avez utilisé un caractère non autorisé. Ici seuls des chiffres sont attendus");
            }
            tb = chiffres && taille;
        }
        while (!tb);
        int c = Integer.parseInt(a);
        return c;
    }
}

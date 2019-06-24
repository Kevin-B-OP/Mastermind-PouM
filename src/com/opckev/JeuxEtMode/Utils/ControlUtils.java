package com.opckev.JeuxEtMode.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ControlUtils {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());
    /**
     * Permet de vérifier la taille et la validité de la proposition du joueur
     * Retour d'exception en cas de saisie de lettre
     */

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
                logger.info("Erreur de saisie",e);
                System.out.println("Attention vous avez utilisé un caractère non autorisé. Ici seuls des chiffres sont attendus");
            }
            tb = chiffres && taille;
        }
        while (!tb);
        int c = Integer.parseInt(a);
        return c;
    }
}

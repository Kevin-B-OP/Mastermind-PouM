package com.opckev.JeuxEtMode.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinUtils {

    private static Scanner sc = new Scanner(System.in);
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    /**
     * Programme que l'on retrouve à la fin de chaque partie et qui permet de savoir ce que veut maintenant faire le joueur
     * @return choix du joueur
     */

    public static int finMenu() {
        System.out.println("Que souhaitez vous faire maintenant ?");
        System.out.println("1 - Rejouer une partie");
        System.out.println("2 - Revenir au menu de sélection");
        System.out.println("3 - Quitter l'application");
        boolean continuer;
        int nbfin = -1;
        do {
            try{
                nbfin = sc.nextInt();
                if (nbfin <= 3&& nbfin>0) {
                    continuer = true;
                } else {
                    continuer = false;
                }
            }
            catch (InputMismatchException e){
                logger.info("Erreur de saisie");
                sc.next();
                System.out.println("Vous devez saisir un nombre correspondant au nombre du menu");
                continuer = false;
            }
        }
        while (!continuer);
        return nbfin;
    }
}

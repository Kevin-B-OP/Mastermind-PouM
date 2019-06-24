package com.opckev.JeuxEtMode.Utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    private static Scanner sc = new Scanner(System.in);

    /**
     * Programme que l'on retrouve sur les différents menu pour vérifier la saisie du joueur
     * @param options nombre de possibilités offertes par le menu
     * @return
     */

    public static int afficherMenu(int options) {
        boolean continuer;
        int nbresponse = -1;
        do {
            try{
                nbresponse = sc.nextInt();
                if (nbresponse <= options) {
                    continuer = true;
                } else {
                    continuer = false;
                }
            }
            catch (InputMismatchException e){
                logger.info("Erreur saisie de lettre",e);
                sc.next();
                System.out.println("ATTENTION : Vous devez saisir un nombre correspondant au nombre du menu");
                continuer = false;
            }
        }
        while (!continuer);
        return nbresponse;
    }
}

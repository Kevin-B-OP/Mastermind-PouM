package com.opckev.JeuxEtMode.Utils;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {

    private static Scanner sc = new Scanner(System.in);

    //Programme que l'on retrouve sur les différents menu pour vérifier la saisie du joueur
    public static int afficherMenu(String descriptif, int options) {
        boolean continuer;
        int nbresponse = -1;
        do {
            System.out.println(descriptif);
            try{
                nbresponse = sc.nextInt();
                if (nbresponse <= options) {
                    continuer = true;
                } else {
                    continuer = false;
                }
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("Vous devez saisir un nombre correspondant au nombre du menu");
                continuer = false;
            }
        }
        while (!continuer);
        return nbresponse;
    }
}

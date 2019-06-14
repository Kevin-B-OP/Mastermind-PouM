package com.opckev.JeuxEtMode.Utils.Mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Beginner {
    //Tirage au sort du mode duel mastermind pour savoir qui commence
    public static int mastermindDuel() {
        int retour;
        System.out.println("");
        System.out.println("Maintenant voici un petit tirage au sort pour savoir qui commencera à deviner et donc à potentiellement marquer des points.");
        System.out.println("Pour cela que choisissez vous entre : ");
        System.out.println("1 - Pile");
        System.out.println("2 - Face");
        int a=-1;
        boolean bon;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                a = sc.nextInt();
                if (a == 1 || a == 2) {
                    bon = true;
                } else {
                    System.out.println("Veuillez choisir entre 1 (pile) et 2 (face)");
                    bon = false;
                }
            } catch (NumberFormatException|InputMismatchException e) {
                System.out.println("Veuillez rentrer le chiffre correspondant à votre choix");
                bon = false;
            }
        }
        while (!bon);
        int random = (int) (Math.random() * (2 - 1)) + 1;
        if (random==a){
            System.out.println("Vous avez gagné le tirage au sort");
            System.out.println("");
            retour = 1;
        }
        else{
            System.out.println("Vous avez perdu le tirage au sort");
            System.out.println("");
            System.out.println(random);
            retour = 2;
        }
        return retour;
    }
}

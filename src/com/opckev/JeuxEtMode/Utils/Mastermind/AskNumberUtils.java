package com.opckev.JeuxEtMode.Utils.Mastermind;

import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AskNumberUtils {

    public static int mastermind1() {
        //Coté joueur : permet de sélectionner la taille du chiffre dans le mode défenseur

        int nbMax = NumberUtils.max();
        int nbMin = NumberUtils.min();
        int proposition=-1;

        boolean taille = false;
        
        do {
            System.out.println("Choisissez la taille du nombre. Il doit être compris entre " + nbMin + " et " + nbMax);
            try {
                Scanner sc = new Scanner(System.in);
                proposition = sc.nextInt();
                taille = proposition >= nbMin && proposition <= nbMax;
                if (!taille) {
                    System.out.println("Une erreur a été repéré lors de votre saisie");
                }

            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println("Veuillez rentrer un nombre sans utiliser la moindre lettre");
            }
            
        }
        while (!taille);

        return proposition;
    }

    public static String mastermind2(int NB_CHIFFRES) {
        //Côté joueur, permet à ce dernier de choisir le chiffre que l'ordi devra deviner


        boolean taille;
        boolean chiffres;
        String solution;
        boolean tb;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez rentrer le chiffre que devra deviner l'ordinateur :");
            solution = sc.next();
            if (solution.length() == NB_CHIFFRES) {
                taille = true;
            } else {
                System.out.println("Vous devez choisir nombre ayant excatement " + NB_CHIFFRES + " chiffres");
                taille = false;
            }
            try {
                Integer.parseInt(solution);
                chiffres = true;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez rentrer un nombre sans utiliser la moindre lettre");
                chiffres = false;
            }
            tb = chiffres && taille;
        }
        while (!tb);
       return solution;
    }
}

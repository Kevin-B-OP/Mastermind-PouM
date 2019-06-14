package com.opckev.JeuxEtMode.PouM;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.PouM.PouMDef;
import com.opckev.JeuxEtMode.Utils.PouM.Score2Utils;


import java.util.Random;
import java.util.Scanner;

public class PouMDefenseur {
    Scanner sc = new Scanner (System.in);
    int scoreOrdi = 0;
    public void mode2 () {

        int ESSAIS_MAX=NumberUtils.essai();
        System.out.println("");
        final int MAX = 9;
        //Le choix de la taille du nombre est définie par le joueur qui devra choisir entre les deux valeurs extrêmes
        int NB_CHIFFRES= AskNumberUtils.mastermind1();

        final int[] solution = new int[NB_CHIFFRES];

        //Permet au joueur de donner son chiffre
        String nbInitial = AskNumberUtils.mastermind2(NB_CHIFFRES);
        int nombreSaisi = Integer.parseInt(nbInitial);

        //Permet de rentrer le nombre donné par le joueur dans un tableau
        for (int i = 0; i < NB_CHIFFRES; i++)
            solution[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

        int count = 0;

        //Partie Ordinateur
        System.out.println("Mastermind mode défenseur : l'ordinateur va essayer de trouver votre combinaison de chiffres" + MAX + ".");
        System.out.println("Il a le droit à " + ESSAIS_MAX + " essais");
        System.out.println("----------------------------");


        int[][] chiffres = new int[NB_CHIFFRES][2];
        boolean victoire=false;
        //Boucle dans laquelle l'ordinateur va faire différentes propositions en essayant de trouver la solution
        //Système de vérification via la classe ScoreUtils
        victoire= PouMDef.ordiPouM(solution,ESSAIS_MAX);

            if (!victoire) {
                System.out.println("Bravo, vous avez réussie à épuiser les " + ESSAIS_MAX + " essais dont l'ordinateur disposait.");
            }
            else if (victoire) {
                scoreOrdi++;
                System.out.println("Pas de chance, l'ordinateur a relevé le défi.");
                System.out.println("Le score de l'ordinateur est de " + scoreOrdi + " point(s)");
            }
        System.out.println(" ");
        fin();
    }
    public void fin() {
        //Menu de fin de jeu
        int nbfin5= FinUtils.finMenu();
        System.out.println(" ");
        if (nbfin5==1){
            System.out.println(" ");
            mode2();
        }
        else if (nbfin5==2){
            System.out.println(" ");
            Appli Menu = new Appli();
            Menu.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}
package com.opckev.JeuxEtMode.Utils.Mastermind;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.FinUtils;

import java.util.Arrays;
import java.util.Random;

public class MDef {
    public static boolean modeDefenseur(int NB_CHIFFRES){
        int ESSAIS_MAX=NumberUtils.essai();
        final int MAX = 9;
        //Le choix de la taille du nombre est définie par le joueur qui devra choisir entre les deux valeurs extrêmes

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


        int[] chiffres = new int[NB_CHIFFRES];
        boolean victoire;
        //Boucle dans laquelle l'ordinateur va faire différentes propositions en essayant de trouver la solution
        //Système de vérification via la classe ScoreUtils
        do {
            System.out.println("\nEssai n° " + (count + 1) + "/" + ESSAIS_MAX + " :");


            Random r = new Random();
            for (int i = 0; i < NB_CHIFFRES; i++) {
                chiffres[i] = r.nextInt(MAX + 1);
            }


            int vrai [] = ScoreUtils.comptage(chiffres,solution);
            int present[] = ScoreUtils.comptage2(chiffres,solution);
            System.out.println(ScoreUtils.phraseOrdi(vrai,present,chiffres));
            victoire = vrai[0]==solution.length;

            count++;

            if (count == ESSAIS_MAX) {
                System.out.println("Bravo, vous avez réussié à épuiser les " + ESSAIS_MAX + " essais dont l'ordinateur disposait.");
            } else if (count < ESSAIS_MAX && victoire) {
                System.out.println("Pas de chance, l'ordinateur a relevé le défi en " + count + " coups");
            }

        }
        //Boucle avec pour condition le boolean victoire et le nombre de tentatives
        while (!victoire && count < ESSAIS_MAX);
        return victoire;
    }
}

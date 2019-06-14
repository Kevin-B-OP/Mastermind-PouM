package com.opckev.JeuxEtMode.Utils.PouM.Duel;

import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.PouM.PouMDef;

public class PDef {
    public static boolean modeDuel (int taille) {

        int ESSAIS_MAX= NumberUtils.essai();
        System.out.println("");
        final int MAX = 9;
        //Le choix de la taille du nombre est définie par le joueur qui devra choisir entre les deux valeurs extrêmes
        int NB_CHIFFRES= taille;

        final int[] solution = new int[NB_CHIFFRES];

        //Permet au joueur de donner son chiffre
        String nbInitial = AskNumberUtils.mastermind2(NB_CHIFFRES);
        int nombreSaisi = Integer.parseInt(nbInitial);

        //Permet de rentrer le nombre donné par le joueur dans un tableau
        for (int i = 0; i < NB_CHIFFRES; i++)
            solution[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

        //Partie Ordinateur
        System.out.println("Mastermind mode défenseur : l'ordinateur va essayer de trouver votre combinaison de chiffres" + MAX + ".");
        System.out.println("Il a le droit à " + ESSAIS_MAX + " essais");
        System.out.println("----------------------------");

        //On récupère le fait que l'ordinateur ait gagné ou non
        //Toute la partie proposition se passe dans cette class
        boolean victoire= PouMDef.ordiPouM(solution,ESSAIS_MAX);

        //Message si l'ordi perd
        if (!victoire) {
            System.out.println("Bravo, vous avez réussie à épuiser les " + ESSAIS_MAX + " essais dont l'ordinateur disposait.");
        }
        //Message si l'ordi gagne
        else if (victoire) {
            System.out.println("Pas de chance, l'ordinateur a relevé le défi.");
        }
        System.out.println(" ");
        return victoire;
    }
}

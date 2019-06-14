package com.opckev.JeuxEtMode.Mastermind;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.ScoreUtils;

import java.util.Random;

public class MastermindDefenseur {

    int scoreOrdi = 0;
    //Mode de jeu mastermind ou l'ordinateur doit trouver la proposition du joueur
    public void mode5 () {

        int ESSAIS_MAX=NumberUtils.essai();
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


        int[] chiffres = new int[NB_CHIFFRES];
        boolean victoire=false;
        //Boucle dans laquelle l'ordinateur va faire différentes propositions en essayant de trouver la solution
        //Système de vérification via la classe ScoreUtils
        do {
            System.out.println("\nEssai n° " + (count + 1) + "/" + ESSAIS_MAX + " :");

            //Proposition de l'ordinateur et création d'un tableau pour collecter les chiffres
            Random r = new Random();
            for (int i = 0; i < NB_CHIFFRES; i++) {
                chiffres[i]= r.nextInt(MAX + 1);
            }

            //Compte le nombre de chiffres bien placés
            int vrai [] = ScoreUtils.comptage(chiffres,solution);

            //Compte le nombre de chiffres présents mais mal placés
            int present = ScoreUtils.present(chiffres,solution,vrai) ;

            //Phrases faisant un résumé entre la proposition de l'ordi et la solution
            System.out.println(ScoreUtils.phraseEtape(vrai,present,nombreSaisi));
            //Permet de voir si l'ordi a trouvé à 100% la solution
            int bienPlace=ScoreUtils.bienPlace(vrai);
            if (bienPlace == NB_CHIFFRES){
                victoire=true;
            }

            count++;

            if (count == ESSAIS_MAX) {
                //Phrase si l'ordi dépasse le nombre de tentatives
                System.out.println("Bravo, vous avez réussie à épuiser les " + ESSAIS_MAX + " essais dont l'ordinateur disposait.");
            } else if (count < ESSAIS_MAX && victoire) {
                //Phrase si l'ordi trouve la solution
                scoreOrdi++;
                System.out.println("Pas de chance, l'ordinateur a relevé le défi en " + count + " coups");
                System.out.println("Le score de l'ordinateur est de " + scoreOrdi + " point(s)");
            }

        }
        //Boucle avec pour condition le boolean victoire et le nombre de tentatives
        while (!victoire && count < ESSAIS_MAX);
        System.out.println(" ");
        fin();
    }
    public void fin() {
        //Menu de fin de jeu pour refaire une partie, repartir au menu ou arrêter la.
        int nbfin5= FinUtils.finMenu();
        System.out.println(" ");
        if (nbfin5==1){
            System.out.println(" ");
            mode5();
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

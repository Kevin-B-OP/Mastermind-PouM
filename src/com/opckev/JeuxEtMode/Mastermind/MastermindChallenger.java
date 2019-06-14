package com.opckev.JeuxEtMode.Mastermind;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.*;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.ScoreUtils;

import java.util.Arrays;
import java.util.Random;

public class MastermindChallenger {

    int scoreJoueur = 0;

    //Mode de jeu Mastermind ou le joueur doit deviner le chiffre de l'ordi
    public void mode4 () {

        //Récupération des données dans le fichier properties
        int nbMax = NumberUtils.max();
        int nbMin = NumberUtils.min();
        int ESSAIS_MAX = NumberUtils.essai();

        //Permet de choisir la taille du chiffre à deviner de manière aléatoire (ordi)
        //Le chiffre aléatoirement donné est compris entre nbMax et nbMin
        final int NB_CHIFFRES = (int) (Math.random() * (nbMax - nbMin)) + nbMin;
        final int MAX = 9;

        //Initialise le tableau du chiffre à deviner;
        //Nb_chiffres = taille du chiffre définie précédemment dans le fichier prop
        final int[] solution = new int[NB_CHIFFRES];

        //Chiffre à deviner, proposé par l'ordinateur (ordi)
        //Remplissage du tableau case par case
        Random r = new Random();
        for (int i = 0; i < NB_CHIFFRES; i++) {
            solution[i] = r.nextInt(MAX + 1);
        }

        //Variable comptant le nombre de tentatives
        int count = 0;

        //Partie du joueur avec un rappel des règles
        System.out.println("Mastermind, trouvez la combinaison des " + NB_CHIFFRES + " chiffres entre 0 et " + MAX + ".");
        System.out.println("Attention, vous avez droit à " + ESSAIS_MAX + " essais");
        System.out.println("----------------------------");

        //Initialisation du tableau pour le chiffre du joueur
        int[] chiffres = new int[NB_CHIFFRES];

        boolean victoire = false;
        //Boucle permettant au joueur de rentrer une proposition
        do {
            System.out.print("\nEssai n° " + (count + 1) + "/" + ESSAIS_MAX + ", ");

            //Capture la proposition du joueur
            int nombreSaisi = ControlUtils.test(solution);
            //Range la proposition du joueur dans un tableau
            for (int i = 0; i < NB_CHIFFRES; i++)
                chiffres[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

            //Compte le nombre de chiffres bien placés via un tableau rempli de 1 et de 0
            int vrai[] = ScoreUtils.comptage(chiffres, solution);
            //Calcule le nombre de chiffres mal placés mais présents dans la solution
            int present = ScoreUtils.present(chiffres, solution, vrai);
            //Phrases annonçants au joueur les similitudes entre sa proposition et la solution
            System.out.println(ScoreUtils.phraseEtape(vrai, present, nombreSaisi));
            //Permet de voir si le joueur a trouvé à 100% la solution
            int bienPlace = ScoreUtils.bienPlace(vrai);
            if (bienPlace == NB_CHIFFRES) {
                victoire = true;
            }

            count++;

            if (count == ESSAIS_MAX) {
                //Message si jamais le joueur dépasse le nombre de tentatives
                System.out.println("He non, vous avez epuisé vos " + ESSAIS_MAX + " essais, c'est perdu pour vous...");
                System.out.println("La bonne combinaison était " + Arrays.toString(solution));
            } else if (count < ESSAIS_MAX && victoire) {
                //Message si jamais le joueur trouve la solution avant de n'avoir plus de tentatives + 1 point ajouté à son score
                scoreJoueur++;
                System.out.println("Bravo, vous avez réussi en seulement " + count + " coups");
                System.out.println("Votre score est de " + scoreJoueur + " point(s)");
            }

        }
        //La boucle s'arrête en cas de victoire ou si le joueur n'a plus de tentatives disponibles
        while (!victoire && count < ESSAIS_MAX);
        System.out.println(" ");
        fin();
    }
        public void fin() {
        //Menu de fin de jeu pour refaire une partie, repartir au menu ou arrêter la.
        int nbfin4= FinUtils.finMenu();
        System.out.println(" ");
        if (nbfin4==1){
            mode4();
        }
        else if (nbfin4==2){
            Appli.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}

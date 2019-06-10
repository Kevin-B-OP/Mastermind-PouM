package com.opckev.JeuxEtMode.Mastermind;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.*;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.ScoreUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MastermindChallenger {

    Scanner sc = new Scanner (System.in);
    int scoreJoueur = 0;

    public void mode4 (){

        int nbMax= NumberUtils.max();
        int nbMin = NumberUtils.min();
        int ESSAIS_MAX=NumberUtils.essai();

        //Permet de choisir la taille du chiffre à deviner de manière aléatoire (ordi)
        final int NB_CHIFFRES = (int) (Math.random() * (nbMax - nbMin)) + nbMin;
        final int MAX = 9;

        //Chiffre à deviner, proposé par l'ordinateur (ordi)
        final int[] solution = new int[NB_CHIFFRES];

        Random r = new Random();
        for(int i=0 ; i<NB_CHIFFRES ; i++) {
            solution[i] = r.nextInt(MAX+1);
        }


        int count = 0;

        //Partie du joueur avec un rappel des règles
        System.out.println("Mastermind, trouvez la combinaison des " + NB_CHIFFRES + " chiffres entre 0 et " + MAX + ".");
        System.out.println("Attention, vous avez droit à " + ESSAIS_MAX + " essais");
        System.out.println("----------------------------");

        int[] chiffres = new int[NB_CHIFFRES];
        boolean victoire = false;
        //Boucle permettant au joueur de rentrer une proposition
        //Fonction permettant de vérifier sa réponse : ScoreUtils
        do {
            System.out.print("\nEssai n° " + (count+1) + "/" + ESSAIS_MAX + ", ");

            int nombreSaisi = ControlUtils.test(solution);
            for (int i = 0; i < NB_CHIFFRES; i++)
                chiffres[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

            int vrai [] = ScoreUtils.comptage(chiffres,solution);
            int present[] = ScoreUtils.comptage2(chiffres,solution);
            System.out.println(ScoreUtils.phraseEtape(vrai,present,nombreSaisi));
            if (vrai[0] == NB_CHIFFRES){
                victoire=true;
            }

            count++;

            //Si le joueur gagne ou s'il perd le message est différent.
            //Cela se base sur la variable boolean victoire et le int count
            //count permettant de compter le nombre de tentatives du joueur
            if(count == ESSAIS_MAX) {
                System.out.println("He non, vous avez epuisé vos " + ESSAIS_MAX + " essais, c'est perdu pour vous...");
                System.out.println("La bonne combinaison était "+ Arrays.toString(solution));
            }else if (count < ESSAIS_MAX && victoire){
                scoreJoueur++;
                System.out.println("Bravo, vous avez réussi en seulement "+count+ " coups");
                System.out.println("Votre score est de "+scoreJoueur+" point(s)");
            }

        }
        //La boucle s'arrête en cas de victoire ou si le joueur n'a plus de tentatives disponibles
        while(!victoire && count < ESSAIS_MAX);
        System.out.println(" ");

        //Menu de fin de jeu fonctionnant grâce à FinUtils
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

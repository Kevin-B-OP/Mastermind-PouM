package com.opckev.JeuxEtMode.Utils.PouM.Duel;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.ControlUtils;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.PouM.Score2Utils;

import java.util.Arrays;
import java.util.Random;

public class PChall {

    //Mode de jeu Plus ou Moins ou le joueur doit trouver le chiffre de l'ordinateur pour le mode duel
    public static boolean modeDuel(int taille) {

        //Récupération des données du fichier prop
        int nbMax = NumberUtils.max();
        int nbMin = NumberUtils.min();
        int ESSAIS_MAX = NumberUtils.essai();

        //Permet de choisir la taille du chiffre à deviner de manière aléatoire (ordi)
        final int NB_CHIFFRES = taille;
        final int MAX = 9;

        final int[] solution = new int[NB_CHIFFRES];

        //Remplissage du tableau avec les chiffres du nombre à deviner
        Random r = new Random();
        for (int i = 0; i < NB_CHIFFRES; i++) {
            solution[i] = r.nextInt(MAX + 1);
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
            System.out.print("\nEssai n° " + (count + 1) + "/" + ESSAIS_MAX + ", ");

            //Vérifie la taille et la validité du nombre donné par le joueur
            int nombreSaisi = ControlUtils.test(solution);
            //Rentre le nombre du joueur dans un tableau
            for (int i = 0; i < NB_CHIFFRES; i++)
                chiffres[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

            //Permet de faire la comparaison entre le nombre du joueur et la solution et de l'afficher
            String retour = Score2Utils.comptage(chiffres, solution);
            System.out.println("Résultat pour " + nombreSaisi + " => " + retour);

            //Permet de savoir si le joueur a trouvé à 100% la réponse
            int vrai = Score2Utils.verification(chiffres, solution);
            if (vrai == NB_CHIFFRES) {
                victoire = true;
            }

            count++;

            //Message si le joueur ne trouve pas la solution
            if (count == ESSAIS_MAX) {
                System.out.println("He non, vous avez epuisé vos " + ESSAIS_MAX + " essais, c'est perdu pour vous...");
                System.out.println("La bonne combinaison était " + Arrays.toString(solution));
            }
            //Message si le joueur trouve la réponse à temps
            else if (count < ESSAIS_MAX && victoire) {
                System.out.println("Bravo, vous avez réussi en seulement " + count + " coups");
            }

        }
        //La boucle s'arrête en cas de victoire ou si le joueur n'a plus de tentatives disponibles
        while (!victoire && count < ESSAIS_MAX);
        return victoire;
    }
}
